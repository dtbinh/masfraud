package masfraud.specialist.agent.accrual.dao;

import masfraud.base.constants.CollectionsNames;
import masfraud.base.constants.NameFieldsMongoDB;
import masfraud.base.dao.AbstractMongoDBDAO;
import masfraud.base.to.AccrualLogTO;
import masfraud.specialist.agent.accrual.SpecialistAccrualAgent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AccrualMongoDAO extends AbstractMongoDBDAO<AccrualLogTO>{

    public AccrualMongoDAO() {
        super(SpecialistAccrualAgent.mongoTemplate);
    }

    @Override
    protected String getCollectionName() {
        return CollectionsNames.COLLECTION_ACCRUAL_LOG.getNameCollection();
    }

    public boolean getAccrualSameDayAndSameValue(AccrualLogTO accrualLogTO, int qtdAcumulos) throws ParseException {
        Date dataInicial = accrualLogTO.getTransactionDate();
        Date dataFinal = accrualLogTO.getTransactionDate();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00");

        Calendar c = Calendar.getInstance();
        c.setTime(dataFinal);
        c.add(Calendar.DATE, 1);

        String a = dateFormat.format(dataInicial);
        String b = dateFormat.format(c.getTime());

        Query query = new Query();
        query.addCriteria(Criteria.where(NameFieldsMongoDB.EVENT_MEMBER_TOKEN.getNameField()).is(accrualLogTO.getMemberTO().getTokens().get(0).getPrimaryValue()));
        query.addCriteria(Criteria.where(NameFieldsMongoDB.ACCRUAL_AMOUNT_VALUES.getNameField()).is(accrualLogTO.getAmountValue().toString()));
        query.addCriteria(Criteria.where(NameFieldsMongoDB.TRANSACTION_DATE.getNameField()).lt(dateFormat.parse(b)).gt(dateFormat.parse(a)));


        List<AccrualLogTO> accrualTOs = getMongoOperations().find(query, AccrualLogTO.class, getCollectionName());

        //Verifica se a lista de retorno contem registros ou esta vazia
        if (getMongoOperations().find(query, Object.class, getCollectionName()) == null || accrualTOs.isEmpty()){
            //Nao encontrou nenhum registro, entao a regra nao foi atendida.
            return false;
        }

        //Caso contenha e for maior que "qtdAcumulos" ou seja, maior que o parametro necessario para a regra
        //entao a regra foi atendia.
        else if (accrualTOs.size() > qtdAcumulos){
            return true;
        }

        //A regra nao foi atendia
        return false;

    }

}
