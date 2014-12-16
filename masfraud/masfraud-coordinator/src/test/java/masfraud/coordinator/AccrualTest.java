package masfraud.coordinator;

import com.google.gson.Gson;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import masfraud.base.constants.EnvironmentConstants;
import masfraud.base.constants.EventType;
import masfraud.base.message.AccrualEvent;
import masfraud.base.message.GenericEvent;

import java.math.BigDecimal;

public class AccrualTest {

	public static void main(String[] args) throws Exception {
		
		ClientNetworkConfig networkConfig = new ClientNetworkConfig();
		networkConfig.setConnectionAttemptLimit(15);

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.setNetworkConfig(networkConfig);

		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
		
		GenericEvent eventMessage = new GenericEvent();
		eventMessage.setEventType(EventType.ACCRUAL);

        AccrualEvent accrualMessage = new AccrualEvent();
		accrualMessage.setToken("mauricio.rodrigues@gmail.com"); 
		accrualMessage.setTokenName("EMAIL");
		accrualMessage.setAmountPoints(new BigDecimal("100.00"));
//        accrualMessage.setAmountValues(new BigDecimal("150.00"));
		accrualMessage.setCodeCurrency("POINTS");
		accrualMessage.setNameCurrency("Pontos");
		accrualMessage.setDateTransaction(new java.util.Date());
		accrualMessage.setIdIssuingPartner("1");
		accrualMessage.setPartnerName("Restaurante Italiano");
		accrualMessage.setLocationCode("REST_1");
		accrualMessage.setPartnerDescAux("Jantar Especial");




		eventMessage.setPayload(new Gson().toJson(accrualMessage));
		
		
		client.getQueue(EnvironmentConstants.INCOMING_EVENTS.getValue()).put(eventMessage);
		
		System.exit(0);
		
	}

}