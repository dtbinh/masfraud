package masfraud.specialist.agent.redemption;

import com.google.gson.Gson;
import masfraud.base.BaseAgent;
import masfraud.base.command.PrintMessageCommand;
import masfraud.base.command.ReplicationCommand;
import masfraud.base.constants.ContextKey;
import masfraud.base.constants.EventActionType;
import masfraud.base.constants.EventType;
import masfraud.base.constants.ServiceName;
import masfraud.base.message.BaseEvent;
import masfraud.base.message.ReplicaEvent;
import masfraud.base.router.BaseMessageRouter;
import masfraud.specialist.agent.ProcessorEngine;
import masfraud.specialist.agent.base.command.CommandBase;
import masfraud.specialist.agent.redemption.command.R01RedemptionCommand;
import masfraud.specialist.agent.redemption.command.R02RedemptionCommand;
import masfraud.specialist.agent.redemption.command.R03RedemptionCommand;
import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.CatalogBase;
import org.apache.log4j.Logger;

/**
 * 
 * @author Mauricio
 * 
 */
public class SpecialistRedemptionMessageRouter extends BaseMessageRouter {

	private static final long serialVersionUID = -3782124025021376578L;

	private static Logger LOG = Logger.getLogger(SpecialistRedemptionMessageRouter.class);
	
	private Catalog catalog = new CatalogBase();
	
	public SpecialistRedemptionMessageRouter() {
		createValidationCatalog();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Boolean routeMessage(Context context) {
		LOG.info(this.getClass().getName() + ": " + "Method: routeMessage");

		BaseEvent originalMessage = (BaseEvent) context.get(ContextKey.INCOMING_MESSAGE.getValue());
		BaseAgent agent = (BaseAgent)context.get(ContextKey.AGENT_INSTANCE.getValue());

		switch (originalMessage.getType()) {

		case REPLICA:
			String strMessage = (String)context.get(ContextKey.STRING_MESSAGE.getValue());
			ReplicaEvent replicaMessage = new Gson().fromJson(strMessage, ReplicaEvent.class);
			
			context.put(ContextKey.MESSAGE.getValue(), replicaMessage);
			try {
				//new PrintMessageCommand().execute(context);
				System.out.println("Agent " + agent.getLocalName() + " replica command...");
				new ReplicationCommand().execute(context);
			} catch (Exception e) {
				System.err.println(e);
				return false;
			}
			break;

		case EVENT:
			try {
				System.out.println("SpecialistMessageRouter: routeMessage -> EVENT");


                CommandBase commandBase = new CommandBase();
                commandBase.setEventActionType(EventActionType.REDEMPTION_REWARD);
                commandBase.setEventType(EventType.REDEMPTION);
                commandBase.execute(context);

                //Soh executa o motor caso exista o member
                if (commandBase.execute(context)){
                    //Chama o motor para poder executar as regras {Gerar alerta ou nao}
                    ProcessorEngine.getInstance().engine(context, ServiceName.REDEMPTION);
                }

				new PrintMessageCommand().execute(context);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		default:
			break;

		}

		return null;
	}



    private void executeValidation(){
		
	}
	
	
	
	/**
	 * 
	 */
	private void createValidationCatalog(){
		catalog.addCommand("R01", new R01RedemptionCommand());
		catalog.addCommand("R02", new R02RedemptionCommand());
		catalog.addCommand("R03", new R03RedemptionCommand());
	}
	
	
	
	
}
