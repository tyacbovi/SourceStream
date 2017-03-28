/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.sourcestream.entities;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** This is a schema for basic entity attributes, this will represent basic entity in all life cycle */
@org.apache.avro.specific.AvroGenerated
public class basicEntityAttributes extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -9148817540169616942L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"basicEntityAttributes\",\"namespace\":\"org.sourcestream.entities\",\"doc\":\"This is a schema for basic entity attributes, this will represent basic entity in all life cycle\",\"fields\":[{\"name\":\"coordinate\",\"type\":{\"type\":\"record\",\"name\":\"coordinate\",\"doc\":\"Location attribute in grid format\",\"fields\":[{\"name\":\"lat\",\"type\":\"double\"},{\"name\":\"long\",\"type\":\"double\"}]}},{\"name\":\"isNotTracked\",\"type\":\"boolean\"},{\"name\":\"entityOffset\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public org.sourcestream.entities.coordinate coordinate;
  @Deprecated public boolean isNotTracked;
  @Deprecated public long entityOffset;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public basicEntityAttributes() {}

  /**
   * All-args constructor.
   * @param coordinate The new value for coordinate
   * @param isNotTracked The new value for isNotTracked
   * @param entityOffset The new value for entityOffset
   */
  public basicEntityAttributes(org.sourcestream.entities.coordinate coordinate, java.lang.Boolean isNotTracked, java.lang.Long entityOffset) {
    this.coordinate = coordinate;
    this.isNotTracked = isNotTracked;
    this.entityOffset = entityOffset;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return coordinate;
    case 1: return isNotTracked;
    case 2: return entityOffset;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: coordinate = (org.sourcestream.entities.coordinate)value$; break;
    case 1: isNotTracked = (java.lang.Boolean)value$; break;
    case 2: entityOffset = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'coordinate' field.
   * @return The value of the 'coordinate' field.
   */
  public org.sourcestream.entities.coordinate getCoordinate() {
    return coordinate;
  }

  /**
   * Sets the value of the 'coordinate' field.
   * @param value the value to set.
   */
  public void setCoordinate(org.sourcestream.entities.coordinate value) {
    this.coordinate = value;
  }

  /**
   * Gets the value of the 'isNotTracked' field.
   * @return The value of the 'isNotTracked' field.
   */
  public java.lang.Boolean getIsNotTracked() {
    return isNotTracked;
  }

  /**
   * Sets the value of the 'isNotTracked' field.
   * @param value the value to set.
   */
  public void setIsNotTracked(java.lang.Boolean value) {
    this.isNotTracked = value;
  }

  /**
   * Gets the value of the 'entityOffset' field.
   * @return The value of the 'entityOffset' field.
   */
  public java.lang.Long getEntityOffset() {
    return entityOffset;
  }

  /**
   * Sets the value of the 'entityOffset' field.
   * @param value the value to set.
   */
  public void setEntityOffset(java.lang.Long value) {
    this.entityOffset = value;
  }

  /**
   * Creates a new basicEntityAttributes RecordBuilder.
   * @return A new basicEntityAttributes RecordBuilder
   */
  public static org.sourcestream.entities.basicEntityAttributes.Builder newBuilder() {
    return new org.sourcestream.entities.basicEntityAttributes.Builder();
  }

  /**
   * Creates a new basicEntityAttributes RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new basicEntityAttributes RecordBuilder
   */
  public static org.sourcestream.entities.basicEntityAttributes.Builder newBuilder(org.sourcestream.entities.basicEntityAttributes.Builder other) {
    return new org.sourcestream.entities.basicEntityAttributes.Builder(other);
  }

  /**
   * Creates a new basicEntityAttributes RecordBuilder by copying an existing basicEntityAttributes instance.
   * @param other The existing instance to copy.
   * @return A new basicEntityAttributes RecordBuilder
   */
  public static org.sourcestream.entities.basicEntityAttributes.Builder newBuilder(org.sourcestream.entities.basicEntityAttributes other) {
    return new org.sourcestream.entities.basicEntityAttributes.Builder(other);
  }

  /**
   * RecordBuilder for basicEntityAttributes instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<basicEntityAttributes>
    implements org.apache.avro.data.RecordBuilder<basicEntityAttributes> {

    private org.sourcestream.entities.coordinate coordinate;
    private org.sourcestream.entities.coordinate.Builder coordinateBuilder;
    private boolean isNotTracked;
    private long entityOffset;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.sourcestream.entities.basicEntityAttributes.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.coordinate)) {
        this.coordinate = data().deepCopy(fields()[0].schema(), other.coordinate);
        fieldSetFlags()[0] = true;
      }
      if (other.hasCoordinateBuilder()) {
        this.coordinateBuilder = org.sourcestream.entities.coordinate.newBuilder(other.getCoordinateBuilder());
      }
      if (isValidValue(fields()[1], other.isNotTracked)) {
        this.isNotTracked = data().deepCopy(fields()[1].schema(), other.isNotTracked);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.entityOffset)) {
        this.entityOffset = data().deepCopy(fields()[2].schema(), other.entityOffset);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing basicEntityAttributes instance
     * @param other The existing instance to copy.
     */
    private Builder(org.sourcestream.entities.basicEntityAttributes other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.coordinate)) {
        this.coordinate = data().deepCopy(fields()[0].schema(), other.coordinate);
        fieldSetFlags()[0] = true;
      }
      this.coordinateBuilder = null;
      if (isValidValue(fields()[1], other.isNotTracked)) {
        this.isNotTracked = data().deepCopy(fields()[1].schema(), other.isNotTracked);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.entityOffset)) {
        this.entityOffset = data().deepCopy(fields()[2].schema(), other.entityOffset);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'coordinate' field.
      * @return The value.
      */
    public org.sourcestream.entities.coordinate getCoordinate() {
      return coordinate;
    }

    /**
      * Sets the value of the 'coordinate' field.
      * @param value The value of 'coordinate'.
      * @return This builder.
      */
    public org.sourcestream.entities.basicEntityAttributes.Builder setCoordinate(org.sourcestream.entities.coordinate value) {
      validate(fields()[0], value);
      this.coordinateBuilder = null;
      this.coordinate = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'coordinate' field has been set.
      * @return True if the 'coordinate' field has been set, false otherwise.
      */
    public boolean hasCoordinate() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'coordinate' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public org.sourcestream.entities.coordinate.Builder getCoordinateBuilder() {
      if (coordinateBuilder == null) {
        if (hasCoordinate()) {
          setCoordinateBuilder(org.sourcestream.entities.coordinate.newBuilder(coordinate));
        } else {
          setCoordinateBuilder(org.sourcestream.entities.coordinate.newBuilder());
        }
      }
      return coordinateBuilder;
    }

    /**
     * Sets the Builder instance for the 'coordinate' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public org.sourcestream.entities.basicEntityAttributes.Builder setCoordinateBuilder(org.sourcestream.entities.coordinate.Builder value) {
      clearCoordinate();
      coordinateBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'coordinate' field has an active Builder instance
     * @return True if the 'coordinate' field has an active Builder instance
     */
    public boolean hasCoordinateBuilder() {
      return coordinateBuilder != null;
    }

    /**
      * Clears the value of the 'coordinate' field.
      * @return This builder.
      */
    public org.sourcestream.entities.basicEntityAttributes.Builder clearCoordinate() {
      coordinate = null;
      coordinateBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'isNotTracked' field.
      * @return The value.
      */
    public java.lang.Boolean getIsNotTracked() {
      return isNotTracked;
    }

    /**
      * Sets the value of the 'isNotTracked' field.
      * @param value The value of 'isNotTracked'.
      * @return This builder.
      */
    public org.sourcestream.entities.basicEntityAttributes.Builder setIsNotTracked(boolean value) {
      validate(fields()[1], value);
      this.isNotTracked = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'isNotTracked' field has been set.
      * @return True if the 'isNotTracked' field has been set, false otherwise.
      */
    public boolean hasIsNotTracked() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'isNotTracked' field.
      * @return This builder.
      */
    public org.sourcestream.entities.basicEntityAttributes.Builder clearIsNotTracked() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'entityOffset' field.
      * @return The value.
      */
    public java.lang.Long getEntityOffset() {
      return entityOffset;
    }

    /**
      * Sets the value of the 'entityOffset' field.
      * @param value The value of 'entityOffset'.
      * @return This builder.
      */
    public org.sourcestream.entities.basicEntityAttributes.Builder setEntityOffset(long value) {
      validate(fields()[2], value);
      this.entityOffset = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'entityOffset' field has been set.
      * @return True if the 'entityOffset' field has been set, false otherwise.
      */
    public boolean hasEntityOffset() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'entityOffset' field.
      * @return This builder.
      */
    public org.sourcestream.entities.basicEntityAttributes.Builder clearEntityOffset() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public basicEntityAttributes build() {
      try {
        basicEntityAttributes record = new basicEntityAttributes();
        if (coordinateBuilder != null) {
          record.coordinate = this.coordinateBuilder.build();
        } else {
          record.coordinate = fieldSetFlags()[0] ? this.coordinate : (org.sourcestream.entities.coordinate) defaultValue(fields()[0]);
        }
        record.isNotTracked = fieldSetFlags()[1] ? this.isNotTracked : (java.lang.Boolean) defaultValue(fields()[1]);
        record.entityOffset = fieldSetFlags()[2] ? this.entityOffset : (java.lang.Long) defaultValue(fields()[2]);
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