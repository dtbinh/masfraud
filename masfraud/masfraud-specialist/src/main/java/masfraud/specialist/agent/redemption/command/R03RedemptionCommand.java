package masfraud.specialist.agent.redemption.command;

import masfraud.base.constants.ContextKeySpecialist;
import masfraud.base.to.MemberTO;
import masfraud.specialist.agent.base.command.CommandDescription;
import masfraud.specialist.agent.factory.BeanFactory;
import masfraud.specialist.agent.saveMember.dao.MemberMongoDAO;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import java.math.BigDecimal;

public class R03RedemptionCommand implements CommandDescription {

    private MemberMongoDAO memberMongoDAO = BeanFactory.getMemberMongoDAO();

    @Override
    public boolean execute(Context ctx) throws Exception {
        System.out.println("R03RedemptionCommand ===>> Resgate zerando os pontos acumulados.");


        if (!ctx.containsKey(ContextKeySpecialist.MEMBER_TO.getValue())){
            System.err.println("Chave " + ContextKeySpecialist.MEMBER_TO.getValue() + " nao existe no context.");
            return false;
        }

        MemberTO memberTO = (MemberTO) ctx.get(ContextKeySpecialist.MEMBER_TO.getValue());
        memberTO = memberMongoDAO.findMemberByToken(memberTO);

        if (memberTO.getMemberSummaryBalanceTO() != null){
            return true;
        }
        else if (memberTO.getMemberSummaryBalanceTO().getFutureBalance().compareTo(BigDecimal.ZERO) == 0){
            return true;
        }

        return false;
    }

    @Override
    public String getDescriptionRule() {
        return "Resfaste zerando os pontos acúmulados.";
    }
}
