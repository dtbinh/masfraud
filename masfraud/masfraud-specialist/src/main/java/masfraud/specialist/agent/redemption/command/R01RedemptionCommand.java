package masfraud.specialist.agent.redemption.command;

import masfraud.base.constants.ContextKeySpecialist;
import masfraud.base.constants.EventActionType;
import masfraud.base.to.EventLogTO;
import masfraud.base.to.MemberTO;
import masfraud.specialist.agent.base.command.CommandDescription;
import masfraud.specialist.agent.base.dao.EventMongoDAO;
import masfraud.specialist.agent.factory.BeanFactory;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

import java.util.List;

public class R01RedemptionCommand implements CommandDescription {

    private EventMongoDAO eventMongoDAO = BeanFactory.getEventMongoDAO();

	@Override
	public boolean execute(Context ctx) throws Exception {
        System.out.println("R01RedemptionCommand ===>> Resgate com mudanca de endereco de entrega recente.");


        if (!ctx.containsKey(ContextKeySpecialist.MEMBER_TO.getValue())){
            System.err.println("Chave " + ContextKeySpecialist.MEMBER_TO.getValue() + " nao existe no context.");
            return false;
        }

        MemberTO memberTO = (MemberTO) ctx.get(ContextKeySpecialist.MEMBER_TO.getValue());

        List<EventLogTO> eventLogTOList = eventMongoDAO.findByEventType(EventActionType.INSERT_MEMBER_DELIVERY_ADDRESS.getValue(), memberTO);

        //Se existir o registro entao a regra foi atendida, entao retorna true
        //se nao retorna false, ou seja, a regra nao foi atendida.
        return eventLogTOList != null;
	}

    @Override
    public String getDescriptionRule() {
        return "Resgate com mudaça de endereço de entrega nas ultimas 24h.";
    }
}
