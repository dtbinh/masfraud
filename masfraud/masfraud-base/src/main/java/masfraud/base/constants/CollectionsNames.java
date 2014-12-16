package masfraud.base.constants;

public enum CollectionsNames {

    COLLECTION_MEMBER("MEMBER"),
    COLLECTION_EVENT("EVENT_LOG"),
    COLLECTION_PROFILE("PROFILE_LOG"),
    COLLECTION_ACCRUAL_LOG("ACCRUAL_LOG"),
    COLLECTION_REDEMPTION_LOG("REDEMPTION_LOG"),
    COLLECTION_ALERT_LOG("ALERT_LOG"),
    ;


    private String nameCollection;

    CollectionsNames(String nameCollection){
        this.nameCollection = nameCollection;
    }

    public String getNameCollection() {
        return nameCollection;
    }
}
