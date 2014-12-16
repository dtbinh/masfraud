package masfraud.specialist.agent.base.command;

import org.apache.commons.chain.Command;

/**
 * Created with IntelliJ IDEA.
 * User: sorge
 * Date: 12/12/14
 * Time: 1:57 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CommandDescription extends Command {


    String getDescriptionRule();
}
