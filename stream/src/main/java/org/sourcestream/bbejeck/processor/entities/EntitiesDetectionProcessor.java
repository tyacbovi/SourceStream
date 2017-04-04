package org.sourcestream.bbejeck.processor.entities;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;
import org.sourcestream.bbejeck.model.EntityReport;
import org.sourcestream.entities.detectionEvent;

import java.util.Objects;

public class EntitiesDetectionProcessor implements Processor<String,EntityReport> {
	private ProcessorContext context;
    private KeyValueStore<String, EntityReport> state;
    private String sourceName;
	
    public EntitiesDetectionProcessor(String sourceName)
    {
    	this.sourceName = sourceName;
    }
    
    @Override
    public void process(String key, EntityReport value) {
    	if (state.get(value.id) == null)
    	{
    		System.out.println("new target " + value.id);
    		
    		detectionEvent event = new detectionEvent();
    		event.setSourceName(sourceName);
    		event.setExternalSystemID(value.getId());
	        
    		context.forward(key, event);
	        context.commit();
	        state.put(value.id, value);
    	}
    	else
    	{
    		System.out.println("updated target " + value.id);
    	}
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        
        this.context = context;

        state = (KeyValueStore<String, EntityReport>) context.getStateStore(sourceName + "-store");
        Objects.requireNonNull(state, "State store can't be null");
    } // Close init.
    
	@Override
	public void punctuate(long timestamp) {
	}
	
	@Override
	public void close() {
		state.close();
	}
}
