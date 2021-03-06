/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package mteo.savand.avro_generate.aggregation;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class WeatherObjectAggregation extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1358865167766495295L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"WeatherObjectAggregation\",\"namespace\":\"mteo.savand.avro_generate.aggregation\",\"fields\":[{\"name\":\"stationId\",\"type\":\"int\"},{\"name\":\"geoLocationObject\",\"type\":{\"type\":\"record\",\"name\":\"GeoLocationObject\",\"fields\":[{\"name\":\"latitude\",\"type\":\"float\"},{\"name\":\"longitude\",\"type\":\"float\"}]}},{\"name\":\"date\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"temperatureAggregateDataInDegreesCelsious\",\"type\":{\"type\":\"array\",\"items\":\"float\"}},{\"name\":\"humidityAggregateDataInPercentage\",\"type\":{\"type\":\"array\",\"items\":\"float\"}},{\"name\":\"windSpeedAggregateDataInKnots\",\"type\":{\"type\":\"array\",\"items\":\"float\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int stationId;
  @Deprecated public mteo.savand.avro_generate.aggregation.GeoLocationObject geoLocationObject;
  @Deprecated public org.joda.time.DateTime date;
  @Deprecated public java.util.List<java.lang.Float> temperatureAggregateDataInDegreesCelsious;
  @Deprecated public java.util.List<java.lang.Float> humidityAggregateDataInPercentage;
  @Deprecated public java.util.List<java.lang.Float> windSpeedAggregateDataInKnots;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public WeatherObjectAggregation() {}

  /**
   * All-args constructor.
   * @param stationId The new value for stationId
   * @param geoLocationObject The new value for geoLocationObject
   * @param date The new value for date
   * @param temperatureAggregateDataInDegreesCelsious The new value for temperatureAggregateDataInDegreesCelsious
   * @param humidityAggregateDataInPercentage The new value for humidityAggregateDataInPercentage
   * @param windSpeedAggregateDataInKnots The new value for windSpeedAggregateDataInKnots
   */
  public WeatherObjectAggregation(java.lang.Integer stationId, mteo.savand.avro_generate.aggregation.GeoLocationObject geoLocationObject, org.joda.time.DateTime date, java.util.List<java.lang.Float> temperatureAggregateDataInDegreesCelsious, java.util.List<java.lang.Float> humidityAggregateDataInPercentage, java.util.List<java.lang.Float> windSpeedAggregateDataInKnots) {
    this.stationId = stationId;
    this.geoLocationObject = geoLocationObject;
    this.date = date;
    this.temperatureAggregateDataInDegreesCelsious = temperatureAggregateDataInDegreesCelsious;
    this.humidityAggregateDataInPercentage = humidityAggregateDataInPercentage;
    this.windSpeedAggregateDataInKnots = windSpeedAggregateDataInKnots;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return stationId;
    case 1: return geoLocationObject;
    case 2: return date;
    case 3: return temperatureAggregateDataInDegreesCelsious;
    case 4: return humidityAggregateDataInPercentage;
    case 5: return windSpeedAggregateDataInKnots;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  protected static final org.apache.avro.data.TimeConversions.DateConversion DATE_CONVERSION = new org.apache.avro.data.TimeConversions.DateConversion();
  protected static final org.apache.avro.data.TimeConversions.TimeConversion TIME_CONVERSION = new org.apache.avro.data.TimeConversions.TimeConversion();
  protected static final org.apache.avro.data.TimeConversions.TimestampConversion TIMESTAMP_CONVERSION = new org.apache.avro.data.TimeConversions.TimestampConversion();

  private final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      TIMESTAMP_CONVERSION,
      null,
      null,
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: stationId = (java.lang.Integer)value$; break;
    case 1: geoLocationObject = (mteo.savand.avro_generate.aggregation.GeoLocationObject)value$; break;
    case 2: date = (org.joda.time.DateTime)value$; break;
    case 3: temperatureAggregateDataInDegreesCelsious = (java.util.List<java.lang.Float>)value$; break;
    case 4: humidityAggregateDataInPercentage = (java.util.List<java.lang.Float>)value$; break;
    case 5: windSpeedAggregateDataInKnots = (java.util.List<java.lang.Float>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'stationId' field.
   * @return The value of the 'stationId' field.
   */
  public java.lang.Integer getStationId() {
    return stationId;
  }

  /**
   * Sets the value of the 'stationId' field.
   * @param value the value to set.
   */
  public void setStationId(java.lang.Integer value) {
    this.stationId = value;
  }

  /**
   * Gets the value of the 'geoLocationObject' field.
   * @return The value of the 'geoLocationObject' field.
   */
  public mteo.savand.avro_generate.aggregation.GeoLocationObject getGeoLocationObject() {
    return geoLocationObject;
  }

  /**
   * Sets the value of the 'geoLocationObject' field.
   * @param value the value to set.
   */
  public void setGeoLocationObject(mteo.savand.avro_generate.aggregation.GeoLocationObject value) {
    this.geoLocationObject = value;
  }

  /**
   * Gets the value of the 'date' field.
   * @return The value of the 'date' field.
   */
  public org.joda.time.DateTime getDate() {
    return date;
  }

  /**
   * Sets the value of the 'date' field.
   * @param value the value to set.
   */
  public void setDate(org.joda.time.DateTime value) {
    this.date = value;
  }

  /**
   * Gets the value of the 'temperatureAggregateDataInDegreesCelsious' field.
   * @return The value of the 'temperatureAggregateDataInDegreesCelsious' field.
   */
  public java.util.List<java.lang.Float> getTemperatureAggregateDataInDegreesCelsious() {
    return temperatureAggregateDataInDegreesCelsious;
  }

  /**
   * Sets the value of the 'temperatureAggregateDataInDegreesCelsious' field.
   * @param value the value to set.
   */
  public void setTemperatureAggregateDataInDegreesCelsious(java.util.List<java.lang.Float> value) {
    this.temperatureAggregateDataInDegreesCelsious = value;
  }

  /**
   * Gets the value of the 'humidityAggregateDataInPercentage' field.
   * @return The value of the 'humidityAggregateDataInPercentage' field.
   */
  public java.util.List<java.lang.Float> getHumidityAggregateDataInPercentage() {
    return humidityAggregateDataInPercentage;
  }

  /**
   * Sets the value of the 'humidityAggregateDataInPercentage' field.
   * @param value the value to set.
   */
  public void setHumidityAggregateDataInPercentage(java.util.List<java.lang.Float> value) {
    this.humidityAggregateDataInPercentage = value;
  }

  /**
   * Gets the value of the 'windSpeedAggregateDataInKnots' field.
   * @return The value of the 'windSpeedAggregateDataInKnots' field.
   */
  public java.util.List<java.lang.Float> getWindSpeedAggregateDataInKnots() {
    return windSpeedAggregateDataInKnots;
  }

  /**
   * Sets the value of the 'windSpeedAggregateDataInKnots' field.
   * @param value the value to set.
   */
  public void setWindSpeedAggregateDataInKnots(java.util.List<java.lang.Float> value) {
    this.windSpeedAggregateDataInKnots = value;
  }

  /**
   * Creates a new WeatherObjectAggregation RecordBuilder.
   * @return A new WeatherObjectAggregation RecordBuilder
   */
  public static mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder newBuilder() {
    return new mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder();
  }

  /**
   * Creates a new WeatherObjectAggregation RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new WeatherObjectAggregation RecordBuilder
   */
  public static mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder newBuilder(mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder other) {
    return new mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder(other);
  }

  /**
   * Creates a new WeatherObjectAggregation RecordBuilder by copying an existing WeatherObjectAggregation instance.
   * @param other The existing instance to copy.
   * @return A new WeatherObjectAggregation RecordBuilder
   */
  public static mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder newBuilder(mteo.savand.avro_generate.aggregation.WeatherObjectAggregation other) {
    return new mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder(other);
  }

  /**
   * RecordBuilder for WeatherObjectAggregation instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<WeatherObjectAggregation>
    implements org.apache.avro.data.RecordBuilder<WeatherObjectAggregation> {

    private int stationId;
    private mteo.savand.avro_generate.aggregation.GeoLocationObject geoLocationObject;
    private mteo.savand.avro_generate.aggregation.GeoLocationObject.Builder geoLocationObjectBuilder;
    private org.joda.time.DateTime date;
    private java.util.List<java.lang.Float> temperatureAggregateDataInDegreesCelsious;
    private java.util.List<java.lang.Float> humidityAggregateDataInPercentage;
    private java.util.List<java.lang.Float> windSpeedAggregateDataInKnots;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.stationId)) {
        this.stationId = data().deepCopy(fields()[0].schema(), other.stationId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.geoLocationObject)) {
        this.geoLocationObject = data().deepCopy(fields()[1].schema(), other.geoLocationObject);
        fieldSetFlags()[1] = true;
      }
      if (other.hasGeoLocationObjectBuilder()) {
        this.geoLocationObjectBuilder = mteo.savand.avro_generate.aggregation.GeoLocationObject.newBuilder(other.getGeoLocationObjectBuilder());
      }
      if (isValidValue(fields()[2], other.date)) {
        this.date = data().deepCopy(fields()[2].schema(), other.date);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.temperatureAggregateDataInDegreesCelsious)) {
        this.temperatureAggregateDataInDegreesCelsious = data().deepCopy(fields()[3].schema(), other.temperatureAggregateDataInDegreesCelsious);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.humidityAggregateDataInPercentage)) {
        this.humidityAggregateDataInPercentage = data().deepCopy(fields()[4].schema(), other.humidityAggregateDataInPercentage);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.windSpeedAggregateDataInKnots)) {
        this.windSpeedAggregateDataInKnots = data().deepCopy(fields()[5].schema(), other.windSpeedAggregateDataInKnots);
        fieldSetFlags()[5] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing WeatherObjectAggregation instance
     * @param other The existing instance to copy.
     */
    private Builder(mteo.savand.avro_generate.aggregation.WeatherObjectAggregation other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.stationId)) {
        this.stationId = data().deepCopy(fields()[0].schema(), other.stationId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.geoLocationObject)) {
        this.geoLocationObject = data().deepCopy(fields()[1].schema(), other.geoLocationObject);
        fieldSetFlags()[1] = true;
      }
      this.geoLocationObjectBuilder = null;
      if (isValidValue(fields()[2], other.date)) {
        this.date = data().deepCopy(fields()[2].schema(), other.date);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.temperatureAggregateDataInDegreesCelsious)) {
        this.temperatureAggregateDataInDegreesCelsious = data().deepCopy(fields()[3].schema(), other.temperatureAggregateDataInDegreesCelsious);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.humidityAggregateDataInPercentage)) {
        this.humidityAggregateDataInPercentage = data().deepCopy(fields()[4].schema(), other.humidityAggregateDataInPercentage);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.windSpeedAggregateDataInKnots)) {
        this.windSpeedAggregateDataInKnots = data().deepCopy(fields()[5].schema(), other.windSpeedAggregateDataInKnots);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'stationId' field.
      * @return The value.
      */
    public java.lang.Integer getStationId() {
      return stationId;
    }

    /**
      * Sets the value of the 'stationId' field.
      * @param value The value of 'stationId'.
      * @return This builder.
      */
    public mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder setStationId(int value) {
      validate(fields()[0], value);
      this.stationId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'stationId' field has been set.
      * @return True if the 'stationId' field has been set, false otherwise.
      */
    public boolean hasStationId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'stationId' field.
      * @return This builder.
      */
    public mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder clearStationId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'geoLocationObject' field.
      * @return The value.
      */
    public mteo.savand.avro_generate.aggregation.GeoLocationObject getGeoLocationObject() {
      return geoLocationObject;
    }

    /**
      * Sets the value of the 'geoLocationObject' field.
      * @param value The value of 'geoLocationObject'.
      * @return This builder.
      */
    public mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder setGeoLocationObject(mteo.savand.avro_generate.aggregation.GeoLocationObject value) {
      validate(fields()[1], value);
      this.geoLocationObjectBuilder = null;
      this.geoLocationObject = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'geoLocationObject' field has been set.
      * @return True if the 'geoLocationObject' field has been set, false otherwise.
      */
    public boolean hasGeoLocationObject() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'geoLocationObject' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public mteo.savand.avro_generate.aggregation.GeoLocationObject.Builder getGeoLocationObjectBuilder() {
      if (geoLocationObjectBuilder == null) {
        if (hasGeoLocationObject()) {
          setGeoLocationObjectBuilder(mteo.savand.avro_generate.aggregation.GeoLocationObject.newBuilder(geoLocationObject));
        } else {
          setGeoLocationObjectBuilder(mteo.savand.avro_generate.aggregation.GeoLocationObject.newBuilder());
        }
      }
      return geoLocationObjectBuilder;
    }

    /**
     * Sets the Builder instance for the 'geoLocationObject' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder setGeoLocationObjectBuilder(mteo.savand.avro_generate.aggregation.GeoLocationObject.Builder value) {
      clearGeoLocationObject();
      geoLocationObjectBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'geoLocationObject' field has an active Builder instance
     * @return True if the 'geoLocationObject' field has an active Builder instance
     */
    public boolean hasGeoLocationObjectBuilder() {
      return geoLocationObjectBuilder != null;
    }

    /**
      * Clears the value of the 'geoLocationObject' field.
      * @return This builder.
      */
    public mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder clearGeoLocationObject() {
      geoLocationObject = null;
      geoLocationObjectBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'date' field.
      * @return The value.
      */
    public org.joda.time.DateTime getDate() {
      return date;
    }

    /**
      * Sets the value of the 'date' field.
      * @param value The value of 'date'.
      * @return This builder.
      */
    public mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder setDate(org.joda.time.DateTime value) {
      validate(fields()[2], value);
      this.date = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'date' field has been set.
      * @return True if the 'date' field has been set, false otherwise.
      */
    public boolean hasDate() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'date' field.
      * @return This builder.
      */
    public mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder clearDate() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'temperatureAggregateDataInDegreesCelsious' field.
      * @return The value.
      */
    public java.util.List<java.lang.Float> getTemperatureAggregateDataInDegreesCelsious() {
      return temperatureAggregateDataInDegreesCelsious;
    }

    /**
      * Sets the value of the 'temperatureAggregateDataInDegreesCelsious' field.
      * @param value The value of 'temperatureAggregateDataInDegreesCelsious'.
      * @return This builder.
      */
    public mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder setTemperatureAggregateDataInDegreesCelsious(java.util.List<java.lang.Float> value) {
      validate(fields()[3], value);
      this.temperatureAggregateDataInDegreesCelsious = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'temperatureAggregateDataInDegreesCelsious' field has been set.
      * @return True if the 'temperatureAggregateDataInDegreesCelsious' field has been set, false otherwise.
      */
    public boolean hasTemperatureAggregateDataInDegreesCelsious() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'temperatureAggregateDataInDegreesCelsious' field.
      * @return This builder.
      */
    public mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder clearTemperatureAggregateDataInDegreesCelsious() {
      temperatureAggregateDataInDegreesCelsious = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'humidityAggregateDataInPercentage' field.
      * @return The value.
      */
    public java.util.List<java.lang.Float> getHumidityAggregateDataInPercentage() {
      return humidityAggregateDataInPercentage;
    }

    /**
      * Sets the value of the 'humidityAggregateDataInPercentage' field.
      * @param value The value of 'humidityAggregateDataInPercentage'.
      * @return This builder.
      */
    public mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder setHumidityAggregateDataInPercentage(java.util.List<java.lang.Float> value) {
      validate(fields()[4], value);
      this.humidityAggregateDataInPercentage = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'humidityAggregateDataInPercentage' field has been set.
      * @return True if the 'humidityAggregateDataInPercentage' field has been set, false otherwise.
      */
    public boolean hasHumidityAggregateDataInPercentage() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'humidityAggregateDataInPercentage' field.
      * @return This builder.
      */
    public mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder clearHumidityAggregateDataInPercentage() {
      humidityAggregateDataInPercentage = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'windSpeedAggregateDataInKnots' field.
      * @return The value.
      */
    public java.util.List<java.lang.Float> getWindSpeedAggregateDataInKnots() {
      return windSpeedAggregateDataInKnots;
    }

    /**
      * Sets the value of the 'windSpeedAggregateDataInKnots' field.
      * @param value The value of 'windSpeedAggregateDataInKnots'.
      * @return This builder.
      */
    public mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder setWindSpeedAggregateDataInKnots(java.util.List<java.lang.Float> value) {
      validate(fields()[5], value);
      this.windSpeedAggregateDataInKnots = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'windSpeedAggregateDataInKnots' field has been set.
      * @return True if the 'windSpeedAggregateDataInKnots' field has been set, false otherwise.
      */
    public boolean hasWindSpeedAggregateDataInKnots() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'windSpeedAggregateDataInKnots' field.
      * @return This builder.
      */
    public mteo.savand.avro_generate.aggregation.WeatherObjectAggregation.Builder clearWindSpeedAggregateDataInKnots() {
      windSpeedAggregateDataInKnots = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public WeatherObjectAggregation build() {
      try {
        WeatherObjectAggregation record = new WeatherObjectAggregation();
        record.stationId = fieldSetFlags()[0] ? this.stationId : (java.lang.Integer) defaultValue(fields()[0]);
        if (geoLocationObjectBuilder != null) {
          record.geoLocationObject = this.geoLocationObjectBuilder.build();
        } else {
          record.geoLocationObject = fieldSetFlags()[1] ? this.geoLocationObject : (mteo.savand.avro_generate.aggregation.GeoLocationObject) defaultValue(fields()[1]);
        }
        record.date = fieldSetFlags()[2] ? this.date : (org.joda.time.DateTime) defaultValue(fields()[2]);
        record.temperatureAggregateDataInDegreesCelsious = fieldSetFlags()[3] ? this.temperatureAggregateDataInDegreesCelsious : (java.util.List<java.lang.Float>) defaultValue(fields()[3]);
        record.humidityAggregateDataInPercentage = fieldSetFlags()[4] ? this.humidityAggregateDataInPercentage : (java.util.List<java.lang.Float>) defaultValue(fields()[4]);
        record.windSpeedAggregateDataInKnots = fieldSetFlags()[5] ? this.windSpeedAggregateDataInKnots : (java.util.List<java.lang.Float>) defaultValue(fields()[5]);
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
