package masfraud.specialist.agent.accrual.command;

import masfraud.base.constants.ContextKeySpecialist;
import masfraud.base.constants.EventActionType;
import masfraud.base.message.Event;
import masfraud.base.to.AccrualLogTO;
import masfraud.base.to.EventLogTO;
import masfraud.specialist.agent.base.command.CommandDescription;
import masfraud.specialist.agent.base.dao.EventMongoDAO;
import masfraud.specialist.agent.factory.BeanFactory;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import java.util.List;

public class R02AccrualCommand implements CommandDescription {

    private EventMongoDAO eventMongoDAO = BeanFactory.getEventMongoDAO();


	@Override
	public boolean execute(Context ctx) throws Exception {
        System.out.println("R02AccrualCommand ===>> Acumulos diarios por dias seguidos.");


        if (!ctx.containsKey(ContextKeySpecialist.ACCRUAL_LOG_TO.getValue())){
            System.err.println("Chave " + ContextKeySpecialist.ACCRUAL_LOG_TO.getValue() + " nao esta no Context.");
            return false;
        }

        AccrualLogTO accrualTO = (AccrualLogTO) ctx.get(ContextKeySpecialist.ACCRUAL_LOG_TO.getValue());

        //5 = quantidade de dias seguidos
        List<EventLogTO> eventLogTOs = eventMongoDAO.findAccrualRangeDate(accrualTO, EventActionType.FINANCIAL_EARN ,5);

        //3 = Quantidade de acumulos nos dias seguidos por exemplo: 3 acumulos dentro de 5 dias
        if (eventLogTOs != null && eventLogTOs.size() >= 3){
            return true;
        }
        return false;
	}

    @Override
    public String getDescriptionRule() {
        return "Varios acúmulos diários por vários dias seguidos.";
    }
}
