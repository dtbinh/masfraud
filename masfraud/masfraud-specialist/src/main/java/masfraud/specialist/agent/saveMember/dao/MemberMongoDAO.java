package masfraud.specialist.agent.saveMember.dao;

import masfraud.base.constants.CollectionsNames;
import masfraud.base.constants.NameFieldsMongoDB;
import masfraud.base.dao.AbstractMongoDBDAO;
import masfraud.base.to.MemberTO;
import masfraud.specialist.agent.accrual.SpecialistAccrualAgent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class MemberMongoDAO extends AbstractMongoDBDAO<MemberTO>{

	public MemberMongoDAO() {
        super(SpecialistAccrualAgent.mongoTemplate);
	}

	@Override
	protected String getCollectionName() {
		return CollectionsNames.COLLECTION_MEMBER.getNameCollection();
	}

    public MemberTO findMemberByToken(MemberTO memberTO) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where(NameFieldsMongoDB.MEMBER_TOKEN.getNameField()).in(memberTO.getTokens().get(0).getPrimaryValue()));
        return findBy(query, MemberTO.class);
    }
	
}
