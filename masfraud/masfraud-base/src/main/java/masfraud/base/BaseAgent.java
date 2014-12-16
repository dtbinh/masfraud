package masfraud.base;

import masfraud.base.constants.ContextKey;
import masfraud.base.message.BaseEvent;
import masfraud.base.router.BaseMessageRouter;
import jade.content.lang.sl.SLCodec;
import jade.core.AID;
import jade.core.Agent;
import jade.core.ContainerID;
import jade.core.Location;
import jade.core.ServiceException;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.replication.AgentReplicationHelper;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.JADEAgentManagement.JADEManagementOntology;
import jade.lang.acl.ACLMessage;

import com.google.gson.Gson;

public abstract class BaseAgent extends Agent implements AgentReplicationHelper.Listener{

	private static final long serialVersionUID = 5161809204015232063L;
	
	
	@Override
	protected void setup() {
		
		//Register the SL content language
		getContentManager().registerLanguage(new SLCodec());
		
		getContentManager().registerLanguage(new SLCodec(0));
		
		//Register the mobility ontology
		getContentManager().registerOntology(JADEManagementOntology.getInstance());
		
		checkVirtualCondition();
		
        //Receptor de Mensagens
		addBehaviour(new CyclicBehaviour() {
			private static final long serialVersionUID = 8647922938639230398L;

			@SuppressWarnings("unchecked")
			@Override
			public void action() {
				ACLMessage message = this.myAgent.receive();
				if (message != null) {
					try {
                        System.out.println(message.getContent());
						BaseEvent simpleMessage = new Gson().fromJson(message.getContent(), BaseEvent.class);
						ContextMasfraud context = new ContextMasfraud();
						context.put(ContextKey.AGENT_LOCAL_NAME.getValue(), this.myAgent.getLocalName());
						context.put(ContextKey.AGENT_ROLE_NAME.getValue(), getRoleName());
						context.put(ContextKey.INCOMING_MESSAGE.getValue(), simpleMessage);
						context.put(ContextKey.STRING_MESSAGE.getValue(), message.getContent());
						context.put(ContextKey.AGENT_INSTANCE.getValue(), this.myAgent);
						getMessageRouter().routeMessage(context);
						System.out.println("Comportamento CyclicBehaviour do agente: " + getLocalName());
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("MENSAGEM COM PROBLEMA: " + message.getContent());
					}
				} else {
					System.out.println("Block do agent: " + getLocalName());
					block();
				}
			}
		});
	}
	
	public void checkVirtualCondition() {
		try{
			AgentReplicationHelper helper = getAgentReplicationHelper();
			if(!existMaster()){
				if(helper.getMasterAid() == null){
					AID virtualAID = helper.makeVirtual(getLocalName() + "_V", AgentReplicationHelper.HOT_REPLICATION);
					 DFAgentDescription dfad = new DFAgentDescription();
					 dfad.setName(virtualAID); 
					 ServiceDescription sd = new ServiceDescription();
					 sd.setType(getRoleName()); 
					 sd.setName(getRoleName()+"_V");
					 dfad.addServices(sd); 
					 DFService.register(this, dfad);
					 System.out.println("Master registrado para o agente: " + getLocalName());
				}	
			}else{
				System.out.println("Ja existe Master para o agente: " + getLocalName());
				DFAgentDescription dfad = new DFAgentDescription();
				dfad.setName(getAID());
				ServiceDescription sd = new ServiceDescription();
				sd.setType(getRoleName());
				sd.setName(getLocalName());
				dfad.addServices(sd);
				try{
					DFService.deregister(this, dfad);	
				}catch(Exception e){
					
				}
				DFService.register(this, dfad);
				System.out.println("agente: " + getLocalName() + " registrado no DF");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	protected void takeDown() {
		try {
			DFService.deregister(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean existMaster(){
		try{
			DFAgentDescription template = new DFAgentDescription();
			ServiceDescription sd = new ServiceDescription();
			sd.setType(getRoleName());
			sd.setName(getRoleName() + "_V");
			template.addServices(sd);
			DFAgentDescription[] res = DFService.search(this, getDefaultDF(), template, null);
			if (res!=null && res.length > 0) {
				return true;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	/**
	 * 
	 * @param replicaName
	 * @param containerDest
	 */
	public void replicate(String replicaName, String containerDest){
		try{
			AgentReplicationHelper helper = getAgentReplicationHelper();
			System.out.println("ENVIANDO COMANDO PARA REPLICA: " + replicaName + ":" + containerDest);
			helper.createReplica(replicaName, new ContainerID(containerDest, null));	
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public abstract String getRoleName();
	
	
	public abstract BaseMessageRouter getMessageRouter();
	
	
	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public AgentReplicationHelper getAgentReplicationHelper() throws ServiceException{
		return (AgentReplicationHelper) getHelper(AgentReplicationHelper.SERVICE_NAME);
	}
	
	
	@Override
	protected void afterClone() {
		System.out.println("Agent "+getLocalName()+" - Alive");
		checkVirtualCondition();
		super.afterClone();
	}
	
	@Override
	public void becomeMaster() {
		System.out.println("Agent "+getLocalName()+" - I'm the new master replica");
	}

	@Override
	public void replicaAdded(AID replicaAid, Location where) {
		System.out.println("Agent "+getLocalName()+" - New replica "+replicaAid.getLocalName()+" successfully added in "+where.getName());
		
	}

	@Override
	public void replicaCreationFailed(AID replicaAid, Location where) {
		System.out.println("Agent "+getLocalName()+" - Creation of new replica "+replicaAid.getLocalName()+" in "+where.getName()+" failed");
	}
	
	@Override
	public void replicaRemoved(AID arg0, Location arg1) {
		System.out.println("Agent "+getLocalName()+" - removed ");
	}
	

}
