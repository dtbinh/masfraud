package masfraud.coordinator;

import java.util.HashMap;
import java.util.Map;

import masfraud.base.constants.EnvironmentConstants;
import masfraud.base.constants.RoleNameConstants;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;

public class HazelTest {

	
	public static void main(String[] args) {
		ClientNetworkConfig networkConfig = new ClientNetworkConfig();
		networkConfig.setConnectionAttemptLimit(15);

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.setNetworkConfig(networkConfig);

		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
		
		Map<RoleNameConstants, Map<String, String>> activeReplicas = new HashMap<>();
		
		Map<String, String> mapCoordenadores = new HashMap<String, String>();
		mapCoordenadores.put("coordinator2", "Container-1");
		activeReplicas.put(RoleNameConstants.COORDINATOR, mapCoordenadores);

	 
		Map<String, String> mapSpecialists = new HashMap<String, String>();
		mapSpecialists.put("specialistAccrual2", "Container-1");
		mapSpecialists.put("specialistAccrual3", "Container-1");
		activeReplicas.put(RoleNameConstants.SPECIALIST_ACCRUAL, mapSpecialists);
		for(int i=0; i < 100; i++){
			client.getMap(EnvironmentConstants.STRUCTURAL_MAP.getValue()).put(EnvironmentConstants.STRUCTURAL_MAP.getValue(), activeReplicas);
		}
		

	}
	
}
