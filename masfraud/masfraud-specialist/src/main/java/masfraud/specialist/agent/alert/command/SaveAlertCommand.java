package masfraud.specialist.agent.alert.command;

import masfraud.base.constants.ContextKeySpecialist;
import masfraud.base.constants.EnvironmentConstants;
import masfraud.base.to.AlertLogTO;
import masfraud.base.to.DetectionRuleTO;
import masfraud.base.to.EventLogTO;
import masfraud.base.to.NotificationTO;
import masfraud.specialist.agent.alert.dao.AlertMongoDAO;
import masfraud.specialist.agent.factory.BeanFactory;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import java.util.List;


public class SaveAlertCommand implements Command {

    private AlertMongoDAO alertMongoDAO = BeanFactory.getAlertMongoDAO();


    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("SaveAlertCommand");


        if (!context.containsKey(EnvironmentConstants.DETECTION_RULE_TOs.getValue())){
            System.err.println("Chave " + EnvironmentConstants.DETECTION_RULE_TOs.getValue() + " nao existe no context.");
            return false;
        }
        else if (!context.containsKey(EnvironmentConstants.NOTIFICATION_TO.getValue())){
            System.err.println("Chave " + EnvironmentConstants.NOTIFICATION_TO.getValue() + " nao existe no context.");
            return false;
        }

        AlertLogTO alertLogTO = BeanFactory.getAlertLogTO();

        EventLogTO eventLogTO = null;

        if (context.containsKey(ContextKeySpecialist.REDEMPTION_LOG_TO.getValue())){
            eventLogTO = (EventLogTO) context.get(ContextKeySpecialist.REDEMPTION_LOG_TO.getValue());
        }
        else if (context.containsKey(ContextKeySpecialist.MEMBER_TO.getValue())){
            eventLogTO = (EventLogTO) context.get(ContextKeySpecialist.REDEMPTION_LOG_TO.getValue());
        }
        else if (context.containsKey(ContextKeySpecialist.ACCRUAL_LOG_TO.getValue())){
            eventLogTO = (EventLogTO) context.get(ContextKeySpecialist.REDEMPTION_LOG_TO.getValue());
        }
        else {
            System.err.println("Chave " + EnvironmentConstants.EVENT_LOG.getValue() + " nao existe no context.");
            return false;
        }


        List<DetectionRuleTO> detectionRuleTOs = (List<DetectionRuleTO>) context.get(EnvironmentConstants.DETECTION_RULE_TOs.getValue());

        NotificationTO notificationTO = (NotificationTO) context.get(EnvironmentConstants.NOTIFICATION_TO.getValue());
        alertLogTO.setNotificationTO(notificationTO);
        alertLogTO.setDetectionRuleTOList(detectionRuleTOs);
        alertLogTO.setEventLogTO(eventLogTO);

        alertMongoDAO.insert(alertLogTO);
        return false;
    }
}
