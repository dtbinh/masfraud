package masfraud.specialist.agent.accrual.command;

import masfraud.base.constants.ContextKeySpecialist;
import masfraud.base.to.AccrualLogTO;
import masfraud.specialist.agent.accrual.dao.AccrualMongoDAO;
import masfraud.specialist.agent.base.command.CommandDescription;
import masfraud.specialist.agent.factory.BeanFactory;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/***
 * Command responsavel por validar a regra R01Accrual
 * "Mais de um acumulo com o mesmo valor no mesmo dia"
 *
 * A quantidade de acumulos esta no proprio fonte que sera 5.
 * Entao a regra deve ser lida da seguinte forma:
 *
 * "Se tiver mais de 5 acumulos no mesmo dia para o mesmo TOKEN, entao a regra sera atendida."
 *
 */
public class R01AccrualCommand implements CommandDescription{


    private AccrualMongoDAO accrualMongoDAO = BeanFactory.getAccrualMongoDAO();

    @Override
    public boolean execute(Context ctx) throws Exception {
        System.out.println("R01AccrualCommand ===>> Mais de um acumulo com o mesmo valor no mesmo dia.");


        if (!ctx.containsKey(ContextKeySpecialist.ACCRUAL_LOG_TO.getValue())){
            System.err.println("Chave " + ContextKeySpecialist.ACCRUAL_LOG_TO.getValue() + " nao esta no Context.");
            return false;
        }

        AccrualLogTO accrualTO = (AccrualLogTO) ctx.get(ContextKeySpecialist.ACCRUAL_LOG_TO.getValue());

        //Qtd maior do que 5 que vao atender a regra
        int qtdAcumulos = 5;

        return accrualMongoDAO.getAccrualSameDayAndSameValue(accrualTO, qtdAcumulos);

    }

    @Override
    public String getDescriptionRule() {
        return "Mais de um acúmulo com o MESMO VALOR no MESMO DIA.";
    }
}
