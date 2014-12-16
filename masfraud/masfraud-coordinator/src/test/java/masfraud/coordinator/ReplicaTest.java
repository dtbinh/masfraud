package masfraud.coordinator;


public class ReplicaTest {

	public static void main(String[] args) throws Exception {
//		Behaviour teste = new OneShotBehaviour() {
//
//			@Override
//			public void action() {
//				System.out.println("ENVIANDO");
//				
//				ReplicaMessage replicaMessage = new ReplicaMessage();
//				replicaMessage.setReplicaName("coordinator2");
//				replicaMessage.setContainerDest("Container-1");
//				
//				SimpleMessage simpleMessage = new SimpleMessage();
//				simpleMessage.setType(MessageType.REPLICA);
//				simpleMessage.setPayload(new Gson().toJson(replicaMessage));
//				
//				ACLMessage message = new ACLMessage(ACLMessage.INFORM);
//				message.addReceiver(new AID("coordinator_V", false));
//				message.setContent(new Gson().toJson(simpleMessage));
//				getAgent().send(message);
//				
//				
//				
//				replicaMessage = new ReplicaMessage();
//				replicaMessage.setReplicaName("specialistAccrual2");
//				replicaMessage.setContainerDest("Container-1");
//				
//				simpleMessage = new SimpleMessage();
//				simpleMessage.setType(MessageType.REPLICA);
//				simpleMessage.setPayload(new Gson().toJson(replicaMessage));
//				
//				message = new ACLMessage(ACLMessage.INFORM); 
//				message.addReceiver(new AID("specialistAccrual_V", false));
//				message.setContent(new Gson().toJson(simpleMessage));
//				getAgent().send(message);
//				
//			}
//		};
//		 Properties pp = new Properties();
//		 pp.setProperty(Profile.MAIN, "false");
//		 pp.setProperty(Profile.MAIN_HOST, "localhost");
//		 pp.setProperty(Profile.MAIN_PORT, "1099");
//		 pp.setProperty(Profile.SERVICES, "jade.core.mobility.AgentMobilityService;jade.core.event.NotificationService;jade.core.replication.AgentReplicationService");
//	    JadeGateway.init(null,pp);
//		JadeGateway.execute(teste);
	}

}