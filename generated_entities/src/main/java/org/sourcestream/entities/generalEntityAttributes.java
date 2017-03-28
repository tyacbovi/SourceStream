/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.sourcestream.entities;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** This is a schema for general entity before acquiring by the system */
@org.apache.avro.specific.AvroGenerated
public class generalEntityAttributes extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4371711668933767984L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"generalEntityAttributes\",\"namespace\":\"org.sourcestream.entities\",\"doc\":\"This is a schema for general entity before acquiring by the system\",\"fields\":[{\"name\":\"basicAttributes\",\"type\":{\"type\":\"record\",\"name\":\"basicEntityAttributes\",\"doc\":\"This is a schema for basic entity attributes, this will represent basic entity in all life cycle\",\"fields\":[{\"name\":\"coordinate\",\"type\":{\"type\":\"record\",\"name\":\"coordinate\",\"doc\":\"Location attribute in grid format\",\"fields\":[{\"name\":\"lat\",\"type\":\"double\"},{\"name\":\"long\",\"type\":\"double\"}]}},{\"name\":\"isNotTracked\",\"type\":\"boolean\"},{\"name\":\"entityOffset\",\"type\":\"long\"}]}},{\"name\":\"speed\",\"type\":\"double\",\"doc\":\"This is the magnitude of the entity's velcity vector.\"},{\"name\":\"elevation\",\"type\":\"double\"},{\"name\":\"course\",\"type\":\"double\"},{\"name\":\"nationality\",\"type\":{\"type\":\"enum\",\"name\":\"nationality\",\"symbols\":[\"ISRAEL\",\"USA\",\"SPAIN\"]}},{\"name\":\"category\",\"type\":{\"type\":\"enum\",\"name\":\"category\",\"symbols\":[\"airplane\",\"boat\"]}},{\"name\":\"pictureURL\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"height\",\"type\":\"double\"},{\"name\":\"nickname\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"externalSystemID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"This is ID given be external system.\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public org.sourcestream.entities.basicEntityAttributes basicAttributes;
  /** This is the magnitude of the entity's velcity vector. */
  @Deprecated public double speed;
  @Deprecated public double elevation;
  @Deprecated public double course;
  @Deprecated public org.sourcestream.entities.nationality nationality;
  @Deprecated public org.sourcestream.entities.category category;
  @Deprecated public java.lang.String pictureURL;
  @Deprecated public double height;
  @Deprecated public java.lang.String nickname;
  /** This is ID given be external system. */
  @Deprecated public java.lang.String externalSystemID;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public generalEntityAttributes() {}

  /**
   * All-args constructor.
   * @param basicAttributes The new value for basicAttributes
   * @param speed This is the magnitude of the entity's velcity vector.
   * @param elevation The new value for elevation
   * @param course The new value for course
   * @param nationality The new value for nationality
   * @param category The new value for category
   * @param pictureURL The new value for pictureURL
   * @param height The new value for height
   * @param nickname The new value for nickname
   * @param externalSystemID This is ID given be external system.
   */
  public generalEntityAttributes(org.sourcestream.entities.basicEntityAttributes basicAttributes, java.lang.Double speed, java.lang.Double elevation, java.lang.Double course, org.sourcestream.entities.nationality nationality, org.sourcestream.entities.category category, java.lang.String pictureURL, java.lang.Double height, java.lang.String nickname, java.lang.String externalSystemID) {
    this.basicAttributes = basicAttributes;
    this.speed = speed;
    this.elevation = elevation;
    this.course = course;
    this.nationality = nationality;
    this.category = category;
    this.pictureURL = pictureURL;
    this.height = height;
    this.nickname = nickname;
    this.externalSystemID = externalSystemID;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return basicAttributes;
    case 1: return speed;
    case 2: return elevation;
    case 3: return course;
    case 4: return nationality;
    case 5: return category;
    case 6: return pictureURL;
    case 7: return height;
    case 8: return nickname;
    case 9: return externalSystemID;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: basicAttributes = (org.sourcestream.entities.basicEntityAttributes)value$; break;
    case 1: speed = (java.lang.Double)value$; break;
    case 2: elevation = (java.lang.Double)value$; break;
    case 3: course = (java.lang.Double)value$; break;
    case 4: nationality = (org.sourcestream.entities.nationality)value$; break;
    case 5: category = (org.sourcestream.entities.category)value$; break;
    case 6: pictureURL = (java.lang.String)value$; break;
    case 7: height = (java.lang.Double)value$; break;
    case 8: nickname = (java.lang.String)value$; break;
    case 9: externalSystemID = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'basicAttributes' field.
   * @return The value of the 'basicAttributes' field.
   */
  public org.sourcestream.entities.basicEntityAttributes getBasicAttributes() {
    return basicAttributes;
  }

  /**
   * Sets the value of the 'basicAttributes' field.
   * @param value the value to set.
   */
  public void setBasicAttributes(org.sourcestream.entities.basicEntityAttributes value) {
    this.basicAttributes = value;
  }

  /**
   * Gets the value of the 'speed' field.
   * @return This is the magnitude of the entity's velcity vector.
   */
  public java.lang.Double getSpeed() {
    return speed;
  }

  /**
   * Sets the value of the 'speed' field.
   * This is the magnitude of the entity's velcity vector.
   * @param value the value to set.
   */
  public void setSpeed(java.lang.Double value) {
    this.speed = value;
  }

  /**
   * Gets the value of the 'elevation' field.
   * @return The value of the 'elevation' field.
   */
  public java.lang.Double getElevation() {
    return elevation;
  }

  /**
   * Sets the value of the 'elevation' field.
   * @param value the value to set.
   */
  public void setElevation(java.lang.Double value) {
    this.elevation = value;
  }

  /**
   * Gets the value of the 'course' field.
   * @return The value of the 'course' field.
   */
  public java.lang.Double getCourse() {
    return course;
  }

  /**
   * Sets the value of the 'course' field.
   * @param value the value to set.
   */
  public void setCourse(java.lang.Double value) {
    this.course = value;
  }

  /**
   * Gets the value of the 'nationality' field.
   * @return The value of the 'nationality' field.
   */
  public org.sourcestream.entities.nationality getNationality() {
    return nationality;
  }

  /**
   * Sets the value of the 'nationality' field.
   * @param value the value to set.
   */
  public void setNationality(org.sourcestream.entities.nationality value) {
    this.nationality = value;
  }

  /**
   * Gets the value of the 'category' field.
   * @return The value of the 'category' field.
   */
  public org.sourcestream.entities.category getCategory() {
    return category;
  }

  /**
   * Sets the value of the 'category' field.
   * @param value the value to set.
   */
  public void setCategory(org.sourcestream.entities.category value) {
    this.category = value;
  }

  /**
   * Gets the value of the 'pictureURL' field.
   * @return The value of the 'pictureURL' field.
   */
  public java.lang.String getPictureURL() {
    return pictureURL;
  }

  /**
   * Sets the value of the 'pictureURL' field.
   * @param value the value to set.
   */
  public void setPictureURL(java.lang.String value) {
    this.pictureURL = value;
  }

  /**
   * Gets the value of the 'height' field.
   * @return The value of the 'height' field.
   */
  public java.lang.Double getHeight() {
    return height;
  }

  /**
   * Sets the value of the 'height' field.
   * @param value the value to set.
   */
  public void setHeight(java.lang.Double value) {
    this.height = value;
  }

  /**
   * Gets the value of the 'nickname' field.
   * @return The value of the 'nickname' field.
   */
  public java.lang.String getNickname() {
    return nickname;
  }

  /**
   * Sets the value of the 'nickname' field.
   * @param value the value to set.
   */
  public void setNickname(java.lang.String value) {
    this.nickname = value;
  }

  /**
   * Gets the value of the 'externalSystemID' field.
   * @return This is ID given be external system.
   */
  public java.lang.String getExternalSystemID() {
    return externalSystemID;
  }

  /**
   * Sets the value of the 'externalSystemID' field.
   * This is ID given be external system.
   * @param value the value to set.
   */
  public void setExternalSystemID(java.lang.String value) {
    this.externalSystemID = value;
  }

  /**
   * Creates a new generalEntityAttributes RecordBuilder.
   * @return A new generalEntityAttributes RecordBuilder
   */
  public static org.sourcestream.entities.generalEntityAttributes.Builder newBuilder() {
    return new org.sourcestream.entities.generalEntityAttributes.Builder();
  }

  /**
   * Creates a new generalEntityAttributes RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new generalEntityAttributes RecordBuilder
   */
  public static org.sourcestream.entities.generalEntityAttributes.Builder newBuilder(org.sourcestream.entities.generalEntityAttributes.Builder other) {
    return new org.sourcestream.entities.generalEntityAttributes.Builder(other);
  }

  /**
   * Creates a new generalEntityAttributes RecordBuilder by copying an existing generalEntityAttributes instance.
   * @param other The existing instance to copy.
   * @return A new generalEntityAttributes RecordBuilder
   */
  public static org.sourcestream.entities.generalEntityAttributes.Builder newBuilder(org.sourcestream.entities.generalEntityAttributes other) {
    return new org.sourcestream.entities.generalEntityAttributes.Builder(other);
  }

  /**
   * RecordBuilder for generalEntityAttributes instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<generalEntityAttributes>
    implements org.apache.avro.data.RecordBuilder<generalEntityAttributes> {

    private org.sourcestream.entities.basicEntityAttributes basicAttributes;
    private org.sourcestream.entities.basicEntityAttributes.Builder basicAttributesBuilder;
    /** This is the magnitude of the entity's velcity vector. */
    private double speed;
    private double elevation;
    private double course;
    private org.sourcestream.entities.nationality nationality;
    private org.sourcestream.entities.category category;
    private java.lang.String pictureURL;
    private double height;
    private java.lang.String nickname;
    /** This is ID given be external system. */
    private java.lang.String externalSystemID;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.sourcestream.entities.generalEntityAttributes.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.basicAttributes)) {
        this.basicAttributes = data().deepCopy(fields()[0].schema(), other.basicAttributes);
        fieldSetFlags()[0] = true;
      }
      if (other.hasBasicAttributesBuilder()) {
        this.basicAttributesBuilder = org.sourcestream.entities.basicEntityAttributes.newBuilder(other.getBasicAttributesBuilder());
      }
      if (isValidValue(fields()[1], other.speed)) {
        this.speed = data().deepCopy(fields()[1].schema(), other.speed);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.elevation)) {
        this.elevation = data().deepCopy(fields()[2].schema(), other.elevation);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.course)) {
        this.course = data().deepCopy(fields()[3].schema(), other.course);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.nationality)) {
        this.nationality = data().deepCopy(fields()[4].schema(), other.nationality);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.category)) {
        this.category = data().deepCopy(fields()[5].schema(), other.category);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.pictureURL)) {
        this.pictureURL = data().deepCopy(fields()[6].schema(), other.pictureURL);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.height)) {
        this.height = data().deepCopy(fields()[7].schema(), other.height);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.nickname)) {
        this.nickname = data().deepCopy(fields()[8].schema(), other.nickname);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.externalSystemID)) {
        this.externalSystemID = data().deepCopy(fields()[9].schema(), other.externalSystemID);
        fieldSetFlags()[9] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing generalEntityAttributes instance
     * @param other The existing instance to copy.
     */
    private Builder(org.sourcestream.entities.generalEntityAttributes other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.basicAttributes)) {
        this.basicAttributes = data().deepCopy(fields()[0].schema(), other.basicAttributes);
        fieldSetFlags()[0] = true;
      }
      this.basicAttributesBuilder = null;
      if (isValidValue(fields()[1], other.speed)) {
        this.speed = data().deepCopy(fields()[1].schema(), other.speed);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.elevation)) {
        this.elevation = data().deepCopy(fields()[2].schema(), other.elevation);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.course)) {
        this.course = data().deepCopy(fields()[3].schema(), other.course);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.nationality)) {
        this.nationality = data().deepCopy(fields()[4].schema(), other.nationality);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.category)) {
        this.category = data().deepCopy(fields()[5].schema(), other.category);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.pictureURL)) {
        this.pictureURL = data().deepCopy(fields()[6].schema(), other.pictureURL);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.height)) {
        this.height = data().deepCopy(fields()[7].schema(), other.height);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.nickname)) {
        this.nickname = data().deepCopy(fields()[8].schema(), other.nickname);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.externalSystemID)) {
        this.externalSystemID = data().deepCopy(fields()[9].schema(), other.externalSystemID);
        fieldSetFlags()[9] = true;
      }
    }

    /**
      * Gets the value of the 'basicAttributes' field.
      * @return The value.
      */
    public org.sourcestream.entities.basicEntityAttributes getBasicAttributes() {
      return basicAttributes;
    }

    /**
      * Sets the value of the 'basicAttributes' field.
      * @param value The value of 'basicAttributes'.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder setBasicAttributes(org.sourcestream.entities.basicEntityAttributes value) {
      validate(fields()[0], value);
      this.basicAttributesBuilder = null;
      this.basicAttributes = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'basicAttributes' field has been set.
      * @return True if the 'basicAttributes' field has been set, false otherwise.
      */
    public boolean hasBasicAttributes() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'basicAttributes' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public org.sourcestream.entities.basicEntityAttributes.Builder getBasicAttributesBuilder() {
      if (basicAttributesBuilder == null) {
        if (hasBasicAttributes()) {
          setBasicAttributesBuilder(org.sourcestream.entities.basicEntityAttributes.newBuilder(basicAttributes));
        } else {
          setBasicAttributesBuilder(org.sourcestream.entities.basicEntityAttributes.newBuilder());
        }
      }
      return basicAttributesBuilder;
    }

    /**
     * Sets the Builder instance for the 'basicAttributes' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public org.sourcestream.entities.generalEntityAttributes.Builder setBasicAttributesBuilder(org.sourcestream.entities.basicEntityAttributes.Builder value) {
      clearBasicAttributes();
      basicAttributesBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'basicAttributes' field has an active Builder instance
     * @return True if the 'basicAttributes' field has an active Builder instance
     */
    public boolean hasBasicAttributesBuilder() {
      return basicAttributesBuilder != null;
    }

    /**
      * Clears the value of the 'basicAttributes' field.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder clearBasicAttributes() {
      basicAttributes = null;
      basicAttributesBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'speed' field.
      * This is the magnitude of the entity's velcity vector.
      * @return The value.
      */
    public java.lang.Double getSpeed() {
      return speed;
    }

    /**
      * Sets the value of the 'speed' field.
      * This is the magnitude of the entity's velcity vector.
      * @param value The value of 'speed'.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder setSpeed(double value) {
      validate(fields()[1], value);
      this.speed = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'speed' field has been set.
      * This is the magnitude of the entity's velcity vector.
      * @return True if the 'speed' field has been set, false otherwise.
      */
    public boolean hasSpeed() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'speed' field.
      * This is the magnitude of the entity's velcity vector.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder clearSpeed() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'elevation' field.
      * @return The value.
      */
    public java.lang.Double getElevation() {
      return elevation;
    }

    /**
      * Sets the value of the 'elevation' field.
      * @param value The value of 'elevation'.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder setElevation(double value) {
      validate(fields()[2], value);
      this.elevation = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'elevation' field has been set.
      * @return True if the 'elevation' field has been set, false otherwise.
      */
    public boolean hasElevation() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'elevation' field.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder clearElevation() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'course' field.
      * @return The value.
      */
    public java.lang.Double getCourse() {
      return course;
    }

    /**
      * Sets the value of the 'course' field.
      * @param value The value of 'course'.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder setCourse(double value) {
      validate(fields()[3], value);
      this.course = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'course' field has been set.
      * @return True if the 'course' field has been set, false otherwise.
      */
    public boolean hasCourse() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'course' field.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder clearCourse() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'nationality' field.
      * @return The value.
      */
    public org.sourcestream.entities.nationality getNationality() {
      return nationality;
    }

    /**
      * Sets the value of the 'nationality' field.
      * @param value The value of 'nationality'.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder setNationality(org.sourcestream.entities.nationality value) {
      validate(fields()[4], value);
      this.nationality = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'nationality' field has been set.
      * @return True if the 'nationality' field has been set, false otherwise.
      */
    public boolean hasNationality() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'nationality' field.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder clearNationality() {
      nationality = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'category' field.
      * @return The value.
      */
    public org.sourcestream.entities.category getCategory() {
      return category;
    }

    /**
      * Sets the value of the 'category' field.
      * @param value The value of 'category'.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder setCategory(org.sourcestream.entities.category value) {
      validate(fields()[5], value);
      this.category = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'category' field has been set.
      * @return True if the 'category' field has been set, false otherwise.
      */
    public boolean hasCategory() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'category' field.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder clearCategory() {
      category = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'pictureURL' field.
      * @return The value.
      */
    public java.lang.String getPictureURL() {
      return pictureURL;
    }

    /**
      * Sets the value of the 'pictureURL' field.
      * @param value The value of 'pictureURL'.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder setPictureURL(java.lang.String value) {
      validate(fields()[6], value);
      this.pictureURL = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'pictureURL' field has been set.
      * @return True if the 'pictureURL' field has been set, false otherwise.
      */
    public boolean hasPictureURL() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'pictureURL' field.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder clearPictureURL() {
      pictureURL = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'height' field.
      * @return The value.
      */
    public java.lang.Double getHeight() {
      return height;
    }

    /**
      * Sets the value of the 'height' field.
      * @param value The value of 'height'.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder setHeight(double value) {
      validate(fields()[7], value);
      this.height = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'height' field has been set.
      * @return True if the 'height' field has been set, false otherwise.
      */
    public boolean hasHeight() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'height' field.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder clearHeight() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'nickname' field.
      * @return The value.
      */
    public java.lang.String getNickname() {
      return nickname;
    }

    /**
      * Sets the value of the 'nickname' field.
      * @param value The value of 'nickname'.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder setNickname(java.lang.String value) {
      validate(fields()[8], value);
      this.nickname = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'nickname' field has been set.
      * @return True if the 'nickname' field has been set, false otherwise.
      */
    public boolean hasNickname() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'nickname' field.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder clearNickname() {
      nickname = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'externalSystemID' field.
      * This is ID given be external system.
      * @return The value.
      */
    public java.lang.String getExternalSystemID() {
      return externalSystemID;
    }

    /**
      * Sets the value of the 'externalSystemID' field.
      * This is ID given be external system.
      * @param value The value of 'externalSystemID'.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder setExternalSystemID(java.lang.String value) {
      validate(fields()[9], value);
      this.externalSystemID = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'externalSystemID' field has been set.
      * This is ID given be external system.
      * @return True if the 'externalSystemID' field has been set, false otherwise.
      */
    public boolean hasExternalSystemID() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'externalSystemID' field.
      * This is ID given be external system.
      * @return This builder.
      */
    public org.sourcestream.entities.generalEntityAttributes.Builder clearExternalSystemID() {
      externalSystemID = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    @Override
    public generalEntityAttributes build() {
      try {
        generalEntityAttributes record = new generalEntityAttributes();
        if (basicAttributesBuilder != null) {
          record.basicAttributes = this.basicAttributesBuilder.build();
        } else {
          record.basicAttributes = fieldSetFlags()[0] ? this.basicAttributes : (org.sourcestream.entities.basicEntityAttributes) defaultValue(fields()[0]);
        }
        record.speed = fieldSetFlags()[1] ? this.speed : (java.lang.Double) defaultValue(fields()[1]);
        record.elevation = fieldSetFlags()[2] ? this.elevation : (java.lang.Double) defaultValue(fields()[2]);
        record.course = fieldSetFlags()[3] ? this.course : (java.lang.Double) defaultValue(fields()[3]);
        record.nationality = fieldSetFlags()[4] ? this.nationality : (org.sourcestream.entities.nationality) defaultValue(fields()[4]);
        record.category = fieldSetFlags()[5] ? this.category : (org.sourcestream.entities.category) defaultValue(fields()[5]);
        record.pictureURL = fieldSetFlags()[6] ? this.pictureURL : (java.lang.String) defaultValue(fields()[6]);
        record.height = fieldSetFlags()[7] ? this.height : (java.lang.Double) defaultValue(fields()[7]);
        record.nickname = fieldSetFlags()[8] ? this.nickname : (java.lang.String) defaultValue(fields()[8]);
        record.externalSystemID = fieldSetFlags()[9] ? this.externalSystemID : (java.lang.String) defaultValue(fields()[9]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}