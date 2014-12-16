package masfraud.specialist.agent.profile.dao;

import masfraud.base.constants.CollectionsNames;
import masfraud.base.dao.AbstractMongoDBDAO;
import masfraud.base.to.MemberTO;
import masfraud.base.to.ProfileLogTO;
import masfraud.specialist.agent.accrual.SpecialistAccrualAgent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class ProfileMongoDAO extends AbstractMongoDBDAO<ProfileLogTO>{

	public ProfileMongoDAO() {
        super(SpecialistAccrualAgent.mongoTemplate);
	}

	@Override
	protected String getCollectionName() {
		return CollectionsNames.COLLECTION_PROFILE.getNameCollection();
	}

    /*public MemberTO findMemberByToken(MemberTO memberTO) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("tokens.primaryValue").in(memberTO.getTokens().get(0).getPrimaryValue()));
        return findBy(query, MemberTO.class);
    }*/
	
}
