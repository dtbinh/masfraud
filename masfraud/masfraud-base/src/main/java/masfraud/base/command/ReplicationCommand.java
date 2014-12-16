package masfraud.base.command;

import java.io.Serializable;

import masfraud.base.BaseAgent;
import masfraud.base.constants.ContextKey;
import masfraud.base.message.ReplicaEvent;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

public class ReplicationCommand implements Command, Serializable{

	private static final long serialVersionUID = -6449520919848838129L;

	@Override
	public boolean execute(Context ctx) throws Exception {
		ReplicaEvent message = (ReplicaEvent)ctx.get(ContextKey.MESSAGE.getValue());
		
		System.out.println("REPLICATION COMMAND: " + BeanUtils.describe(message));
		
		BaseAgent agent = (BaseAgent) ctx.get(ContextKey.AGENT_INSTANCE.getValue());
		
		System.out.println("BaseAgent:" + BeanUtils.describe(agent));
		
		agent.replicate(message.getReplicaName(), message.getContainerDest());
		return false;
	}

}
