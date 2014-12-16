package masfraud.coordinator;

import java.util.HashMap;
import java.util.Map;

import masfraud.base.constants.EnvironmentConstants;
import masfraud.base.constants.MessageType;
import masfraud.base.constants.RoleNameConstants;
import masfraud.base.message.StructuralEvent;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;

public class StructuralTest {

	public static void main(String[] args) throws Exception {
		
		
		ClientNetworkConfig networkConfig = new ClientNetworkConfig();
		networkConfig.setConnectionAttemptLimit(15);

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.setNetworkConfig(networkConfig);

		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
		
		StructuralEvent structuralMessage = new StructuralEvent();
		
		Map<String, String> mapCoordenadores = new HashMap<String, String>();
		
		mapCoordenadores.put("coordinator2", "Container-1");
//		mapCoordenadores.put("coordinator3", "Container-1");
//		mapCoordenadores.put("coordinator4", "Container-1");
//		mapCoordenadores.put("coordinator5", "Container-1");
		structuralMessage.getActiveReplicas().put(RoleNameConstants.COORDINATOR, mapCoordenadores);

	 
		Map<String, String> mapSpecialists = new HashMap<String, String>();
		mapSpecialists.put("specialistAccrual2", "Container-1");
		mapSpecialists.put("specialistAccrual3", "Container-1");
//		mapSpecialists.put("specialistAccrual4", "Container-1");
//		mapSpecialists.put("specialistAccrual5", "Container-1");
		structuralMessage.getActiveReplicas().put(RoleNameConstants.SPECIALIST_ACCRUAL, mapSpecialists);
		

		client.getMap(EnvironmentConstants.STRUCTURAL_MAP.getValue()).put(MessageType.STRUCTURAL.getValue(), structuralMessage);
		
		System.exit(0);
		
	}

}