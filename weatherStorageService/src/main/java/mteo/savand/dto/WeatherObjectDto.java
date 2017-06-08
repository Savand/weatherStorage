package mteo.savand.dto;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @NotBlank(message = "windDirection must not be null")
    private String windDirection;

    
    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Float getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(Float locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public Float getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(Float locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public Integer getTemperatureInDegreesCelsious() {
        return temperatureInDegreesCelsious;
    }

    public void setTemperatureInDegreesCelsious(Integer temperatureInDegreesCelsious) {
        this.temperatureInDegreesCelsious = temperatureInDegreesCelsious;
    }

    public Integer getHumidityInPercentage() {
        return humidityInPercentage;
    }

    public void setHumidityInPercentage(Integer humidityInPercentage) {
        this.humidityInPercentage = humidityInPercentage;
    }

    public Integer getWindSpeedInKnots() {
        return windSpeedInKnots;
    }

    public void setWindSpeedInKnots(Integer windSpeedInKnots) {
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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result
                + ((humidityInPercentage == null) ? 0 : humidityInPercentage.hashCode());
        result = prime * result + ((locationLatitude == null) ? 0 : locationLatitude.hashCode());
        result = prime * result + ((locationLongitude == null) ? 0 : locationLongitude.hashCode());
        result = prime * result + ((stationId == null) ? 0 : stationId.hashCode());
        result = prime * result + ((temperatureInDegreesCelsious == null) ? 0
                : temperatureInDegreesCelsious.hashCode());
        result = prime * result + ((windDirection == null) ? 0 : windDirection.hashCode());
        result = prime * result + ((windSpeedInKnots == null) ? 0 : windSpeedInKnots.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WeatherObjectDto other = (WeatherObjectDto) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (humidityInPercentage == null) {
            if (other.humidityInPercentage != null)
                return false;
        } else if (!humidityInPercentage.equals(other.humidityInPercentage))
            return false;
        if (locationLatitude == null) {
            if (other.locationLatitude != null)
                return false;
        } else if (!locationLatitude.equals(other.locationLatitude))
            return false;
        if (locationLongitude == null) {
            if (other.locationLongitude != null)
                return false;
        } else if (!locationLongitude.equals(other.locationLongitude))
            return false;
        if (stationId == null) {
            if (other.stationId != null)
                return false;
        } else if (!stationId.equals(other.stationId))
            return false;
        if (temperatureInDegreesCelsious == null) {
            if (other.temperatureInDegreesCelsious != null)
                return false;
        } else if (!temperatureInDegreesCelsious.equals(other.temperatureInDegreesCelsious))
            return false;
        if (windDirection == null) {
            if (other.windDirection != null)
                return false;
        } else if (!windDirection.equals(other.windDirection))
            return false;
        if (windSpeedInKnots == null) {
            if (other.windSpeedInKnots != null)
                return false;
        } else if (!windSpeedInKnots.equals(other.windSpeedInKnots))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "WeatherObjectDto [stationId=" + stationId + ", locationLatitude=" + locationLatitude
                + ", locationLongitude=" + locationLongitude + ", date=" + date
                + ", temperatureInDegreesCelsious=" + temperatureInDegreesCelsious
                + ", humidityInPercentage=" + humidityInPercentage + ", windSpeedInKnots="
                + windSpeedInKnots + ", windDirection=" + windDirection + "]";
    }
    
    

}
