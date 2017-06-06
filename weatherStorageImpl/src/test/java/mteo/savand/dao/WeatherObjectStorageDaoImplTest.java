package mteo.savand.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mteo.savand.avro_batch.GeoLocationObject;
import mteo.savand.avro_batch.WeatherObject;
import mteo.savand.avro_batch.WindDirection;
import mteo.savand.avro_batch.WindObject;

public class WeatherObjectStorageDaoImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherObjectStorageDaoImplTest.class);
    private WeatherObjectStorageDao dao;
    
    @Before
    public void setUp(){
        dao = new WeatherObjectStorageDaoImpl(new File("avro.obj"));
    }
    
    @Test
    public void testStore() throws IOException {
       
        WeatherObject weatherObject = WeatherObject.newBuilder()
        .setDate(DateTime.now())
        .setHumidityInPercentage(45)
        .setGeoLocationObject(GeoLocationObject.newBuilder().setLatitude(22.2f).setLongitude(11.2f).build())
        .setStationId(22)
        .setTemperatureInDegreesCelsious(50)
        .setWindBuilder(WindObject.newBuilder().setWindSpeedInKnots(9).setDirection(WindDirection.NNE))
        .build();
        

        dao.store(weatherObject);  
        weatherObject.setStationId(44);
        dao.store(weatherObject);                      
        List<WeatherObject> read = dao.read();   
        LOG.debug(read.toString());
        weatherObject.setStationId(66);
        dao.store(weatherObject);      
        List<WeatherObject> read2 = dao.read();  
        LOG.debug(read2.toString());
    }

}
