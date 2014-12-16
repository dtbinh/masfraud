package masfraud.environment.agent;

import com.hazelcast.core.IMap;
import jade.core.Agent;
import masfraud.base.constants.AlertaNiveisConstants;
import masfraud.base.constants.EnvironmentConstants;

import masfraud.base.constants.RegrasPesoConstants;
import org.apache.log4j.Logger;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * 
 * @author Mauricio
 *
 */
public class EnvironmentAgent extends Agent {

	private static Logger LOG = Logger.getLogger(EnvironmentAgent.class);
	
	private static final long serialVersionUID = -6444651629530585451L;

	@Override
	protected void setup() {
		
		Config cfg = new Config();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
		instance.getQueue(EnvironmentConstants.INCOMING_EVENTS.getValue());
		instance.getMap(EnvironmentConstants.STRUCTURAL_MAP.getValue());
		instance.getMap(EnvironmentConstants.ALERT_TABLE.getValue());
		instance.getMap(EnvironmentConstants.SCORE_TABLE.getValue());

        putAlertTable(instance.getMap(EnvironmentConstants.ALERT_TABLE.getValue()));
        putScoreTable(instance.getMap(EnvironmentConstants.SCORE_TABLE.getValue()));
	}

    private void putAlertTable(IMap<Object, Object> map) {

        map.put(AlertaNiveisConstants.CRITICO.getNivel(), 600);
        map.put(AlertaNiveisConstants.ALTO.getNivel(), 500);
        map.put(AlertaNiveisConstants.MEDIO.getNivel(), 400);
        map.put(AlertaNiveisConstants.BAIXO.getNivel(), 300);
        map.put(AlertaNiveisConstants.INFORMATIVO.getNivel(), 200);

    }

    private void putScoreTable(IMap<Object, Object> map) {

        map.put(RegrasPesoConstants.ACCRUAL_R01.getNameCommand(), 100);
        map.put(RegrasPesoConstants.ACCRUAL_R02.getNameCommand(), 200);
        map.put(RegrasPesoConstants.ACCRUAL_R03.getNameCommand(), 500);

        map.put(RegrasPesoConstants.REDEMPTION_R01.getNameCommand(), 300);
        map.put(RegrasPesoConstants.REDEMPTION_R02.getNameCommand(), 100);
        map.put(RegrasPesoConstants.REDEMPTION_R03.getNameCommand(), 600);

        map.put(RegrasPesoConstants.PROFILE.getNameCommand(), 200);

        map.put(RegrasPesoConstants.SAVE_MEMBER.getNameCommand(), 0);
    }


}
