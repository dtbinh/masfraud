package br.com.masfraud.accrual.agent;

import jade.core.behaviours.CyclicBehaviour;
import jade.core.replication.AgentReplicationHelper;
import jade.lang.acl.ACLMessage;
import br.com.masfraud.base.BaseAgent;
import br.com.masfraud.base.constants.RoleNameConstants;

public class AccrualSpecialistAgent extends BaseAgent {

	private static final long serialVersionUID = -9139647893045504584L;
	
	@Override
	protected void setup() {
		super.setup();
		addBehaviour(new CyclicBehaviour() {
			private static final long serialVersionUID = 8647922938639230398L;
			
			@Override
			public void action() {
				ACLMessage message = this.myAgent.receive();
				if(message != null){
					if(message.getContent().equalsIgnoreCase("replica")){
						try {
							AgentReplicationHelper helper = (AgentReplicationHelper) getHelper(AgentReplicationHelper.SERVICE_NAME);
							
							System.out.println("REPLICAS: " + helper.getVirtualAid());
							
							//helper.createReplica("agent1Replica", new ContainerID("Container-1", null));
						}
						catch (Exception e) {
							System.out.println("Agent "+getLocalName()+" - Error creating replica on container "+"MASFraudContainer");
							e.printStackTrace();
						}
					}else{
						System.out.println(message.getContent());
					}
					System.out.println("Comportamento 1");
				}else{
					System.out.println("Block 1");
					block();
				}
			}
		});
	}

	@Override
	public String getRoleName() {
		return RoleNameConstants.SPECIALIST.getValue();
	}
	
	

}
