package bbejeck.model;

import java.util.Date;
import java.util.Objects;

public class EntityReport {
	private String id;
	private Double lat;
	private Double xlong;
	private String source_name;
	private String category;
	private Double speed;
	private Double course;
	private Double elevation;
	private String nationality;
	private String picture_url;
	private Double height;
	private String nickname;
	
	private EntityReport(Builder builder) {
        id = builder.id;
        lat = builder.lat;
        xlong = builder.xlong;
        source_name = builder.source_name;
        category = builder.category;
        speed = builder.speed;
        course = builder.course;
        elevation = builder.elevation;
        nationality = builder.nationality;
        picture_url = builder.picture_url;
        height = builder.height;
        nickname = builder.nickname;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(EntityReport copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.lat = copy.lat;
        builder.xlong = copy.xlong;
        builder.source_name = copy.source_name;
        builder.category = copy.category;
        builder.speed = copy.speed;
        builder.course = copy.course;
        builder.elevation = copy.elevation;
        builder.nationality = copy.nationality;
        builder.picture_url = copy.picture_url;
        builder.height = copy.height;
        builder.nickname = copy.nickname;
        return builder;
    }
	
	public static final class Builder {
		private String id;
		private Double lat;
		private Double xlong;
		private String source_name;
		private String category;
		private Double speed;
		private Double course;
		private Double elevation;
		private String nationality;
		private String picture_url;
		private Double height;
		private String nickname;

        private Builder() {
        }

        public Builder id(String val) {
        	id = val;
            return this;
        }
        
        public Builder source_name(String val) {
        	source_name = val;
            return this;
        }
        
        public Builder category(String val) {
        	category = val;
            return this;
        }
        
        public Builder nationality(String val) {
        	nationality = val;
            return this;
        }
        
        public Builder picture_url(String val) {
        	picture_url = val;
            return this;
        }
        
        public Builder nickname(String val) {
        	nickname = val;
            return this;
        }

        public Builder lat(Double val) {
        	lat = val;
            return this;
        }
        
        public Builder xlong(Double val) {
        	xlong = val;
            return this;
        }
        
        public Builder speed(Double val) {
        	speed = val;
            return this;
        }
        
        public Builder course(Double val) {
        	course = val;
            return this;
        }
        
        public Builder elevation(Double val) {
        	elevation = val;
            return this;
        }
        
        public Builder height(Double val) {
        	height = val;
            return this;
        }

        public EntityReport build() {
            return new EntityReport(this);
        }
	}
}
