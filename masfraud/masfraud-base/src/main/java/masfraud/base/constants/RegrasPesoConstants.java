package masfraud.base.constants;

public enum RegrasPesoConstants {

    ACCRUAL_R01("R01AccrualCommand"),
    ACCRUAL_R02("R02AccrualCommand"),
    ACCRUAL_R03("R03AccrualCommand"),

    REDEMPTION_R01("R01RedemptionCommand"),
    REDEMPTION_R02("R02RedemptionCommand"),
    REDEMPTION_R03("R03RedemptionCommand"),

    PROFILE("R01ProfileCommand"),
    SAVE_MEMBER("SaveMemberCommand"),
    ;

    private String nameCommand;

    RegrasPesoConstants(String nivel){
        this.nameCommand = nivel;
    }

    public String getNameCommand() {
        return nameCommand;
    }


    public static RegrasPesoConstants getRegras(String nameCommand){

        for (RegrasPesoConstants regrasPesoConstants : RegrasPesoConstants.values()){
            if (regrasPesoConstants.getNameCommand().equals(nameCommand)){
                return regrasPesoConstants;
            }
        }
        return null;
    }


}
