package masfraud.specialist.agent.saveMember.command;

import masfraud.base.constants.ContextKeySpecialist;
import masfraud.base.constants.EventActionType;
import masfraud.base.constants.EventType;
import masfraud.base.to.MemberTO;
import masfraud.specialist.agent.base.command.CommandBase;
import masfraud.specialist.agent.factory.BeanFactory;
import masfraud.specialist.agent.saveMember.dao.MemberMongoDAO;
import org.apache.commons.chain.Context;

public class FindMemberCommand extends CommandBase {

    private MemberMongoDAO memberMongoDAO = BeanFactory.getMemberMongoDAO();


    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("FindMemberCommand");

        if (!context.containsKey(ContextKeySpecialist.MEMBER_TO.getValue())){
            System.err.println("Chave " + ContextKeySpecialist.MEMBER_TO.getValue() + " nao existe no context.");
            return false;
        }

        MemberTO memberTO = (MemberTO) context.get(ContextKeySpecialist.MEMBER_TO.getValue());
        memberTO = memberMongoDAO.findMemberByToken(memberTO);
        context.put(ContextKeySpecialist.MEMBER_TO.getValue(), memberTO);
        return true;
    }

    @Override
    public EventActionType getEventActionType() {
        return EventActionType.INSERT_MEMBER;
    }

    @Override
    public EventType getEventType() {
        return EventType.SAVE_MEMBER;
    }


}
