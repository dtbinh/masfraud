package masfraud.coordinator.sensors;

import masfraud.base.BaseAgent;
import masfraud.base.ContextMasfraud;
import masfraud.base.constants.ContextKey;
import masfraud.base.constants.EnvironmentConstants;
import masfraud.base.constants.MessageType;
import masfraud.base.message.StructuralEvent;
import masfraud.coordinator.command.StructuralCommand;

import org.apache.commons.chain.Context;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MapEvent;

public class StructuralMapSensor implements EntryListener<Object, Object>{

	private BaseAgent baseAgent;
	private HazelcastInstance hazelcastClient;
	
	public StructuralMapSensor(final BaseAgent baseAgent, final HazelcastInstance hazelcastClient) {
		this.baseAgent = baseAgent;
		this.hazelcastClient = hazelcastClient;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void entryAdded(EntryEvent<Object, Object> event) {
		System.out.println("Agente: " + this.baseAgent.getLocalName() + " vai pegar a mensagem...");
		
		StructuralEvent structuralMessage = (StructuralEvent) hazelcastClient
				.getMap(EnvironmentConstants.STRUCTURAL_MAP.getValue()).remove(
						MessageType.STRUCTURAL.getValue());
		
		System.out.println("Agente: " + this.baseAgent.getLocalName() + " pegou a mensagem... " + structuralMessage);
		
		Context context = new ContextMasfraud();
		context.put(ContextKey.MESSAGE.getValue(), structuralMessage);
		context.put(ContextKey.AGENT_INSTANCE.getValue(), this.baseAgent);
		try {
			new StructuralCommand().execute(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void entryRemoved(EntryEvent<Object, Object> event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entryUpdated(EntryEvent<Object, Object> event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entryEvicted(EntryEvent<Object, Object> event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mapEvicted(MapEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mapCleared(MapEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	


}
