package masfraud.coordinator.sensors;

import masfraud.base.BaseAgent;
import masfraud.base.constants.EnvironmentConstants;
import masfraud.base.constants.RoleNameConstants;
import masfraud.base.message.GenericEvent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;

import com.google.gson.Gson;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ItemEvent;
import com.hazelcast.core.ItemListener;

public class IncomingEventSensor implements ItemListener<Object>{

    private BaseAgent baseAgent;
    private HazelcastInstance hazelcastClient;


    public IncomingEventSensor(final BaseAgent baseAgent, final HazelcastInstance hazelcastClient) {
        this.baseAgent = baseAgent;
        this.hazelcastClient = hazelcastClient;
    }

    @Override
    public void itemAdded(ItemEvent<Object> item) {
        System.out.println("Agente: " + this.baseAgent.getLocalName() + " vai pegar a mensagem...");
        GenericEvent eventMessage = (GenericEvent) hazelcastClient.getQueue(EnvironmentConstants.INCOMING_EVENTS.getValue()).poll();
        System.out.println("Event Message: " + eventMessage.toString());

        if(eventMessage !=null){

            ACLMessage message = null;

            switch (eventMessage.getEventType()) {
                case ACCRUAL:

                    //Enviar mensagem para o agente especialista accrual
                    message = new ACLMessage(ACLMessage.INFORM);
                    message.addReceiver(new AID(RoleNameConstants.SPECIALIST_ACCRUAL.getValue() + "_V", false));
                    message.setContent(new Gson().toJson(eventMessage));
                    this.baseAgent.send(message);

                    break;

                case PROFILE:

                    //Enviar mensagem para o agente especialista saveMember
                    message = new ACLMessage(ACLMessage.INFORM);
                    message.addReceiver(new AID(RoleNameConstants.SPECIALIST_PROFILE.getValue() + "_V", false));
                    message.setContent(new Gson().toJson(eventMessage));
                    this.baseAgent.send(message);

                    break;

                case SAVE_MEMBER:

                    //Enviar mensagem para o agente especialista saveMember
                    message = new ACLMessage(ACLMessage.INFORM);
                    message.addReceiver(new AID(RoleNameConstants.SPECIALIST_SAVE_MEMBER.getValue() + "_V", false));
                    message.setContent(new Gson().toJson(eventMessage));
                    this.baseAgent.send(message);

                    break;

                case REDEMPTION:

                    //Enviar mensagem para o agente especialista saveMember
                    message = new ACLMessage(ACLMessage.INFORM);
                    message.addReceiver(new AID(RoleNameConstants.SPECIALIST_REDEMPTION.getValue() + "_V", false));
                    message.setContent(new Gson().toJson(eventMessage));
                    this.baseAgent.send(message);

                    break;
            }
        }

    }

    @Override
    public void itemRemoved(ItemEvent<Object> item) {
        // TODO Auto-generated method stub

    }

}
