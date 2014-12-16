package masfraud.specialist.agent.saveMember.command;

import masfraud.base.constants.ContextKeySpecialist;
import masfraud.base.constants.EventActionType;
import masfraud.base.constants.EventType;
import masfraud.base.to.MemberTO;
import masfraud.specialist.agent.base.command.CommandBase;
import masfraud.specialist.agent.factory.BeanFactory;
import masfraud.specialist.agent.saveMember.dao.MemberMongoDAO;
import org.apache.commons.chain.Context;

/**
 * Created with IntelliJ IDEA.
 * User: sorge
 * Date: 12/2/14
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaveMemberCommand extends CommandBase {

    private MemberMongoDAO memberMongoDAO = BeanFactory.getMemberMongoDAO();


    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("SaveMemberCommand");

        if (!context.containsKey(ContextKeySpecialist.MEMBER_TO.getValue())){
            System.err.println("Chave " + ContextKeySpecialist.MEMBER_TO.getValue() + " nao existe no context.");
            return false;
        }


        FindMemberCommand findMemberCommand = BeanFactory.getFindMemberCommand();

        //Recebe o member que esta vindo preenchido do arquivo
        MemberTO memberTO = (MemberTO) context.get(ContextKeySpecialist.MEMBER_TO.getValue());

        //Executa a command que faz a verificacao se o member existe
        if (findMemberCommand.execute(context)){

            //Recebe o meber da command, se encontrou entao eh que o member jah existe
            MemberTO memberTORetorno = (MemberTO) context.get(ContextKeySpecialist.MEMBER_TO.getValue());

            //Se nao encontrou grava o member que esta vindo do arquivo como memberTO
            if (memberTORetorno == null){
                memberMongoDAO.insert(memberTO);
                System.out.println("Member salvo com sucesso.");
                return true;
            }
        }

        return false;
    }

    @Override
    public EventActionType getEventActionType() {
        return EventActionType.INSERT_MEMBER;
    }

    @Override
    public EventType getEventType() {
        return EventType.SAVE_MEMBER;
    }


}
