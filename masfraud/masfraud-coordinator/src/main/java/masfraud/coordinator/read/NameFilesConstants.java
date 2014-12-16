package masfraud.coordinator.read;

/**
 * Created with IntelliJ IDEA.
 * User: sorge
 * Date: 12/8/14
 * Time: 2:49 PM
 * To change this template use File | Settings | File Templates.
 */
public enum NameFilesConstants {


    SAVE_MEMBER("INSERT_MEMBER.txt"),
    ACCRUAL("FINANCIAL_EARN.txt"),
    ADDRESS_MEMBER("MEMBER_DELIVERY_ADDRESS.txt"),
    REDEMPTION("REDEMPTION_REWARDS.txt"),

    ;


    private String nameFile;

    NameFilesConstants(String nameFile){
        this.nameFile = nameFile;
    }

    public String getNameFile() {
        return nameFile;
    }
}
