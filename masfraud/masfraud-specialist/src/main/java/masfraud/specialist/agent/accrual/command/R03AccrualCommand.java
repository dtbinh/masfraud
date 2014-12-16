package masfraud.specialist.agent.accrual.command;

import masfraud.base.constants.ContextKeySpecialist;
import masfraud.base.to.AccrualLogTO;
import masfraud.specialist.agent.accrual.dao.AccrualMongoDAO;
import masfraud.specialist.agent.base.command.CommandDescription;
import masfraud.specialist.agent.factory.BeanFactory;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

public class R03AccrualCommand implements CommandDescription {

    @Override
	public boolean execute(Context ctx) throws Exception {
        System.out.println("R03AccrualCommand ===>> Acumulo de um valor alto em uma unica vez.");


        if (!ctx.containsKey(ContextKeySpecialist.ACCRUAL_LOG_TO.getValue())){
            System.err.println("Chave " + ContextKeySpecialist.ACCRUAL_LOG_TO.getValue() + " nao esta no Context.");
            return false;
        }

        AccrualLogTO accrualTO = (AccrualLogTO) ctx.get(ContextKeySpecialist.ACCRUAL_LOG_TO.getValue());

        if (accrualTO.getAmountValue().compareTo(new BigDecimal("1000.00")) > 0){
            return true;
        }
		return false;
	}

    @Override
    public String getDescriptionRule() {
        return "Acúmulo de uma VALOR ALTO em uma única vez.";
    }
}
