package mteo.savand.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.joda.time.DateTime;


@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class WeatherObjectDto {
    @NotNull(message = "stationId must not be null")
    private Integer stationId;

    @NotNull(message = "locationLatitude must not be null")
    private Float locationLatitude;

    @NotNull(message = "locationLongitude must not be null")
    private Float locationLongitude;

    @NotNull(message = "date must not be null")
    private DateTime date;

    @NotNull(message = "temperatureInDegreesCelsious must not be null")
    @Range(min = -100, max = 60, message = "temperatureInDegreesCelsious sould be in the range -100 - 60")
    private Integer temperatureInDegreesCelsious;

    @NotNull(message = "humidityInPercentage must not be null")
    @Range(min = 0, max = 100, message = "Percentage field should be between 0-100")
    private Integer humidityInPercentage;

    @NotNull(message = "windSpeedInKnots must not be null")
    @Range(min = 0, max = 220, message = "windSpeedInKnots must be in range 0-220")
    private Integer windSpeedInKnots;

    @NotNull(message = "direction must not be null")
    @NotBlank
    private String windDirection;

    
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public float getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(float locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public float getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(float locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public int getTemperatureInDegreesCelsious() {
        return temperatureInDegreesCelsious;
    }

    public void setTemperatureInDegreesCelsious(int temperatureInDegreesCelsious) {
        this.temperatureInDegreesCelsious = temperatureInDegreesCelsious;
    }

    public int getHumidityInPercentage() {
        return humidityInPercentage;
    }

    public void setHumidityInPercentage(int humidityInPercentage) {
        this.humidityInPercentage = humidityInPercentage;
    }

    public int getWindSpeedInKnots() {
        return windSpeedInKnots;
    }

    public void setWindSpeedInKnots(int windSpeedInKnots) {
        this.windSpeedInKnots = windSpeedInKnots;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }
    
    public static WeatherObjectDtoBuilder newBuilder() {
        return new WeatherObjectDto().new WeatherObjectDtoBuilder();
    }
    
    


    public class WeatherObjectDtoBuilder {

        private WeatherObjectDtoBuilder() {}

        public WeatherObjectDtoBuilder setStationId(int stationId) {
            WeatherObjectDto.this.stationId = stationId;
            return this;
        }

        public WeatherObjectDtoBuilder setLocationLatitude(float locationLatitude) {
            WeatherObjectDto.this.locationLatitude = locationLatitude;
            return this;
        }
        
        public WeatherObjectDtoBuilder setLocationLongitude(float locationLongitude) {
            WeatherObjectDto.this.locationLongitude = locationLongitude;
            return this;
        }
        
        public WeatherObjectDtoBuilder setDate(DateTime date) {
            WeatherObjectDto.this.date = date;
            return this;
        }
        
        public WeatherObjectDtoBuilder setTemperatureInDegreesCelsious(int temperatureInDegreesCelsious) {
            WeatherObjectDto.this.temperatureInDegreesCelsious = temperatureInDegreesCelsious;
            return this;
        }
        
        
        public WeatherObjectDtoBuilder setHumidityInPercentage(int humidityInPercentage) {
            WeatherObjectDto.this.humidityInPercentage = humidityInPercentage;
            return this;
        }
        
        public WeatherObjectDtoBuilder setWindSpeedInKnots(int windSpeedInKnots) {
            WeatherObjectDto.this.windSpeedInKnots = windSpeedInKnots;
            return this;
        }
        
        public WeatherObjectDtoBuilder setWindDirection(String windDirection) {
            WeatherObjectDto.this.windDirection = windDirection;
            return this;
        }
        
        
        public WeatherObjectDto build() {
            return WeatherObjectDto.this;
        }

    }

}
