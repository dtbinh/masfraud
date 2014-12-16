package masfraud.specialist.agent.base.dao;

import masfraud.base.constants.CollectionsNames;
import masfraud.base.constants.EventActionType;
import masfraud.base.constants.NameFieldsMongoDB;
import masfraud.base.dao.AbstractMongoDBDAO;
import masfraud.base.to.AccrualLogTO;
import masfraud.base.to.EventLogTO;
import masfraud.base.to.MemberTO;
import masfraud.specialist.agent.accrual.SpecialistAccrualAgent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EventMongoDAO extends AbstractMongoDBDAO<EventLogTO>{

    public EventMongoDAO() {
        super(SpecialistAccrualAgent.mongoTemplate);
    }

    @Override
    protected String getCollectionName() {
        return CollectionsNames.COLLECTION_EVENT.getNameCollection();
    }


    public List<EventLogTO> findByEventType(String event, MemberTO memberTO) throws Exception {
        Date dataInicial = new Date();
        Date dataFinal = new Date();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00");

        Calendar c = Calendar.getInstance();
        c.setTime(dataFinal);
        c.add(Calendar.DATE, 1);

        String a = dateFormat.format(dataInicial);
        String b = dateFormat.format(c.getTime());


        Query query = new Query();
        query.addCriteria(Criteria.where(NameFieldsMongoDB.EVENT_MEMBER_TOKEN.getNameField()).in(memberTO.getTokens().get(0).getPrimaryValue()));
        query.addCriteria(Criteria.where(NameFieldsMongoDB.EVENT_ACTION_TYPE.getNameField()).in(event));
        query.addCriteria(Criteria.where(NameFieldsMongoDB.EVENT_DATE.getNameField()).lt(dateFormat.parse(b)).gt(dateFormat.parse(a)));

        return find(query, EventLogTO.class);
    }

    public List<EventLogTO> findByRedemptionByRageDate(String event, Date dataFinal, Date dataInicila, MemberTO memberTO) throws Exception {

        Query query = new Query();
        query.addCriteria(Criteria.where(NameFieldsMongoDB.EVENT_MEMBER_TOKEN.getNameField()).in(memberTO.getTokens().get(0).getPrimaryValue()));
        query.addCriteria(Criteria.where(NameFieldsMongoDB.EVENT_ACTION_TYPE.getNameField()).in(event));
        query.addCriteria(Criteria.where(NameFieldsMongoDB.EVENT_DATE.getNameField()).lt(dataFinal).gt(dataInicila));

        return find(query, EventLogTO.class);
    }


    public List<EventLogTO> findAccrualRangeDate(AccrualLogTO accrualTO, EventActionType event, Integer qtdDiasSeguidos) throws Exception {


        Date dataInicial = new Date();
        Date dataFinal = new Date();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00");

        Calendar c = Calendar.getInstance();
        c.setTime(dataFinal);
        c.add(Calendar.DATE, qtdDiasSeguidos*-1);

        Calendar c1 = Calendar.getInstance();
        c1.setTime(dataInicial);
        c1.add(Calendar.DATE, 1);

        String a = dateFormat.format(c1.getTime());
        String b = dateFormat.format(c.getTime());


        Query query = new Query();
        query.addCriteria(Criteria.where(NameFieldsMongoDB.EVENT_MEMBER_TOKEN.getNameField()).in(accrualTO.getMemberTO().getTokens().get(0).getPrimaryValue()));
        query.addCriteria(Criteria.where(NameFieldsMongoDB.EVENT_ACTION_TYPE.getNameField()).in(event.getValue()));
        query.addCriteria(Criteria.where(NameFieldsMongoDB.EVENT_DATE.getNameField()).lt(dateFormat.parse(a)).gt(dateFormat.parse(b)));

        return find(query, EventLogTO.class);
    }
}