package cli;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase; 

public class ServerOptions extends OptionsBase {

	  @Option(
	      name = "help",
	      abbrev = 'h',
	      help = "Prints usage info.",
	      defaultValue = "true"
	    )
	  public boolean help;

	  @Option(
	      name = "source_name",
	      abbrev = 's',
	      help = "The source name.",
	      category = "startup",
	      defaultValue = ""
	  )
	  public String source_name;

	  @Option(
	    name = "kafka_ip",
	    abbrev = 'k',
	    help = "The kafka broker ip.",
	    category = "startup",
	    defaultValue = "localhost:9092"
	    )
	    public int kafka_ip;

}