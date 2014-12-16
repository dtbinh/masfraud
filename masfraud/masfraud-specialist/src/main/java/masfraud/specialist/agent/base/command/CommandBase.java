package masfraud.specialist.agent.base.command;

import com.google.gson.Gson;
import masfraud.base.constants.ContextKey;
import masfraud.base.constants.ContextKeySpecialist;
import masfraud.base.constants.EventActionType;
import masfraud.base.constants.EventType;
import masfraud.base.to.*;
import masfraud.specialist.agent.accrual.dao.AccrualMongoDAO;
import masfraud.specialist.agent.base.dao.EventMongoDAO;
import masfraud.specialist.agent.factory.BeanFactory;
import masfraud.specialist.agent.profile.dao.ProfileMongoDAO;
import masfraud.specialist.agent.redemption.dao.RedemptionMongoDAO;
import masfraud.specialist.agent.saveMember.command.FindMemberCommand;
import masfraud.specialist.agent.saveMember.command.SaveMemberCommand;
import masfraud.specialist.agent.saveMember.command.UpdateMemberCommand;
import masfraud.specialist.agent.saveMember.dao.MemberMongoDAO;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.bson.types.ObjectId;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sorge
 * Date: 12/9/14
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */

public class CommandBase implements Command {

    private EventMongoDAO eventMongoDAO = BeanFactory.getEventMongoDAO();
    private RedemptionMongoDAO redemptionMongoDAO = BeanFactory.getRedemptionMongoDAO();
    private AccrualMongoDAO accrualMongoDAO = BeanFactory.getAccrualMongoDAO();
    private ProfileMongoDAO profileMongoDAO = BeanFactory.getProfileMongoDAO();
    private EventActionType eventActionType;
    private EventType eventType;

    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("CommandBase");

        String msg = (String) context.get(ContextKey.STRING_MESSAGE.getValue());
        ObjectParse objectParse = new Gson().fromJson(msg, ObjectParse.class);


        if (getEventType().equals(EventType.SAVE_MEMBER)){
            return enginerMember(objectParse.getMemberTO(), context);
        }
        else if (getEventType().equals(EventType.ACCRUAL)){
            return enginerAccrual(objectParse.getAccrualLogTO(), context);
        }
        else if (getEventType().equals(EventType.REDEMPTION)){
            return enginerRedemption(objectParse.getRedemptionLogTO(),context);
        }
        else if (getEventType().equals(EventType.PROFILE)){
            return enginerProfile(objectParse.getMemberTO(), context);
        }

