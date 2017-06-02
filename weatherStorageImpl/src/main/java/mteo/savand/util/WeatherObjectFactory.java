package mteo.savand.util;

import mteo.savand.avro_generate.GeoLocationObject;
import mteo.savand.avro_generate.WeatherObject;
import mteo.savand.avro_generate.WindDirection;
import mteo.savand.avro_generate.WindObject;
import mteo.savand.dto.WeatherObjectDto;

public class WeatherObjectFactory {

    private WeatherObjectFactory() {}

    public static WeatherObject convertToWeatherObject(WeatherObjectDto weatherObjectDto){
        
        return WeatherObject.newBuilder()
        .setDate(weatherObjectDto.getDate())
        .setGeoLocationObject(GeoLocationObject.newBuilder().setLatitude(weatherObjectDto.getLocationLatitude()).setLongitude(weatherObjectDto.getLocationLongitude()).build())
        .setHumidityInPercentage(weatherObjectDto.getHumidityInPercentage())
        .setStationId(weatherObjectDto.getStationId())
        .setTemperatureInDegreesCelsious(weatherObjectDto.getTemperatureInDegreesCelsious())
        .setWind(WindObject.newBuilder().setWindSpeedInKnots(weatherObjectDto.getWindSpeedInKnots()).setDirection(WindDirection.valueOf(weatherObjectDto.getWindDirection())).build())
        .build();
        
    }


}
