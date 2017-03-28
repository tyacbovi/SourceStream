package cli;

import com.google.devtools.common.options.OptionsParser;
import java.util.Collections;

public class CommandLineParser {

	  public static void parse(String[] args) {
	    OptionsParser parser = OptionsParser.newOptionsParser(ServerOptions.class);
	    parser.parseAndExitUponError(args);
	    ServerOptions options = parser.getOptions(ServerOptions.class);
	    if (options.source_name.isEmpty()) {
	      printUsage(parser);
	      return;
	    }
	  }

	  private static void printUsage(OptionsParser parser) {
	    System.out.println("Usage: java -jar server.jar OPTIONS");
	    System.out.println(parser.describeOptions(Collections.<String, String>emptyMap(),
	                                              OptionsParser.HelpVerbosity.LONG));
	  }
}
