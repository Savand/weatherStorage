/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package mteo.savand.avro_generate;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class GeoLocationObject extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 896795459310040422L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"GeoLocationObject\",\"namespace\":\"mteo.savand.avro_generate\",\"fields\":[{\"name\":\"latitude\",\"type\":\"float\"},{\"name\":\"longitude\",\"type\":\"float\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public float latitude;
  @Deprecated public float longitude;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public GeoLocationObject() {}

  /**
   * All-args constructor.
   * @param latitude The new value for latitude
   * @param longitude The new value for longitude
   */
  public GeoLocationObject(java.lang.Float latitude, java.lang.Float longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return latitude;
    case 1: return longitude;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: latitude = (java.lang.Float)value$; break;
    case 1: longitude = (java.lang.Float)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'latitude' field.
   * @return The value of the 'latitude' field.
   */
  public java.lang.Float getLatitude() {
    return latitude;
  }

  /**
   * Sets the value of the 'latitude' field.
   * @param value the value to set.
   */
  public void setLatitude(java.lang.Float value) {
    this.latitude = value;
  }

  /**
   * Gets the value of the 'longitude' field.
   * @return The value of the 'longitude' field.
   */
  public java.lang.Float getLongitude() {
    return longitude;
  }

  /**
   * Sets the value of the 'longitude' field.
   * @param value the value to set.
   */
  public void setLongitude(java.lang.Float value) {
    this.longitude = value;
  }

  /**
   * Creates a new GeoLocationObject RecordBuilder.
   * @return A new GeoLocationObject RecordBuilder
   */
  public static mteo.savand.avro_generate.GeoLocationObject.Builder newBuilder() {
    return new mteo.savand.avro_generate.GeoLocationObject.Builder();
  }

  /**
   * Creates a new GeoLocationObject RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new GeoLocationObject RecordBuilder
   */
  public static mteo.savand.avro_generate.GeoLocationObject.Builder newBuilder(mteo.savand.avro_generate.GeoLocationObject.Builder other) {
    return new mteo.savand.avro_generate.GeoLocationObject.Builder(other);
  }

  /**
   * Creates a new GeoLocationObject RecordBuilder by copying an existing GeoLocationObject instance.
   * @param other The existing instance to copy.
   * @return A new GeoLocationObject RecordBuilder
   */
  public static mteo.savand.avro_generate.GeoLocationObject.Builder newBuilder(mteo.savand.avro_generate.GeoLocationObject other) {
    return new mteo.savand.avro_generate.GeoLocationObject.Builder(other);
  }

  /**
   * RecordBuilder for GeoLocationObject instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<GeoLocationObject>
    implements org.apache.avro.data.RecordBuilder<GeoLocationObject> {

    private float latitude;
    private float longitude;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(mteo.savand.avro_generate.GeoLocationObject.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.latitude)) {
        this.latitude = data().deepCopy(fields()[0].schema(), other.latitude);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.longitude)) {
        this.longitude = data().deepCopy(fields()[1].schema(), other.longitude);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing GeoLocationObject instance
     * @param other The existing instance to copy.
     */
    private Builder(mteo.savand.avro_generate.GeoLocationObject other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.latitude)) {
        this.latitude = data().deepCopy(fields()[0].schema(), other.latitude);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.longitude)) {
        this.longitude = data().deepCopy(fields()[1].schema(), other.longitude);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'latitude' field.
      * @return The value.
      */
    public java.lang.Float getLatitude() {
      return latitude;
    }

    /**
      * Sets the value of the 'latitude' field.
      * @param value The value of 'latitude'.
      * @return This builder.
      */
    public mteo.savand.avro_generate.GeoLocationObject.Builder setLatitude(float value) {
      validate(fields()[0], value);
      this.latitude = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'latitude' field has been set.
      * @return True if the 'latitude' field has been set, false otherwise.
      */
    public boolean hasLatitude() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'latitude' field.
      * @return This builder.
      */
    public mteo.savand.avro_generate.GeoLocationObject.Builder clearLatitude() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'longitude' field.
      * @return The value.
      */
    public java.lang.Float getLongitude() {
      return longitude;
    }

    /**
      * Sets the value of the 'longitude' field.
      * @param value The value of 'longitude'.
      * @return This builder.
      */
    public mteo.savand.avro_generate.GeoLocationObject.Builder setLongitude(float value) {
      validate(fields()[1], value);
      this.longitude = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'longitude' field has been set.
      * @return True if the 'longitude' field has been set, false otherwise.
      */
    public boolean hasLongitude() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'longitude' field.
      * @return This builder.
      */
    public mteo.savand.avro_generate.GeoLocationObject.Builder clearLongitude() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public GeoLocationObject build() {
      try {
        GeoLocationObject record = new GeoLocationObject();
        record.latitude = fieldSetFlags()[0] ? this.latitude : (java.lang.Float) defaultValue(fields()[0]);
        record.longitude = fieldSetFlags()[1] ? this.longitude : (java.lang.Float) defaultValue(fields()[1]);
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