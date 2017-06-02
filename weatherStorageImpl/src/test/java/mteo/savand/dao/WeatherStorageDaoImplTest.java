package mteo.savand.dao;

import java.io.IOException;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mteo.savand.dto.WeatherObjectDto;

public class WeatherStorageDaoImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherStorageDaoImplTest.class);
    private WeatherStorageDao dao;
    
    @Before
    public void setUp(){
        dao = new WeatherStorageDaoImpl();
    }
    
    @Test
    public void testStore() throws IOException {
       
        WeatherObjectDto weatherObjectDto = WeatherObjectDto.newBuilder()
        .setDate(DateTime.now())
        .setHumidityInPercentage(45)
        .setLocationLatitude(22.22f)
        .setLocationLongitude(33.33f)
        .setStationId(22)
        .setTemperatureInDegreesCelsious(50)
        .setWindDirection("NE")
        .setWindSpeedInKnots(5)
        .build();
        

        dao.store(weatherObjectDto);                      
        
    }

}
