package org.sourcestream.bbejeck.processor.entities;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;
import org.sourcestream.bbejeck.model.EntityReport;
import org.sourcestream.entities.detectionEvent;

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
    	
    	if (state.get(key) == null)
    	{
    		detectionEvent event = new detectionEvent();
    		event.setSourceName(sourceName);
    		event.setExternalSystemID(value.getId());
	        context.forward(key, value);
	        context.commit();
    	}
    }
	
    /** Initializes the state store with the name `type` + "_store", where
     * `type` is the type specified in the constructor.
     *
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        
        this.context = context;

        state = (KeyValueStore<String, EntityReport>) context.getStateStore(sourceName + "-store");
    
    } // Close init.
    
	@Override
	public void punctuate(long timestamp) {	
	}
	
	@Override
	public void close() {
	}
}
