package masfraud.specialist.agent;


import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.gson.Gson;
import masfraud.base.constants.*;
import masfraud.base.to.*;
import masfraud.specialist.agent.accrual.SpecialistAccrualAgent;
import masfraud.specialist.agent.base.command.CommandDescription;
import masfraud.specialist.agent.factory.BeanFactory;
import org.apache.commons.chain.Context;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProcessorEngine implements Serializable{


    private static ProcessorEngine processorEngine;

    private static final ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    private static ClassPath classPath = null;

    static {
        try {
            classPath = ClassPath.from(classLoader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private ProcessorEngine(){
        //Construtor privado para ser utilizado somente
        //o getInstance();
    }

    public static ProcessorEngine getInstance(){
        if (processorEngine == null){
            processorEngine = new ProcessorEngine();
        }
        return processorEngine;
    }



    public void engine(Context context, ServiceName serviceName) throws Exception {


        //Monta o caminho dos pacotes que contem as commands.
        String packages = "masfraud.specialist.agent." + serviceName.getServiceName() + ".command";

        //Pega somente as classe que foram carregadas do pacote que foi especificado.
        ImmutableSet<ClassPath.ClassInfo> commands = classPath.getTopLevelClasses(packages);

        //Verifica se existe o pacote para carregar as commands
        if (commands == null || commands.isEmpty()){
            System.err.println("Nao existe 'command' no pacote " + packages + " para ser processada.");
            return;
        }

        if (!context.containsKey(ContextKey.STRING_MESSAGE.getValue())){
            System.err.println("Contexto nao contem a chave " + ContextKey.STRING_MESSAGE.getValue() + " impossivel continuar o processamento.");
            return;
        }

        String msg = (String) context.get(ContextKey.STRING_MESSAGE.getValue());

        verifyAndCreateInstance(serviceName.getServiceName(), context, msg);

        Integer contadorPesoRegras = 0;


        List<DetectionRuleTO> detectionRuleTOs = new ArrayList<DetectionRuleTO>();

        //Varre as commands do pacote espefico
        for (ClassPath.ClassInfo classInfo : commands){


            CommandDescription command = ((CommandDescription)classInfo.load().newInstance());
            //executa a instancia da command e chama o metodo 'execute' da command,
            //caso ela seje verdadeira que dizer que a regra que esta dentro da command foi atendida
            if (command.execute(context)){
                System.out.println("Regra " + command.getClass().getSimpleName() + " foi atendida.");
                DetectionRuleTO detectionRuleTO = new DetectionRuleTO();
                int peso = (Integer) SpecialistAccrualAgent.client.getMap(EnvironmentConstants.SCORE_TABLE.getValue()).get(RegrasPesoConstants.getRegras(command.getClass().getSimpleName()).getNameCommand());
                detectionRuleTO.setScore(peso);
                detectionRuleTO.setName(command.getClass().getSimpleName());
                detectionRuleTO.setDescription(command.getDescriptionRule());
                contadorPesoRegras += peso;
                detectionRuleTOs.add(detectionRuleTO);
                //Verifica o peso dessa regra {100, 200, 300..etc..}
            }

        }

        System.out.println("=====>>Score" + contadorPesoRegras);
        //Soh vai gerar alerta se
        if (contadorPesoRegras != 0){
            context.put(EnvironmentConstants.DETECTION_RULE_TOs.getValue(), detectionRuleTOs);

            NotificationTO notificationTO = new NotificationTO();
            notificationTO.setScore(contadorPesoRegras);
            context.put(EnvironmentConstants.NOTIFICATION_TO.getValue(), notificationTO);

            if (contadorPesoRegras >= (Integer)SpecialistAccrualAgent.client.getMap(EnvironmentConstants.ALERT_TABLE.getValue()).get(AlertaNiveisConstants.CRITICO.getNivel())){
                notificationTO.setNotificationType(NotificationType.CRITICAL);
                BeanFactory.getSaveAlertCommand().execute(context);
            }
            else if (contadorPesoRegras >= (Integer)SpecialistAccrualAgent.client.getMap(EnvironmentConstants.ALERT_TABLE.getValue()).get(AlertaNiveisConstants.ALTO.getNivel())){
                notificationTO.setNotificationType(NotificationType.HIGH);
                BeanFactory.getSaveAlertCommand().execute(context);
            }
            else if (contadorPesoRegras >= (Integer)SpecialistAccrualAgent.client.getMap(EnvironmentConstants.ALERT_TABLE.getValue()).get(AlertaNiveisConstants.MEDIO.getNivel())){
                notificationTO.setNotificationType(NotificationType.MEDIUM);
                BeanFactory.getSaveAlertCommand().execute(context);
            }
            else if (contadorPesoRegras >= (Integer)SpecialistAccrualAgent.client.getMap(EnvironmentConstants.ALERT_TABLE.getValue()).get(AlertaNiveisConstants.BAIXO.getNivel())){
                notificationTO.setNotificationType(NotificationType.LOW);
                BeanFactory.getSaveAlertCommand().execute(context);
            }
            else if (contadorPesoRegras >= (Integer)SpecialistAccrualAgent.client.getMap(EnvironmentConstants.ALERT_TABLE.getValue()).get(AlertaNiveisConstants.INFORMATIVO.getNivel())){
                notificationTO.setNotificationType(NotificationType.INFO);
                BeanFactory.getSaveAlertCommand().execute(context);
            }
        }




        //acumular esse peso em uma variavel local, e ao finalizar as regras comparar em qual local a soma dos pesos entra {critical, high, low ...etc..}

    }

    private void verifyAndCreateInstance(String serviceName, Context context, String msg) {
        if (ServiceName.ACCRUAL.getServiceName().equals(serviceName)){
            ObjectParse objectParse = new Gson().fromJson(msg, ObjectParse.class);
            context.put(ContextKeySpecialist.ACCRUAL_LOG_TO.getValue(), objectParse.getAccrualLogTO());
        }
        else if (ServiceName.SAVE_MEMBER.getServiceName().equals(serviceName)){
            ObjectParse objectParse = new Gson().fromJson(msg, ObjectParse.class);
            context.put(ContextKeySpecialist.MEMBER_TO.getValue(), objectParse.getMemberTO());
        }
        else if (ServiceName.REDEMPTION.getServiceName().equals(serviceName)){
            ObjectParse objectParse = new Gson().fromJson(msg, ObjectParse.class);
            context.put(ContextKeySpecialist.REDEMPTION_LOG_TO.getValue(), objectParse.getRedemptionLogTO());
        }
        else if (ServiceName.PROFILE.getServiceName().equals(serviceName)){
            ObjectParse objectParse = new Gson().fromJson(msg, ObjectParse.class);
            context.put(ContextKeySpecialist.MEMBER_TO.getValue(), objectParse.getMemberTO());
        }
    }

}
