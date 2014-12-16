package masfraud.coordinator;

import com.google.gson.Gson;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import masfraud.base.constants.EnvironmentConstants;
import masfraud.base.constants.EventType;
import masfraud.base.constants.Gender;
import masfraud.base.message.AccrualEvent;
import masfraud.base.message.GenericEvent;
import masfraud.base.to.MemberTO;
import masfraud.base.to.MemberTokenTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberTest {

	public static void main(String[] args) throws Exception {
		
		ClientNetworkConfig networkConfig = new ClientNetworkConfig();
		networkConfig.setConnectionAttemptLimit(15);

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.setNetworkConfig(networkConfig);

		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
		
		GenericEvent eventMessage = new GenericEvent();
		eventMessage.setEventType(EventType.PROFILE);

        MemberTO memberTO = new MemberTO();

        memberTO.setFirstName("FIRST NAME");
        memberTO.setMiddleName("MIDDLE NAME");
        memberTO.setLastName("LAST NAME");

        List<MemberTokenTO> memberTokenTOs = new ArrayList<MemberTokenTO>();
        MemberTokenTO memberTokenTO = new MemberTokenTO();
        memberTokenTO.setPrimaryValue("andrelsorge@gmail.com");
        memberTokenTOs.add(memberTokenTO);
        memberTO.setTokens(memberTokenTOs);

		eventMessage.setPayload(new Gson().toJson(memberTO));
		
		
		client.getQueue(EnvironmentConstants.INCOMING_EVENTS.getValue()).put(eventMessage);
		
		System.exit(0);
		
	}

}