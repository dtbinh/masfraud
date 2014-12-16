package masfraud.base.to;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class MemberTokenTO implements Serializable{

    private static final long serialVersionUID = 7578923395673543495L;

    @SerializedName("_id")
    private Long id;
    private String tokenName;
    private String tokenDescription;
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date expiryDate;
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createdDate;
    private String primaryValue;
    private String secondaryValue;
    private String status;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getTokenDescription() {
        return tokenDescription;
    }

    public void setTokenDescription(String tokenDescription) {
        this.tokenDescription = tokenDescription;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public String getPrimaryValue() {
        return primaryValue;
    }
    public void setPrimaryValue(String primaryValue) {
        this.primaryValue = primaryValue;
    }
    public String getSecondaryValue() {
        return secondaryValue;
    }
    public void setSecondaryValue(String secondaryValue) {
        this.secondaryValue = secondaryValue;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MemberTokenTO{" +
                "id=" + id +
                ", tokenName='" + tokenName + '\'' +
                ", tokenDescription='" + tokenDescription + '\'' +
                ", expiryDate=" + expiryDate +
                ", createdDate=" + createdDate +
                ", primaryValue='" + primaryValue + '\'' +
                ", secondaryValue='" + secondaryValue + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
