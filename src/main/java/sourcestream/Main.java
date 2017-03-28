package sourcestream;

import org.sourcestream.bbejeck.streams.entities.EntityReportKafkaStream;

public class Main {

	public static void main(String[] args) {
		String sourceName = System.getenv().getOrDefault("SOURCE_NAME", "defualt");
		EntityReportKafkaStream stream = new EntityReportKafkaStream(sourceName, System.getenv());
		System.out.println("Started running with source name: " + sourceName);
		stream.run();
	}
}
