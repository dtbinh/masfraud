package masfraud.base.to;

import com.google.gson.annotations.SerializedName;
import masfraud.base.message.BaseEvent;
import org.bson.types.ObjectId;

import java.io.Serializable;

public abstract class AbstractBaseTO extends BaseEvent implements Serializable{

	protected static final long serialVersionUID = 2957636808438381307L;

    @SerializedName("_id")
	protected ObjectId id;
	
	protected String idStr;

	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public String getIdStr() {
		if(id != null){
			return id.toString();
		}
		return idStr;
	}
	
	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}
	
	
}
