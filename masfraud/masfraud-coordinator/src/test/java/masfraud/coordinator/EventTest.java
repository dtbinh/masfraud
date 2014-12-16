package masfraud.coordinator;

import jade.core.Agent;

public class EventTest extends Agent {

	public static void main(String[] args) throws Exception {
//		Behaviour teste = new OneShotBehaviour() {
//
//			@Override
//			public void action() {
//				System.out.println("ENVIANDO");
//				ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
//				SimpleMessage simpleMessage = new SimpleMessage();
//				simpleMessage.setType(MessageType.EVENT);
//				simpleMessage.setPayload("CONTEUDO");
//				message.setContent(new Gson().toJson(simpleMessage));
//				message.addReceiver(new AID("specialistAccrual_V", false));
//				for(int i = 0; i < 1000; i++){
//					getAgent().send(message);
//				}
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