package mteo.savand;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mteo.savand.avro_generate.batch.WeatherObject;
import mteo.savand.dao.WeatherObjectDao;
import mteo.savand.dto.WeatherObjectDto;
import mteo.savand.service.WeatherObjectStorageService;
import mteo.savand.service.WeatherObjectStorageServiceImpl;

public class WeatherObjectStorageServiceImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherObjectStorageServiceImplTest.class);
    private WeatherObjectStorageService service;
    private WeatherObjectDao dao;
    
    @Before
    public void setUp(){
        service = new WeatherObjectStorageServiceImpl(new File("testBatchWeatherData.avro"), new File("testAggregateWeatherData.avro"));
        dao = service.getDao();
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
        

        service.store(weatherObjectDto);  
        weatherObjectDto.setStationId(44);
        service.store(weatherObjectDto);                      
        List<WeatherObject> read = dao.read();   
        LOG.debug(read.toString());
        weatherObjectDto.setStationId(66);
        service.store(weatherObjectDto);      
        List<WeatherObject> read2 = dao.read();  
        LOG.debug(read2.toString());
    }

}
