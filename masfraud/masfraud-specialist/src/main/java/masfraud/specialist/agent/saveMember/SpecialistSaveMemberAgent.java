package masfraud.specialist.agent.saveMember;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import masfraud.base.BaseAgent;
import masfraud.base.constants.RoleNameConstants;
import masfraud.base.router.BaseMessageRouter;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * 
 * @author Mauricio
 *
 */
public class SpecialistSaveMemberAgent extends BaseAgent{

	private static final long serialVersionUID = -4886572804913230703L;
	
	public static HazelcastInstance client;
	
	public static MongoTemplate mongoTemplate;
	
	/**
	 * 
	 */
	private void initMongoTemplate(){
		try {
			ServerAddress address = new ServerAddress("localhost", 27017);
			MongoClient mongoClient = new MongoClient(address);
			MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, "masfraud");
			mongoTemplate = new MongoTemplate(mongoDbFactory);
			System.out.println(mongoTemplate.getDb());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	protected void setup() {
		initMongoTemplate();
		initHazelcastClient();
        super.setup();
	}
	
	@Override
	protected void afterClone() {
		super.afterClone();
		if(client == null){
			System.out.println("Configurando outro client");
			initMongoTemplate();
			initHazelcastClient();
		}
	}
	
	
	
	@Override
	protected void takeDown() {
		client.shutdown();
	}
	
	
	@Override
	public String getRoleName() {
		return RoleNameConstants.SPECIALIST_SAVE_MEMBER.getValue();
	}


	@Override
	public BaseMessageRouter getMessageRouter() {
		return new SpecialistSaveMemberMessageRouter();
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
	}
	
}
