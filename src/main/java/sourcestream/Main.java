package sourcestream;

import org.sourcestream.bbejeck.streams.entities.EntityReportKafkaStream;

public class Main {

	public static void main(String[] args) {
		EntityReportKafkaStream stream = new EntityReportKafkaStream(System.getenv());
		stream.run();
	}
}
