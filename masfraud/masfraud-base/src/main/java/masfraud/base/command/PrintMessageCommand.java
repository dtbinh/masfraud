package masfraud.base.command;

import java.io.Serializable;

import masfraud.base.constants.ContextKey;
import masfraud.base.message.BaseEvent;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

/**
 * 
 * @author Mauricio
 *
 */
public class PrintMessageCommand implements Command, Serializable{

	private static final long serialVersionUID = -7526051334154740447L;
	
	private static Logger LOG = Logger.getLogger(PrintMessageCommand.class);
	
	@Override
	public boolean execute(Context context) throws Exception {
		BaseEvent message = (BaseEvent) context.get(ContextKey.INCOMING_MESSAGE.getValue());
		LOG.info(context.get(ContextKey.AGENT_LOCAL_NAME.getValue()) + " recebeu o conteudo: " + BeanUtils.describe(message));
		System.out.println(context.get(ContextKey.AGENT_LOCAL_NAME.getValue()) + " recebeu o conteudo: " + BeanUtils.describe(message));
		return true;
	}

}
