package org.sourcestream.flow.processor;

import java.time.Instant;

public class ProcessorPerformamceMonitor {
	public String getProcessorPerformanceStatus(double startTime)
	{
		Double deltaReport = (Instant.now().toEpochMilli() - startTime) / 1000.0;
		
		return "Delta is " + Double.toString(deltaReport);
	}
}
