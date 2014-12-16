package masfraud.specialist.agent.accrual;

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
import masfraud.base.to.ObjectParse;
import masfraud.specialist.agent.ProcessorEngine;
import masfraud.specialist.agent.accrual.command.R01AccrualCommand;
import masfraud.specialist.agent.accrual.command.R02AccrualCommand;
import masfraud.specialist.agent.accrual.command.R03AccrualCommand;
import masfraud.specialist.agent.base.command.CommandBase;
import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.CatalogBase;
import org.apache.log4j.Logger;

/**
 * 
 * @author Mauricio
 * 
 */
public class SpecialistAccrualMessageRouter extends BaseMessageRouter {

	private static final long serialVersionUID = -3782124025021376578L;

	private static Logger LOG = Logger.getLogger(SpecialistAccrualMessageRouter.class);
	
	private Catalog catalog = new CatalogBase();
	
	public SpecialistAccrualMessageRouter() {
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

                //Devera salvar o evento antes de ir para o motor,
                //Sava o Event e depois o Accrual, depois executa o motor para
                //poder executar as regras.
                CommandBase commandBase = new CommandBase();
                commandBase.setEventType(EventType.ACCRUAL);
                commandBase.setEventActionType(EventActionType.FINANCIAL_EARN);

                //Soh executa o motor caso exista o member
                if (commandBase.execute(context)){

                    //Chama o motor para poder executar as regras {Gerar alerta ou nao}
                    ProcessorEngine.getInstance().engine(context, ServiceName.ACCRUAL);
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
		catalog.addCommand("R01", new R01AccrualCommand());
		catalog.addCommand("R02", new R02AccrualCommand());
		catalog.addCommand("R03", new R03AccrualCommand());
	}
	
	
	
	
}
