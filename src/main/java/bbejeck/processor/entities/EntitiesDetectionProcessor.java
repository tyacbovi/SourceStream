package bbejeck.processor.entities;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

import bbejeck.schema.*;

public class EntitiesDetectionProcessor implements Processor<String,detectionEvent> {
	private ProcessorContext context;
    private KeyValueStore<String, detectionEvent> state;
    private String sourceName;
	
    public EntitiesDetectionProcessor(String sourceName)
    {
    	this.sourceName = sourceName;
    }
    @Override
    public void process(String key, detectionEvent value) {
    	
    	if (state.get(key) == null)
	        context.forward(key, value);
	        context.commit();
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

        state = (KeyValueStore<String, detectionEvent>) context.getStateStore(sourceName + "-store");
    
    } // Close init.
    
	@Override
	public void punctuate(long timestamp) {	
	}
	
	@Override
	public void close() {
	}
}
