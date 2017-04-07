package org.sourcestream.flow.processor;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.sourcestream.flow.model.EntityReport;
import org.sourcestream.entities.generalEntityAttributes;
import org.sourcestream.entities.category;
import org.sourcestream.entities.nationality;
import org.sourcestream.entities.basicEntityAttributes;
import org.sourcestream.entities.coordinate;


public class JsonDetectionReportToSystemRport implements Processor<String,EntityReport>{
	private ProcessorContext context;
	private ProcessorPerformamceMonitor monitor;
	
	@Override
	public void init(ProcessorContext context) {
		this.context = context;
		this.monitor = new ProcessorPerformamceMonitor();
	}

	@Override
	public void process(String key, EntityReport value) {
		coordinate location = coordinate.newBuilder().setLat(value.lat)
		.setLong$(value.xlong)
		.build();
		
		basicEntityAttributes basicEntity = basicEntityAttributes.newBuilder().setCoordinate(location)
		.setEntityOffset(0)
		.setIsNotTracked(false)
		.setSourceName(value.source_name)
		.build();
		
		generalEntityAttributes entity = generalEntityAttributes.newBuilder().setCategory(category.valueOf(value.category))
		.setCourse(value.course)
		.setElevation(value.course)
		.setExternalSystemID(value.id)
		.setHeight(value.height)
		.setNationality(nationality.valueOf(value.nationality.toUpperCase()))
		.setNickname(value.nickname)
		.setPictureURL(value.picture_url)
		.setSpeed(value.speed)
		.setBasicAttributes(basicEntity)
		.build();
		
		context.forward(key, entity);
        context.commit();
        
        System.out.println("Data: Target external ID:" + value.id + " " + monitor.getProcessorPerformanceStatus(context.timestamp()));
	}

	@Override
	public void punctuate(long timestamp) {
	}

	@Override
	public void close() {
	}

}
