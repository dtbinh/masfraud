package masfraud.base.constants;

/**
 * Created with IntelliJ IDEA.
 * User: sorge
 * Date: 12/3/14
 * Time: 12:15 PM
 * To change this template use File | Settings | File Templates.
 */
public enum NameFieldsMongoDB {



    EVENT_MEMBER_TOKEN("memberTO.tokens.primaryValue"),
    MEMBER_TOKEN("tokens.primaryValue"),
    ACCRUAL_AMOUNT_VALUES("amountValue"),
    ACCRUAL_AMOUNT_POINTS("amountPoints"),
    TRANSACTION_DATE("transactionDate"),
    EVENT_DATE("eventDate"),
    EVENT_ACTION_TYPE("eventActionType"),

    ;


    private String nameField;


    NameFieldsMongoDB(String nameField){
        this.nameField = nameField;
    }

    public String getNameField() {
        return nameField;
    }
}
