package org.sourcestream.flow.streams;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.processor.StateStoreSupplier;
import org.apache.kafka.streams.processor.TopologyBuilder;
import org.apache.kafka.streams.processor.WallclockTimestampExtractor;
import org.apache.kafka.streams.state.Stores;
import org.sourcestream.flow.model.EntityReport;
import org.sourcestream.flow.processor.EntitiesDetectionProcessor;
import org.sourcestream.flow.processor.JsonDetectionReportToSystemRport;
import org.sourcestream.flow.serializer.JsonDeserializer;
import org.sourcestream.flow.serializer.JsonSerializer;

import org.sourcestream.entities.detectionEvent;
import org.sourcestream.entities.category;
import org.sourcestream.entities.coordinate;
import org.sourcestream.entities.basicEntityAttributes;
import org.sourcestream.entities.generalEntityAttributes;
import org.sourcestream.entities.nationality;

import io.confluent.kafka.schemaregistry.client.rest.exceptions.RestClientException;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.schemaregistry.client.MockSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;


public class EntityReportKafkaStream {
	private String sourceName;
	private Properties kafkaProperties;
	private String schemaRegistryIP;
	private String NOTVALID = "NOTVALID";
	private String kafkaIP;
	
	public EntityReportKafkaStream(Map<String, String> externalProperties)
	{
		this.sourceName = System.getenv().getOrDefault("SOURCE_NAME", "defualt");
		this.kafkaIP = externalProperties.getOrDefault("KAFKA_ADDRESS", "localhost:9092");
		this.kafkaProperties = getProperties(this.kafkaIP, this.sourceName);
		this.schemaRegistryIP = externalProperties.getOrDefault("SCHEMA_REGISTRY_IP", NOTVALID);
		
		System.out.println("Stream started with :\nsource-name:" + this.sourceName + "\nSchema registry url:" + this.schemaRegistryIP +"\n" +
							"Kafka ip:" + this.kafkaIP + "\n");
	}
	
	public void run ()
	{
		StreamsConfig streamsConfig = new StreamsConfig(this.kafkaProperties);
		
		JsonDeserializer<EntityReport> entityReportJsonDeserializer = new JsonDeserializer<>(EntityReport.class);
        JsonSerializer<EntityReport> entityReportJsonSerializer = new JsonSerializer<>();
        
        Serde<EntityReport> entityReportSerde = Serdes.serdeFrom(entityReportJsonSerializer,entityReportJsonDeserializer);

        // Create the state stores. We need one for each of the
        // MessageProcessor's in the topology.
        StateStoreSupplier sourceEntitiesStore = 
            Stores.create(sourceName + "-store")
                  .withStringKeys()
                  .withValues(entityReportSerde)
                  .inMemory()
                  .build();
        
        
        SchemaRegistryClient schema;
        if (schemaRegistryIP == NOTVALID)
        	schema = new MockSchemaRegistryClient();
        else
        	schema = new CachedSchemaRegistryClient(this.schemaRegistryIP, 2410);
        
        KafkaAvroSerializer kafkaAvroSerializer = new KafkaAvroSerializer(schema);
        try {
			kafkaAvroSerializer.register(detectionEvent.getClassSchema().getFullName(), detectionEvent.getClassSchema());
			kafkaAvroSerializer.register(category.getClassSchema().getFullName(), category.getClassSchema());
			kafkaAvroSerializer.register(basicEntityAttributes.getClassSchema().getFullName(), basicEntityAttributes.getClassSchema());
			kafkaAvroSerializer.register(generalEntityAttributes.getClassSchema().getFullName(), generalEntityAttributes.getClassSchema());
			kafkaAvroSerializer.register(nationality.getClassSchema().getFullName(), nationality.getClassSchema());
			kafkaAvroSerializer.register(coordinate.getClassSchema().getFullName(), coordinate.getClassSchema());
		} catch (IOException | RestClientException e) {
			e.printStackTrace();
		}
        
        TopologyBuilder builder = new TopologyBuilder();
        
        builder.addSource("messages-source",
                Serdes.String().deserializer(),
                entityReportJsonDeserializer,
                sourceName + "-raw-data")
	     .addProcessor("detection-processor",
	                   () -> new EntitiesDetectionProcessor(sourceName),
	                   "messages-source")
	     .addProcessor("data-processor",
				       () -> new JsonDetectionReportToSystemRport(),
				       "messages-source")
	     .addStateStore(sourceEntitiesStore, "detection-processor")
	     .addSink("creation-sink", 
	              "creation", 
	              Serdes.String().serializer(),
	              kafkaAvroSerializer,
	              "detection-processor")
	     .addSink("data-sink", 
	              sourceName, 
	              Serdes.String().serializer(),
	              kafkaAvroSerializer,
	              "data-processor");
        
        KafkaStreams kafkaStreams = new KafkaStreams(builder,streamsConfig);
        
        //Will close the stream at system shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(){
        	@Override
        	public void run() {
        		kafkaStreams.close();
        	}
        });
        
        kafkaStreams.start();
	}
	
	private static Properties getProperties(String kafkaIP, String sourceName) {
        Properties props = new Properties();
        props.put(StreamsConfig.CLIENT_ID_CONFIG, sourceName + "-stream");
        props.put("group.id", "source-stream");
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, sourceName + "-stream");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaIP);
        props.put(StreamsConfig.REPLICATION_FACTOR_CONFIG, 1);
        props.put(StreamsConfig.TIMESTAMP_EXTRACTOR_CLASS_CONFIG, WallclockTimestampExtractor.class);
        return props;
    }
}
