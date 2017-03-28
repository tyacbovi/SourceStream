package org.sourcestream.bbejeck.streams.entities;

import org.sourcestream.bbejeck.model.EntityReport;
import org.sourcestream.bbejeck.processor.entities.EntitiesDetectionProcessor;
import org.sourcestream.bbejeck.serializer.JsonDeserializer;
import org.sourcestream.bbejeck.serializer.JsonSerializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.processor.TopologyBuilder;
import org.apache.kafka.streams.processor.WallclockTimestampExtractor;
import org.apache.kafka.streams.processor.StateStoreSupplier;
import org.apache.kafka.streams.state.Stores;

import java.util.Properties;

public class EntityReportKafkaStream {
	public void run (Properties kafka_settings)
	{
		String sourceName = kafka_settings.getProperty("source");
		StreamsConfig streamsConfig = new StreamsConfig(getProperties());
		
		JsonDeserializer<EntityReport> entityReportJsonDeserializer = new JsonDeserializer<>(EntityReport.class);
        JsonSerializer<EntityReport> entityReportJsonSerializer = new JsonSerializer<>();
        
        Serde<EntityReport> entityReportSerde = Serdes.serdeFrom(entityReportJsonSerializer,entityReportJsonDeserializer);
        Serde<String> stringSerde = Serdes.String();
        

        // Create the state stores. We need one for each of the
        // MessageProcessor's in the topology.
        StateStoreSupplier sourceEntitiesStore = 
            Stores.create(sourceName + "-store")
                  .withStringKeys()
                  .withDoubleValues()
                  .inMemory()
                  .build();
        
        TopologyBuilder builder = new TopologyBuilder();
        
        builder.addSource("messages-source",
                Serdes.String().deserializer(),
                entityReportJsonDeserializer,
                "messages")
	     .addProcessor("detection-processor",
	                   () -> new EntitiesDetectionProcessor(sourceName),
	                   "messages-source")
	     .addProcessor("data-processor",
				       () -> new EntitiesDetectionProcessor(sourceName),
				       "messages-source")
	     .addStateStore(sourceEntitiesStore, "detection-processor")
	     .addSink("creation-sink", 
	              "creation", 
	              Serdes.String().serializer(),
	              entityReportJsonSerializer,
	              "detection-processor");
        
        System.out.println("Starting " + sourceName + " flow");
        KafkaStreams kafkaStreams = new KafkaStreams(builder,streamsConfig);
        kafkaStreams.start();
        System.out.println("Now started PurchaseStreams Example");
	}
	
	private static Properties getProperties() {
        Properties props = new Properties();
        props.put(StreamsConfig.CLIENT_ID_CONFIG, "Source-Stream");
        props.put("group.id", "source-stream");
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "<source-name>-stream"); //TODO: get source name from CLI
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); //TODO: get source name from CLI
        props.put(StreamsConfig.REPLICATION_FACTOR_CONFIG, 1);
        props.put(StreamsConfig.TIMESTAMP_EXTRACTOR_CLASS_CONFIG, WallclockTimestampExtractor.class);
        return props;
    }
}
