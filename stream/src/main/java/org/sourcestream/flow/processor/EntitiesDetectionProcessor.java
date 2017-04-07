package org.sourcestream.flow.processor;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;
import org.sourcestream.flow.model.EntityReport;
import org.sourcestream.entities.detectionEvent;

import java.time.Instant;
import java.util.Objects;

public class EntitiesDetectionProcessor implements Processor<String,EntityReport> {
	private ProcessorContext context;
    private KeyValueStore<String, EntityReport> state;
    private String sourceName;
    private ProcessorPerformamceMonitor monitor;
	
    public EntitiesDetectionProcessor(String sourceName)
    {
    	this.sourceName = sourceName;
    	this.monitor = new ProcessorPerformamceMonitor();
    }
    
    @Override
    public void process(String key, EntityReport value) {
    	Boolean isNew = false;
    	if (state.get(value.id) == null)
    	{
    		isNew = true;
    		
    		detectionEvent event = new detectionEvent();
    		event.setSourceName(sourceName);
    		event.setExternalSystemID(value.id);
	        
    		context.forward(key, event);
	        context.commit();
	        state.put(value.id, value);
    	}
    	
    	String valueState = "";
    	if (isNew)
    		valueState = "New";
    	else
    		valueState = "Updated";
    	
    	System.out.println("Creation:" + valueState + " target external ID:" + value.id + " " + monitor.getProcessorPerformanceStatus(context.timestamp()));
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
