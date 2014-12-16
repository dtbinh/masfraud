package masfraud.base.constants;

public enum ServiceName {

    ACCRUAL("accrual"),
    REDEMPTION("redemption"),
    PROFILE("profile"),
    SAVE_MEMBER("saveMember");

    private String serviceName;


    ServiceName(String serviceName){
        this.serviceName = serviceName;
    }


    public String getServiceName() {
        return serviceName;
    }
}