        return true;
    }

    private boolean enginerRedemption(RedemptionLogTO redemptionLogTO, Context context) throws Exception {
        FindMemberCommand findMemberCommand = BeanFactory.getFindMemberCommand();

        //Cria o contexto somente para mandar para a command
        context.put(ContextKeySpecialist.MEMBER_TO.getValue(), redemptionLogTO.getMemberTO());
        findMemberCommand.execute(context);
        MemberTO memberTO = (MemberTO) context.get(ContextKeySpecialist.MEMBER_TO.getValue());

        //Member existe para poder fazer o accrual
        if (memberTO != null){

            //Salva o event
            ObjectId objectId = saveEvent(redemptionLogTO.getMemberTO(), getEventActionType(), getEventType());
            redemptionLogTO.setId(objectId);

            //Salva o AccrualLogTO
            System.out.println("saveRedemptionLogTO");
            redemptionMongoDAO.insert(redemptionLogTO);
            System.out.println("Registro finalizado com sucesso.");
        }
        else {
            System.err.println("Nao existe o member " + redemptionLogTO.getMemberTO().getTokens().get(0).getPrimaryValue() + " para poder realizar o Redemption.");
            return false;
        }

        return true;
    }

    private boolean enginerAccrual(AccrualLogTO accrualLogTO, Context context) throws Exception {
        FindMemberCommand findMemberCommand = BeanFactory.getFindMemberCommand();

        //Cria o contexto somente para mandar para a command
        context.put(ContextKeySpecialist.MEMBER_TO.getValue(), accrualLogTO.getMemberTO());
        findMemberCommand.execute(context);
        MemberTO memberTO = (MemberTO) context.get(ContextKeySpecialist.MEMBER_TO.getValue());

        //Member existe para poder fazer o accrual
        if (memberTO != null){

            //Salva o event
            ObjectId objectId = saveEvent(accrualLogTO.getMemberTO(), getEventActionType(), getEventType());
            accrualLogTO.setId(objectId);

            //Salva o AccrualLogTO
            System.out.println("saveAccrualLogTO");
            accrualMongoDAO.insert(accrualLogTO);
            System.out.println("Registro finalizado com sucesso.");
        }
        else {
            System.err.println("Nao existe o member " + accrualLogTO.getMemberTO().getTokens().get(0).getPrimaryValue() + " para poder realizar o Credito.");
            return false;
        }

        return true;
    }

    private boolean enginerMember(MemberTO memberTO, Context context) throws Exception {
        System.out.println("enginerMember");

        context.put(ContextKeySpecialist.MEMBER_TO.getValue(), memberTO);

        //Salva o member {Verifica se ele existe ou nao}
        SaveMemberCommand saveMemberCommand = BeanFactory.getSaveMemberCommand();

        //Caso o member jah exista, entao nao devera realizar nenhuma outra acao.
        if (saveMemberCommand.execute(context)){

            //Salva o event e retorna o ObjectId para o especifico
            ObjectId objectId = saveEvent(memberTO, getEventActionType(), getEventType());

            //Salva a collection Profile
            saveProfile(objectId, memberTO);
            System.out.println("Registro finalizado com sucesso.");
        }
        //Member jah exite
        else {
            System.err.println("Member ja existe com esse token: " + memberTO.getTokens().get(0).getPrimaryValue());
            return false;
        }

        return true;
    }

    public boolean enginerProfile(MemberTO memberTO, Context context) throws Exception {
        System.out.println("enginerProfile");


        //Update para o address
        FindMemberCommand findMemberCommand = BeanFactory.getFindMemberCommand();

        //Cria o contexto somente para mandar para a command
        context.put(ContextKeySpecialist.MEMBER_TO.getValue(), memberTO);

        findMemberCommand.execute(context);

        //Member existe para poder fazer o o update
        if (context.get(ContextKeySpecialist.MEMBER_TO.getValue()) != null){

            String msg = (String) context.get(ContextKey.STRING_MESSAGE.getValue());
            ObjectParse objectParse = new Gson().fromJson(msg, ObjectParse.class);
            //Member original
            MemberTO memberTOArquivo = objectParse.getMemberTO();
            MemberTO memberTOBd = (MemberTO) context.get(ContextKeySpecialist.MEMBER_TO.getValue());
            memberTOArquivo.setId(memberTOBd.getId());

             //Varre os enderecos que jah existem para o member, e add os que estao vindo no arquivo.
            if (memberTOBd.getDeliveryAddress() != null && !memberTOBd.getDeliveryAddress().isEmpty()){
                memberTOBd.getDeliveryAddress().add(memberTOArquivo.getDeliveryAddress().get(0));
            }
            else {
                memberTOBd.setDeliveryAddress(memberTOArquivo.getDeliveryAddress());
            }

            //Coloca o member com o Id e os novo + os antigos address
            context.put(ContextKeySpecialist.MEMBER_TO.getValue(), memberTOBd);

            UpdateMemberCommand updateMemberCommand = BeanFactory.getUpdateMemberCommand();

            //Realiza o update do member para o address
            updateMemberCommand.execute(context);

            //Salva o event e retorna o ObjectId para o especifico
            ObjectId objectId = saveEvent(memberTO, getEventActionType(), getEventType());

            //Salva a collection Profile
            saveProfile(objectId, memberTO);
            System.out.println("Registro finalizado com sucesso.");

        }
        else {
            System.err.println("Nao existe o member " + memberTO.getMemberTO().getTokens().get(0).getPrimaryValue() + " para poder realizar o Update Address Delivery.");
            return false;
        }

        return true;
    }



    private ObjectId saveEvent(MemberTO memberTO, EventActionType eventActionType, EventType eventType) throws Exception {
        System.out.println("saveEvent");
        EventLogTO eventLogTO = BeanFactory.getEventLogTO();
        eventLogTO.setMemberTO(memberTO.newMemberOnlyToken());
        eventLogTO.setEventDate(new Date());
        eventLogTO.setEventActionType(eventActionType);
        eventLogTO.setEventType(eventType);
        eventLogTO = eventMongoDAO.insert(eventLogTO);
        return eventLogTO.getId();
    }

    private void saveProfile(ObjectId objectId, MemberTO memberTO) throws Exception {
        System.out.println("saveProfile");
        //Cria o objeto especifico para ser salvo
        ProfileLogTO profileLogTO = new ProfileLogTO();
        profileLogTO.setId(objectId);
        profileLogTO.setMemberTO(memberTO.newMemberOnlyToken());
        profileLogTO.setEventDate(memberTO.getEventDate());
        profileLogTO.setEventPayload(memberTO.getEventPayload());

        //Salva o especifico
        profileMongoDAO.insert(profileLogTO);
    }

    public EventActionType getEventActionType() {
        return eventActionType;
    }

    public void setEventActionType(EventActionType eventActionType) {
        this.eventActionType = eventActionType;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
