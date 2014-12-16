package masfraud.specialist.agent.redemption.command;

import masfraud.base.constants.ContextKeySpecialist;
import masfraud.base.constants.EventType;
import masfraud.base.to.EventLogTO;
import masfraud.base.to.MemberTO;
import masfraud.specialist.agent.base.command.CommandDescription;
import masfraud.specialist.agent.base.dao.EventMongoDAO;
import masfraud.specialist.agent.factory.BeanFactory;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class R02RedemptionCommand implements CommandDescription {


    private EventMongoDAO eventMongoDAO = BeanFactory.getEventMongoDAO();

 	@Override
	public boolean execute(Context ctx) throws Exception {
        System.out.println("R02RedemptionCommand ===>> Varios resgates em dias seguidos.");


        if (!ctx.containsKey(ContextKeySpecialist.MEMBER_TO.getValue())){
            System.err.println("Chave " + ContextKeySpecialist.MEMBER_TO.getValue() + " nao existe no context.");
            return false;
        }

        MemberTO memberTO = (MemberTO) ctx.get(ContextKeySpecialist.MEMBER_TO.getValue());

        Date dataInicial = new Date();
        Date dataFinal = new Date();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00");

        Calendar c = Calendar.getInstance();
        c.setTime(dataFinal);
        c.add(Calendar.DATE, -3);

        String a = dateFormat.format(dataInicial);
        String b = dateFormat.format(c.getTime());

        List<EventLogTO> eventLogTOList = eventMongoDAO.findByRedemptionByRageDate(EventType.REDEMPTION.getValue(), dateFormat.parse(b), dateFormat.parse(a), memberTO);


        //Se existir o registro entao a regra foi atendida, entao retorna true
        //se nao retorna false, ou seja, a regra nao foi atendida.
        return eventLogTOList != null;
	}

    @Override
    public String getDescriptionRule() {
        return "Vários resgates em dias seguidos.";
    }
}
