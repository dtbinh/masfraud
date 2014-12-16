package masfraud.specialist.agent.factory;

import masfraud.base.to.AlertLogTO;
import masfraud.base.to.EventLogTO;
import masfraud.specialist.agent.accrual.dao.AccrualMongoDAO;
import masfraud.specialist.agent.alert.command.SaveAlertCommand;
import masfraud.specialist.agent.alert.dao.AlertMongoDAO;
import masfraud.specialist.agent.profile.dao.ProfileMongoDAO;
import masfraud.specialist.agent.base.dao.EventMongoDAO;
import masfraud.specialist.agent.redemption.dao.RedemptionMongoDAO;
import masfraud.specialist.agent.saveMember.command.FindMemberCommand;
import masfraud.specialist.agent.saveMember.command.SaveMemberCommand;
import masfraud.specialist.agent.saveMember.command.UpdateMemberCommand;
import masfraud.specialist.agent.saveMember.dao.MemberMongoDAO;

/**
 * Created with IntelliJ IDEA.
 * User: sorge
 * Date: 12/2/14
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class BeanFactory {


    private static AccrualMongoDAO accrualMongoDAO;
    private static AlertMongoDAO alertMongoDAO;
    private static SaveAlertCommand saveAlertCommand;
    private static AlertLogTO alertLogTO;
    private static ProfileMongoDAO profileMongoDAO;
    private static MemberMongoDAO memberMongoDAO;
    private static EventMongoDAO eventMongoDAO;
    private static EventLogTO evenLogTO;
    private static SaveMemberCommand saveMemberCommand;
    private static FindMemberCommand findMemberCommand;
    private static UpdateMemberCommand updateMemberCommand;
    private static RedemptionMongoDAO redemptionMongoDAO;


    private BeanFactory(){
    }


    public static AccrualMongoDAO getAccrualMongoDAO(){
        if (accrualMongoDAO == null){
            accrualMongoDAO = new AccrualMongoDAO();
        }
        return accrualMongoDAO;
    }

    public static AlertMongoDAO getAlertMongoDAO(){
        if (alertMongoDAO == null){
            alertMongoDAO = new AlertMongoDAO();
        }
        return alertMongoDAO;
    }


    public static SaveAlertCommand getSaveAlertCommand() {
        saveAlertCommand = new SaveAlertCommand();
        return saveAlertCommand;
    }

    public static AlertLogTO getAlertLogTO() {
        return alertLogTO = new AlertLogTO();
    }

    public static ProfileMongoDAO getProfileMongoDAO() {
        if (profileMongoDAO == null){
            profileMongoDAO = new ProfileMongoDAO();
        }
        return profileMongoDAO;
    }

    public static MemberMongoDAO getMemberMongoDAO() {
        if (memberMongoDAO == null){
            memberMongoDAO = new MemberMongoDAO();
        }
        return memberMongoDAO;
    }

    public static EventMongoDAO getEventMongoDAO() {
        if (eventMongoDAO == null){
            eventMongoDAO = new EventMongoDAO();
        }
        return eventMongoDAO;
    }

    public static EventLogTO getEventLogTO() {
        return evenLogTO = new EventLogTO();
    }

    public static SaveMemberCommand getSaveMemberCommand() {
        saveMemberCommand = new SaveMemberCommand();
        return saveMemberCommand;
    }

    public static FindMemberCommand getFindMemberCommand() {
        findMemberCommand = new FindMemberCommand();
        return findMemberCommand;
    }

    public static UpdateMemberCommand getUpdateMemberCommand() {
        updateMemberCommand = new UpdateMemberCommand();
        return updateMemberCommand;
    }

    public static RedemptionMongoDAO getRedemptionMongoDAO() {
        if (redemptionMongoDAO == null){
            redemptionMongoDAO = new RedemptionMongoDAO();
        }
        return redemptionMongoDAO;
    }
}
