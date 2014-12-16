package masfraud.coordinator.read;

import com.google.gson.Gson;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import masfraud.base.constants.*;
import masfraud.base.message.GenericEvent;
import masfraud.base.to.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactory;

import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReadFiles {



    private final static String CAMINHO = "./masfraud-coordinator/src/test/files/";


    public static void main (String[] args) throws Exception {



        for (NameFilesConstants nameFilesConstants : NameFilesConstants.values()){

            File arquivo = new File(CAMINHO + nameFilesConstants.getNameFile());

            if(!arquivo.exists()){
                System.err.println("Arquivo " + nameFilesConstants.getNameFile() + " nao encontrado.");
            }

            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);

            String str = "";
            if (lerArq != null) {
                int firstLine = 0;
                while ((str = lerArq.readLine()) != null) {

                    String[] linha = StringUtils.splitPreserveAllTokens(str, ";");
                    if (firstLine == 0) {
                        firstLine++;
                        continue;
                    }

                    if (linha.length == 0) {
                        throw new Exception("Registro deve conter pelo menos um campo preenchido.");
                    }

                    String json = "";


                    ClientNetworkConfig networkConfig = new ClientNetworkConfig();
                    networkConfig.setConnectionAttemptLimit(15);

                    ClientConfig clientConfig = new ClientConfig();
                    clientConfig.setNetworkConfig(networkConfig);
                    HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

                    GenericEvent eventMessage = new GenericEvent();


                    if (nameFilesConstants.getNameFile().equals(NameFilesConstants.SAVE_MEMBER.getNameFile())){
                        eventMessage.setEventType(EventType.SAVE_MEMBER);
                        json = new Gson().toJson(populateMember(linha));
                        eventMessage.setPayload(json);
                        client.getQueue(EnvironmentConstants.INCOMING_EVENTS.getValue()).put(eventMessage);
                    }
                    else if (nameFilesConstants.getNameFile().equals(NameFilesConstants.ADDRESS_MEMBER.getNameFile())){
                        eventMessage.setEventType(EventType.PROFILE);
                        json = new Gson().toJson(populateAlterMember(linha));
                        eventMessage.setPayload(json);
                        client.getQueue(EnvironmentConstants.INCOMING_EVENTS.getValue()).put(eventMessage);
                    }
                    else if (nameFilesConstants.getNameFile().equals(NameFilesConstants.ACCRUAL.getNameFile())){
                        eventMessage.setEventType(EventType.ACCRUAL);
                        json = new Gson().toJson(populateAccrual(linha));
                        eventMessage.setPayload(json);
                        client.getQueue(EnvironmentConstants.INCOMING_EVENTS.getValue()).put(eventMessage);
                    }
                    else if (nameFilesConstants.getNameFile().equals(NameFilesConstants.REDEMPTION.getNameFile())){
                        eventMessage.setEventType(EventType.REDEMPTION);
                        json = new Gson().toJson(populateRedemption(linha));
                        eventMessage.setPayload(json);
                        client.getQueue(EnvironmentConstants.INCOMING_EVENTS.getValue()).put(eventMessage);
                    }
                }

            }
            Thread.sleep(2000);
        }

    }

    private static Object populateRedemption(String[] linha) throws ParseException {

        RedemptionLogTO redemptionLogTO = new RedemptionLogTO();

        int firstField = 0;
        RedemptionProductTO redemptionProductTO = new RedemptionProductTO();

        AccrualLogTO accrualLogTO = new AccrualLogTO();

        accrualLogTO.setSourceSystem(linha[firstField].trim());
        accrualLogTO.setSourceId(linha[firstField+=1].trim());

        accrualLogTO.setEventName(linha[firstField+=1].trim());
        accrualLogTO.setEventId(Integer.parseInt(linha[firstField+=1].trim()));

        LoyaltyProgramTO loyaltyProgramTO = new LoyaltyProgramTO();

        loyaltyProgramTO.setPleId(Integer.parseInt(linha[firstField += 1].trim()));
        accrualLogTO.setLoyaltyProgramTO(loyaltyProgramTO);
        MemberTO memberTO = new MemberTO();
        memberTO.setPleMemberId(Long.parseLong(linha[firstField += 1].trim()));
        accrualLogTO.setMemberTO(memberTO);



        if (!"".equals(linha[firstField += 1].trim())){
            redemptionProductTO.setIdOrder(Integer.parseInt(linha[firstField].trim()));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            redemptionProductTO.setIdOrderItem(Integer.parseInt(linha[firstField].trim()));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            redemptionProductTO.setIdProduct(Long.parseLong(linha[firstField].trim()));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            redemptionProductTO.setProductName(linha[firstField].trim());
        }

        if (!"".equals(linha[firstField += 1].trim())){
            redemptionProductTO.setQuatity(Integer.parseInt(linha[firstField].trim()));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            redemptionProductTO.setTotalValue(new BigDecimal(linha[firstField].trim()));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            redemptionProductTO.setFreightValue(new BigDecimal(linha[firstField].trim()));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            redemptionProductTO.setTaxesValue(new BigDecimal(linha[firstField].trim()));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            redemptionProductTO.setTotalDiscount(new BigDecimal(linha[firstField].trim()));
        }

        redemptionProductTO.setIdSkuSupplier(linha[firstField += 1].trim());



        AddressTemplateTO addressTemplateTO = new AddressTemplateTO();

        if (!"".equals(linha[firstField += 1].trim())){
            addressTemplateTO.setId(Integer.parseInt(linha[firstField].trim()));
        }
        addressTemplateTO.setFormat(linha[firstField += 1].trim());
        redemptionProductTO.setAddressTemplateTO(addressTemplateTO);

        if (!"".equals(linha[firstField += 1].trim())){
            redemptionProductTO.setIdMemberDeliveryAddress(Integer.parseInt(linha[firstField].trim()));
        }


        redemptionProductTO.setAddressValue(linha[firstField+=1].trim());

        if (!"".equals(linha[firstField += 1].trim())){
            redemptionProductTO.setIdOrderStatus(Integer.parseInt(linha[firstField].trim()));
        }

        redemptionProductTO.setSupplierStatusCode(linha[firstField+=1].trim());
        redemptionProductTO.setOrderItemSupplierId(linha[firstField+=1].trim());

        if (!"".equals(linha[firstField += 1].trim())){
            redemptionProductTO.setTotalPoints(new BigDecimal(linha[firstField].trim()));
        }
        redemptionProductTO.setDeliveryDate(linha[firstField+=1].trim());

        SupplierTO supplierTO = new SupplierTO();


        firstField += 1;
        if (!"".equals(linha[firstField += 1].trim())){
            supplierTO.setId(Integer.parseInt(linha[firstField].trim()));
        }
        supplierTO.setCorporateName(linha[firstField += 1].trim());
        redemptionProductTO.setSupplier(supplierTO);

        if (!"".equals(linha[firstField += 1].trim())){
            redemptionProductTO.setConversionRate(new BigDecimal(linha[firstField].trim()));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            redemptionProductTO.setAdjustFactor(new BigDecimal(linha[firstField].trim()));
        }
        redemptionProductTO.setAdjustFactorPercentual(linha[firstField += 1].trim());

        if (!"".equals(linha[firstField += 1].trim())){
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Calendar c = Calendar.getInstance();

            c.setTime(sdf.parse(linha[firstField].trim()));
            c.add(Calendar.SECOND, 1);
            redemptionProductTO.setCheckoutDate(c.getTime());
        }

        redemptionProductTO.setIdRedemptionChannel(linha[firstField+=1].trim());
        UserTO userTO = new UserTO();

        if (!"".equals(linha[firstField += 1].trim())){
            userTO.setId(Long.parseLong(linha[firstField].trim()));
        }

        userTO.setName(linha[firstField += 1].trim());

        redemptionProductTO.setUserTO(userTO);


        List<MemberTokenTO> memberTokenTOs = new ArrayList<MemberTokenTO>();
        MemberTokenTO memberTokenTO = new MemberTokenTO();
        memberTokenTO.setPrimaryValue(linha[firstField += 1].trim());
        memberTokenTO.setSecondaryValue(linha[firstField += 1].trim());
        memberTokenTOs.add(memberTokenTO);

        memberTO.setTokens(memberTokenTOs);

        redemptionLogTO.setMemberTO(memberTO);
        redemptionLogTO.setRedemptionProductTO(redemptionProductTO);

        return redemptionLogTO;
    }

    private static Object populateAccrual(String[] linha) throws ParseException {

        int firstField = 0;
        AccrualLogTO accrualLogTO = new AccrualLogTO();

        accrualLogTO.setSourceSystem(linha[firstField].trim());
        accrualLogTO.setSourceId(linha[firstField+=1].trim());

        accrualLogTO.setEventName(linha[firstField+=1].trim());
        accrualLogTO.setEventId(Integer.parseInt(linha[firstField+=1].trim()));

        LoyaltyProgramTO loyaltyProgramTO = new LoyaltyProgramTO();

        loyaltyProgramTO.setPleId(Integer.parseInt(linha[firstField += 1].trim()));
        accrualLogTO.setLoyaltyProgramTO(loyaltyProgramTO);
        MemberTO memberTO = new MemberTO();
        memberTO.setPleMemberId(Long.parseLong(linha[firstField += 1].trim()));
        accrualLogTO.setMemberTO(memberTO);

        accrualLogTO.setUUID(linha[firstField += 1].trim());
        accrualLogTO.setTypeString(linha[firstField += 1].trim());
        accrualLogTO.setCharacteristic(linha[firstField += 1].trim());

        CurrencyTO currencyTO = new CurrencyTO();

        if (!"".equals(linha[firstField += 1].trim())){
            currencyTO.setId(Integer.parseInt(linha[firstField].trim()));
        }
        currencyTO.setCode(linha[firstField += 1].trim());
        currencyTO.setName(linha[firstField += 1].trim());
        accrualLogTO.setCurrencyTO(currencyTO);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();

        if (!"".equals(linha[firstField += 1].trim())){
            accrualLogTO.setIdIssuingPatner(Integer.parseInt(linha[firstField].trim()));
        }
        accrualLogTO.setNamePartner(linha[firstField += 1].trim());

        if (!"".equals(linha[firstField += 1].trim())){
            c.setTime(sdf.parse(linha[firstField].trim()));
            c.add(Calendar.SECOND, 1);
            accrualLogTO.setTransactionDate(c.getTime());
        }

        if (!"".equals(linha[firstField += 1].trim())){
            c.setTime(sdf.parse(linha[firstField].trim()));
            c.add(Calendar.SECOND, 1);
            accrualLogTO.setExpiryDate(c.getTime());
        }

        if (!"".equals(linha[firstField += 1].trim())){
            accrualLogTO.setAmountValue(new BigDecimal(linha[firstField].trim()));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            accrualLogTO.setAmountPoints(new BigDecimal(linha[firstField].trim()));
        }

        List<MemberTokenTO> memberTokenTOs = new ArrayList<MemberTokenTO>();
        MemberTokenTO memberTokenTO = new MemberTokenTO();
        memberTokenTO.setPrimaryValue(linha[firstField += 1].trim());
        memberTokenTOs.add(memberTokenTO);
        memberTO.setTokens(memberTokenTOs);

        return accrualLogTO;
    }

    private static Object populateAlterMember(String[] linha) {

        int firstField = 0;
        MemberTO memberTO = new MemberTO();

        memberTO.setSourceSystem(linha[firstField].trim());
        memberTO.setSourceId(linha[firstField+=1].trim());

        memberTO.setEventName(linha[firstField+=1].trim());
        memberTO.setEventId(Integer.parseInt(linha[firstField+=1].trim()));

        LoyaltyProgramTO loyaltyProgramTO = new LoyaltyProgramTO();
        loyaltyProgramTO.setPleId(Integer.parseInt(linha[firstField += 1].trim()));
        memberTO.setLoyaltyProgramTO(loyaltyProgramTO);
        memberTO.setPleMemberId(Long.parseLong(linha[firstField += 1].trim()));

        AddressTO addressTO = new AddressTO();

        AddressTemplateTO addressTemplateTO = new AddressTemplateTO();

        if (!"".equals(linha[firstField += 1].trim())){
            addressTemplateTO.setId(Integer.parseInt(linha[firstField].trim()));
        }
        addressTO.setAddressTemplateTO(addressTemplateTO);


        if (!"".equals(linha[firstField += 1].trim())){
            addressTemplateTO.setFormat(linha[firstField].trim());
        }
        addressTO.setName(linha[firstField += 1].trim());
        addressTO.setValues(linha[firstField += 1].trim());
        firstField += 1;

        //addressTO.setProgramAddressName(linha[firstField+=1].trim());

        List<MemberTokenTO> memberTokenTOs = new ArrayList<>();
        MemberTokenTO memberTokenTO = new MemberTokenTO();
        memberTokenTO.setPrimaryValue(linha[firstField += 1].trim());
        memberTokenTO.setSecondaryValue(linha[firstField += 1].trim());
        memberTokenTOs.add(memberTokenTO);
        memberTO.setTokens(memberTokenTOs);

        List<AddressTO> addressTOs = new ArrayList<>();
        addressTOs.add(addressTO);
        memberTO.setDeliveryAddress(addressTOs);

        return memberTO;
    }


    private static MemberTO populateMember(String[] linha) throws ParseException {

        int firstField = 0;
        MemberTO memberTO = new MemberTO();

        memberTO.setSourceSystem(linha[firstField].trim());
        memberTO.setSourceId(linha[firstField+=1].trim());

        memberTO.setEventName(linha[firstField+=1].trim());
        memberTO.setEventId(Integer.parseInt(linha[firstField+=1].trim()));

        LoyaltyProgramTO loyaltyProgramTO = new LoyaltyProgramTO();
        loyaltyProgramTO.setPleId(Integer.parseInt(linha[firstField += 1].trim()));
        memberTO.setLoyaltyProgramTO(loyaltyProgramTO);
        memberTO.setPleMemberId(Long.parseLong(linha[firstField += 1].trim()));

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();


        MemberStatusTO memberStatusTO = new MemberStatusTO();
        memberStatusTO.setId(Integer.parseInt(linha[firstField += 1].trim()));
        memberStatusTO.setName(linha[firstField += 1].trim());
        memberTO.setMemberStatusTO(memberStatusTO);
        if (!"".equals(linha[firstField += 1].trim())){
            c.setTime(sdf.parse(linha[firstField].trim()));
            c.add(Calendar.SECOND, 1);
            memberTO.setEnrolDate(c.getTime());
        }
        if (!"".equals(linha[firstField += 1].trim())){
            c.setTime(sdf.parse(linha[firstField].trim()));
            c.add(Calendar.SECOND, 1);
            memberTO.setRegisterDate(c.getTime());
        }
        memberTO.setSalutation(linha[firstField += 1].trim());
        memberTO.setFirstName(linha[firstField += 1].trim());
        memberTO.setMiddleName(linha[firstField += 1].trim());
        memberTO.setLastName(linha[firstField += 1].trim());

        if (!"".equals(linha[firstField += 1].trim())){
            c.setTime(sdf.parse(linha[firstField].trim()));
            c.add(Calendar.SECOND, 1);
            memberTO.setBirthDate(c.getTime());
        }

        memberTO.setGender(Gender.getByValue(linha[firstField += 1].trim()));
        memberTO.setMaritalStatus(MaritalStatus.getByValue(linha[firstField += 1].trim()));
        memberTO.setNationality(linha[firstField += 1].trim());

        if (!"".equals(linha[firstField += 1].trim())){
            c.setTime(sdf.parse(linha[firstField].trim()));
            c.add(Calendar.SECOND, 1);
            memberTO.setUpdateDate(c.getTime());
        }

        memberTO.setAcceptReceiveCall(parse(linha[firstField += 1].trim()));
        memberTO.setAcceptReceiveEmail(parse(linha[firstField += 1].trim()));
        memberTO.setAcceptReceiveSMS(parse(linha[firstField += 1].trim()));

        List<MemberTokenTO> memberTokenTOs = new ArrayList<MemberTokenTO>();
        MemberTokenTO memberTokenTO = new MemberTokenTO();
        memberTokenTO.setPrimaryValue(linha[firstField += 1].trim());
        memberTokenTOs.add(memberTokenTO);
        memberTO.setTokens(memberTokenTOs);

        MemberSummaryBalanceTO memberSummaryBalanceTO = new MemberSummaryBalanceTO();

        if (!"".equals(linha[firstField += 1].trim())){
            memberSummaryBalanceTO.setPreviousBalance(new BigDecimal(linha[firstField]));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            memberSummaryBalanceTO.setBilledCredit(new BigDecimal(linha[firstField]));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            memberSummaryBalanceTO.setBilledDebit(new BigDecimal(linha[firstField]));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            memberSummaryBalanceTO.setCurrentBalance(new BigDecimal(linha[firstField]));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            memberSummaryBalanceTO.setUnbilledCredit(new BigDecimal(linha[firstField]));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            memberSummaryBalanceTO.setUnbilledDebit(new BigDecimal(linha[firstField]));
        }

        if (!"".equals(linha[firstField += 1].trim())){
            memberSummaryBalanceTO.setFutureBalance(new BigDecimal(linha[firstField]));
        }

        memberTO.setMemberSummaryBalanceTO(memberSummaryBalanceTO);

        return memberTO;
    }


    private static boolean parse(String valor){
        if ("S".equalsIgnoreCase(valor) || "SIM".equalsIgnoreCase(valor)){
            return true;
        }
        return false;
    }

}
