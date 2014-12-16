package masfraud.coordinator.agent;

import masfraud.base.command.PrintMessageCommand;
import masfraud.base.command.ReplicationCommand;
import masfraud.base.constants.ContextKey;
import masfraud.base.message.BaseEvent;
import masfraud.base.message.ReplicaEvent;
import masfraud.base.router.BaseMessageRouter;

import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

/**
 * 
 * @author Mauricio
 *
 */
public class CoordinatorMessageRouter extends BaseMessageRouter {

	private static final long serialVersionUID = 7203531556818427359L;
	
	private static Logger LOG = Logger.getLogger(CoordinatorMessageRouter.class);
	
	@SuppressWarnings({ "unchecked", "incomplete-switch" })
	public Boolean routeMessage(final Context context){
		
		LOG.info(this.getClass().getName() + ": " + "Method: routeMessage");
		
		BaseEvent originalMessage = (BaseEvent) context.get(ContextKey.INCOMING_MESSAGE.getValue());
		
		switch (originalMessage.getType()) {
		case REPLICA:
			
			String strMessage = (String)context.get(ContextKey.STRING_MESSAGE.getValue());
			ReplicaEvent replicaMessage = new Gson().fromJson(strMessage, ReplicaEvent.class);
			
			context.put(ContextKey.MESSAGE.getValue(), replicaMessage);
			try {
				new PrintMessageCommand().execute(context);
				new ReplicationCommand().execute(context);
			} catch (Exception e) {
				System.err.println(e);
				LOG.error(e, e);
				return false;
			}
			break;
			
		case EVENT:
			try {
				new PrintMessageCommand().execute(context);
			} catch (Exception e) {
				LOG.error(e, e);
				return false;
			}
			break;
		}
		return true;
	}
	
}
