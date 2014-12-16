package masfraud.specialist.agent.redemption.dao;

import masfraud.base.constants.CollectionsNames;
import masfraud.base.dao.AbstractMongoDBDAO;
import masfraud.base.to.RedemptionLogTO;
import masfraud.specialist.agent.redemption.SpecialistRedemptionAgent;

public class RedemptionMongoDAO extends AbstractMongoDBDAO<RedemptionLogTO>{

	public RedemptionMongoDAO() {
		super(SpecialistRedemptionAgent.mongoTemplate);
	}

	@Override
	protected String getCollectionName() {
		return CollectionsNames.COLLECTION_REDEMPTION_LOG.getNameCollection();
	}
	
}
