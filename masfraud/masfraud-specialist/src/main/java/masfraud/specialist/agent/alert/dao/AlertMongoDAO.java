package masfraud.specialist.agent.alert.dao;

import masfraud.base.constants.CollectionsNames;
import masfraud.base.dao.AbstractMongoDBDAO;
import masfraud.base.to.AlertLogTO;
import masfraud.specialist.agent.accrual.SpecialistAccrualAgent;

/**
 * Created with IntelliJ IDEA.
 * User: sorge
 * Date: 12/2/14
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class AlertMongoDAO extends AbstractMongoDBDAO<AlertLogTO> {

    public AlertMongoDAO() {
        super(SpecialistAccrualAgent.mongoTemplate);
    }

    @Override
    protected String getCollectionName() {
        return CollectionsNames.COLLECTION_ALERT_LOG.getNameCollection();
    }
}
