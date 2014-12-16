package masfraud.coordinator.agent;

import masfraud.base.BaseAgent;
import masfraud.base.constants.EnvironmentConstants;
import masfraud.base.constants.RoleNameConstants;
import masfraud.base.router.BaseMessageRouter;
import masfraud.coordinator.sensors.IncomingEventSensor;
import masfraud.coordinator.sensors.StructuralMapSensor;

import org.apache.log4j.Logger;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;

public class CoordinatorAgent extends BaseAgent {

	@SuppressWarnings("unused")
	private static Logger LOG = Logger.getLogger(CoordinatorAgent.class);

	private static final long serialVersionUID = 4029630263212521970L;

	public static HazelcastInstance client;

	
	@Override
	protected void setup() {
		initHazelcastClient();
        super.setup();
	}
	
	
	@Override
	protected void afterClone() {
		super.afterClone();
		if(client == null){
			System.out.println("Configurando outro client");
			initHazelcastClient();
		}
	}

	
	
	@Override
	protected void takeDown() {
		client.shutdown();
		super.takeDown();
	}
	
	
	@Override
	public String getRoleName() {
		return RoleNameConstants.COORDINATOR.getValue();
	}

	@Override
	public BaseMessageRouter getMessageRouter() {
		return new CoordinatorMessageRouter();
	}

	
	/**
	 * 
	 */
	private void initHazelcastClient(){
		ClientNetworkConfig networkConfig = new ClientNetworkConfig();
		networkConfig.setConnectionAttemptLimit(15);

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.setNetworkConfig(networkConfig);

        client = HazelcastClient.newHazelcastClient(clientConfig);
        addEnvironmentSensor();
	}
	
	
	/**
	 * Sensores para detectarem mudancas no ambiente
	 */
	private void addEnvironmentSensor(){
		client.getMap(EnvironmentConstants.STRUCTURAL_MAP.getValue()).addEntryListener(new StructuralMapSensor(this, client), true);
		client.getQueue(EnvironmentConstants.INCOMING_EVENTS.getValue()).addItemListener(new IncomingEventSensor(this, client), true);
	}
	

}
