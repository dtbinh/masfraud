package masfraud.specialist.agent.profile.command;

import masfraud.base.constants.EventActionType;
import masfraud.base.to.MemberTO;
import masfraud.specialist.agent.base.dao.EventMongoDAO;
import masfraud.specialist.agent.factory.BeanFactory;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

public class R01ProfileCommand implements Command{


    private EventMongoDAO eventMongoDAO = BeanFactory.getEventMongoDAO();


	@Override
	public boolean execute(Context ctx) throws Exception {
        System.out.println("R01ProfileCommand ===>> Mudanca de endereco.");
		return false;
	}

}
