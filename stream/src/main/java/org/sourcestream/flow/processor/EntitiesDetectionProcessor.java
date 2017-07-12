package org.sourcestream.flow.processor;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;
import org.sourcestream.flow.model.EntityReport;
import org.sourcestream.flow.streams.EntityReportKafkaStream;
import org.sourcestream.entities.detectionEvent;

import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

public class EntitiesDetectionProcessor implements Processor<String,EntityReport> {
	private ProcessorContext context;
    private KeyValueStore<String, EntityReport> state;
    private String sourceName;
    private ProcessorPerformamceMonitor monitor; 
    private static AtomicLong lastOffsetData;
    
    static {
    	lastOffsetData = getLastOffestForTopic();
    }
	
    public EntitiesDetectionProcessor(String sourceName)
    {
    	this.sourceName = sourceName;
    	this.monitor = new ProcessorPerformamceMonitor();
    }
    
    @Override
    public void process(String key, EntityReport value) {

    	String valueState = null;
    	if (state.get(value.id) == null)
    	{  		
    		detectionEvent event = new detectionEvent();
    		event.setSourceName(sourceName);
    		event.setExternalSystemID(value.id);
	        event.setDataOffset(lastOffsetData.getAndAdd(1));
    		
    		context.forward(key, event);
	        context.commit();
	        state.put(value.id, value);
	        valueState = "New";
    	}
    	else {
    		valueState = "Updated";
    	}
    	
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
	
	private static AtomicLong getLastOffestForTopic() {

		TopicPartition partition = new TopicPartition(System.getenv("SOURCE_NAME"), 0);

		Properties props = getKafkaConsumerProperties();   
		long lastOffset;

		try(KafkaConsumer<Object, Object> consumer = new KafkaConsumer<Object, Object>(props)) {
			consumer.assign(Arrays.asList(partition));
			consumer.seekToEnd(Arrays.asList(partition));
			lastOffset  = consumer.position(partition); 
		}

		return new AtomicLong(lastOffset);
	}

	private static Properties getKafkaConsumerProperties() {
		
		String kafkaIP = System.getenv("KAFKA_ADDRESS");
		String schemaRegistryIP = System.getenv("SCHEMA_REGISTRY_IP");

		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaIP);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				StringSerializer.class);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				StringDeserializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
					io.confluent.kafka.serializers.KafkaAvroSerializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				io.confluent.kafka.serializers.KafkaAvroDeserializer.class);
 	
		props.put("schema.registry.url", schemaRegistryIP);
		props.put("group.id", "group1");

		return props;
	}
}
