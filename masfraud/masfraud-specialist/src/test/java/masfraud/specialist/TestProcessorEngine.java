package masfraud.specialist;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import masfraud.base.ContextMasfraud;
import masfraud.base.constants.ContextKey;
import masfraud.base.constants.ContextKeySpecialist;
import masfraud.base.constants.ServiceName;
import masfraud.base.to.AccrualLogTO;
import masfraud.base.to.MemberTO;
import masfraud.base.to.MemberTokenTO;
import masfraud.base.to.ObjectParse;
import masfraud.specialist.agent.ProcessorEngine;
import masfraud.specialist.agent.accrual.SpecialistAccrualAgent;
import masfraud.specialist.agent.accrual.command.R01AccrualCommand;
import masfraud.specialist.agent.accrual.command.R02AccrualCommand;
import masfraud.specialist.agent.redemption.command.R01RedemptionCommand;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sorge
 * Date: 12/1/14
 * Time: 5:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestProcessorEngine{

    public static void main (String[] args) throws Exception {
        ServerAddress address = new ServerAddress("localhost", 27017);
        MongoClient mongoClient = new MongoClient(address);
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, "masfraud");
        SpecialistAccrualAgent.mongoTemplate = new MongoTemplate(mongoDbFactory);
        System.out.println(SpecialistAccrualAgent.mongoTemplate.getDb());


        AccrualLogTO accrualLogTO = new AccrualLogTO();
        accrualLogTO.setAmountValue(new BigDecimal("10000.000000"));

        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 9, 30, 0, 0, 0);

        accrualLogTO.setTransactionDate(calendar.getTime());
        MemberTO memberTO = new MemberTO();

        memberTO.setFirstName("FIRST NAME");
        memberTO.setMiddleName("MIDDLE NAME");
        memberTO.setLastName("LAST NAME");

        List<MemberTokenTO> memberTokenTOs = new ArrayList<MemberTokenTO>();
        MemberTokenTO memberTokenTO = new MemberTokenTO();
        memberTokenTO.setPrimaryValue("tatiane.torr@yopmail.com");
        memberTokenTOs.add(memberTokenTO);
        memberTO.setTokens(memberTokenTOs);
        accrualLogTO.setMemberTO(memberTO);
        ContextMasfraud contextMasfraud = new ContextMasfraud();
        contextMasfraud.put(ContextKeySpecialist.ACCRUAL_LOG_TO.getValue(), accrualLogTO);


        new R02AccrualCommand().execute(contextMasfraud);

    }

}
