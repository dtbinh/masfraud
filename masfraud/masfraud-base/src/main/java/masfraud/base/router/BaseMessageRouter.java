package masfraud.base.router;

import java.io.Serializable;
import org.apache.commons.chain.Context;

/**
 * 
 * @author Mauricio
 *
 */
public abstract class BaseMessageRouter implements Serializable{

	private static final long serialVersionUID = 3268543578295139664L;
	
	public abstract Boolean routeMessage(final Context context);

}
