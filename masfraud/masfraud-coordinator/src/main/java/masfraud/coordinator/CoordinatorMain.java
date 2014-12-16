package masfraud.coordinator;

import masfraud.base.constants.RoleNameConstants;
import masfraud.coordinator.agent.CoordinatorAgent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class CoordinatorMain {

	
	public static void main(String[] args) throws Exception{
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-masfraud-coordinator.xml");
		
		jade.core.Runtime rt = jade.core.Runtime.instance();
		Profile p = new ProfileImpl(); 
		p.setParameter(Profile.MAIN_HOST, "localhost");
		p.setParameter(Profile.MAIN_PORT, "1099");
		p.setParameter(Profile.SERVICES, "jade.core.mobility.AgentMobilityService;jade.core.event.NotificationService;jade.core.replication.AgentReplicationService");
		//p.setParameter(Profile.GUI, "true");
		
		ContainerController cc = rt.createAgentContainer(p);
		AgentController dummy = cc.acceptNewAgent(RoleNameConstants.COORDINATOR.getValue() + "09", new CoordinatorAgent()); 
		dummy.start();
		
	}
}
