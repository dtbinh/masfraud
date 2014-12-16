package masfraud.coordinator.command;

import jade.content.onto.basic.Action;
import jade.core.AID;
import jade.domain.DFService;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.JADEAgentManagement.JADEManagementOntology;
import jade.domain.JADEAgentManagement.KillAgent;
import jade.lang.acl.ACLMessage;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import masfraud.base.BaseAgent;
import masfraud.base.constants.ContextKey;
import masfraud.base.constants.RoleNameConstants;
import masfraud.base.message.ReplicaEvent;
import masfraud.base.message.StructuralEvent;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;

public class StructuralCommand implements Command, Serializable{

	private static final long serialVersionUID = -6449520919848838129L;

	@Override
	public boolean execute(Context ctx) throws Exception {
		final StructuralEvent message = (StructuralEvent)ctx.get(ContextKey.MESSAGE.getValue());
		final BaseAgent agent = (BaseAgent)ctx.get(ContextKey.AGENT_INSTANCE.getValue());
		
		DFAgentDescription template = new DFAgentDescription();
//		template.addServices(sd);
		DFAgentDescription[] res = DFService.search(agent, agent.getDefaultDF(), template, null);
		AID provider = null;
		if (res.length > 0) {
			for (int i = 0; i < res.length; i++){
				provider = res[i].getName();
				System.out.println("Agent "+agent.getLocalName()+" - agent "+provider.getLocalName()+" found");
				
				//Destroi todas as replicas
				if(!StringUtils.contains(provider.getLocalName(), "_V")){
					
					System.out.println("O agente: " + provider.getLocalName() + " sera removido");
					System.out.println("Enviando mensagem para finalizar agente");
					
					KillAgent killAgent = new KillAgent();
					killAgent.setAgent(new AID(provider.getLocalName(), false));
					Action a = new Action();
					a.setActor(agent.getAMS());
					a.setAction(killAgent);
					
					ACLMessage AMSRequest = new ACLMessage(ACLMessage.REQUEST);
					AMSRequest.setSender(agent.getAID());
					AMSRequest.clearAllReceiver();
					AMSRequest.addReceiver(agent.getAMS());
					AMSRequest.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
					AMSRequest.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
					AMSRequest.setOntology(JADEManagementOntology.NAME);
					agent.getContentManager().fillContent(AMSRequest, a);
					agent.send(AMSRequest);
					
					
				}else{
					System.out.println("O agente master: " + provider.getLocalName() + " nao sera removido");
				}
				System.out.println("\n\n\n\n");
			}
			Thread.sleep(1000);
			//Recria todas as replicas
			checkCoordinators(message.getActiveReplicas().get(RoleNameConstants.COORDINATOR), agent);
			checkSpecialists(message.getActiveReplicas().get(RoleNameConstants.SPECIALIST_ACCRUAL), agent);
			
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param coordenadores
	 * @param agent
	 */
	private void checkCoordinators(Map<String, String> coordenadores, BaseAgent agent){
		try{
			if(coordenadores !=null){
				Set<String> replicas = coordenadores.keySet();
				for (String replicaName : replicas) {
					
					String destino = coordenadores.get(replicaName);
					
					ReplicaEvent replicaMessage = new ReplicaEvent();
					replicaMessage.setReplicaName(replicaName);
					replicaMessage.setContainerDest(destino);
					
					ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
					aclMessage.addReceiver(new AID(RoleNameConstants.COORDINATOR.getValue(), false));
					aclMessage.setContent(new Gson().toJson(replicaMessage));
					agent.send(aclMessage);
				}	
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @param specialists
	 * @param agent
	 */
	private void checkSpecialists(Map<String, String> specialists, BaseAgent agent){
		try{
			if(specialists !=null){
				Set<String> replicas = specialists.keySet();
					
				for (String replicaName : replicas) {
					
					String destino = specialists.get(replicaName);
					
					ReplicaEvent replicaMessage = new ReplicaEvent();
					replicaMessage.setReplicaName(replicaName);
					replicaMessage.setContainerDest(destino);
					
					ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
					aclMessage.addReceiver(new AID(RoleNameConstants.SPECIALIST_ACCRUAL.getValue(), false));
					aclMessage.setContent(new Gson().toJson(replicaMessage));
					agent.send(aclMessage);
				}	
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
