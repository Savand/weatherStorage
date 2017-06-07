package mteo.savand.dao;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mteo.savand.avro_generate.aggregation.WeatherObjectAggregation;
import mteo.savand.avro_generate.batch.GeoLocationObject;
import mteo.savand.avro_generate.batch.WeatherObject;
import mteo.savand.avro_generate.batch.WindDirection;
import mteo.savand.avro_generate.batch.WindObject;

public class WeatherObjectDaoImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherObjectDaoImplTest.class);
    private static final String BATCH_FILE_NAME = "d://testBatchDao.avro";
    private static final String AGGR_FILE_NAME = "d://testAggrDao.avro";

    private WeatherObjectBatchDao<WeatherObject> batchDao;
    private WeatherObjectAggregationDao<WeatherObjectAggregation> aggregationDao;

    @Before
    public void setUp() {
        batchDao = new WeatherObjectDaoBatchImpl(new File(BATCH_FILE_NAME), WeatherObject.class);
        aggregationDao = new WeatherObjectAggregationDaoImpl(new File(AGGR_FILE_NAME),
                WeatherObjectAggregation.class);
    }

    @Test
    public void testStoreIntoBatch() throws IOException {

        WeatherObject weatherObject = WeatherObject.newBuilder().setDate(DateTime.now())
                .setHumidityInPercentage(45)
                .setGeoLocationObjectBuilder(
                        GeoLocationObject.newBuilder().setLatitude(22.2f).setLongitude(11.2f))
                .setStationId(22).setTemperatureInDegreesCelsious(50).setWindBuilder(WindObject
                        .newBuilder().setWindSpeedInKnots(9).setDirection(WindDirection.NNE))
                .build();


        batchDao.store(weatherObject);
        weatherObject.setStationId(44);
        batchDao.store(weatherObject);
        List<WeatherObject> read = batchDao.read();
        LOG.debug(read.toString());
        weatherObject.setStationId(66);
        batchDao.store(weatherObject);
        List<WeatherObject> read2 = batchDao.read();
        LOG.debug(read2.toString());
    }

    @Test
    public void testStoreIntoAggregate() throws IOException {




        Map<CharSequence, Float> aggrWindSpeed = new HashMap<>();

        aggrWindSpeed.put("maxKnots", 9.5f);
        aggrWindSpeed.put("minKnots", 3f);
        aggrWindSpeed.put("avgKnots", 5.5f);


        WeatherObjectAggregation weatherObjectAggr = WeatherObjectAggregation.newBuilder()
                .setDate(DateTime.now())
                .setGeoLocationObjectBuilder(mteo.savand.avro_generate.aggregation.GeoLocationObject
                        .newBuilder().setLatitude(22.2f).setLongitude(11.2f))
                .setStationId(77).setHumidityAggregateDataInPercentage(Arrays.asList(34.4f, 66.5f, 47.7f))
                .setTemperatureAggregateDataInDegreesCelsious(Arrays.asList(21.4f, 28f, 26f))
                .setWindSpeedAggregateDataInKnots(Arrays.asList(3f, 9.5f, 5.5f)).build();
        

        WeatherObjectAggregation weatherObjectAggr1 = WeatherObjectAggregation.newBuilder()
                .setDate(DateTime.now())
                .setGeoLocationObjectBuilder(mteo.savand.avro_generate.aggregation.GeoLocationObject
                        .newBuilder().setLatitude(22.2f).setLongitude(11.2f))
                .setStationId(77).setHumidityAggregateDataInPercentage(Arrays.asList(22.4f, 44.5f, 33.7f))
                .setTemperatureAggregateDataInDegreesCelsious(Arrays.asList(25.4f, 32f, 29f))
                .setWindSpeedAggregateDataInKnots(Arrays.asList(5f, 8f, 6f)).build();

        List<WeatherObjectAggregation> weatherObjectAggregationList = Arrays.asList(weatherObjectAggr, weatherObjectAggr1);
        
        LOG.debug("Storing aggregated data...");
        aggregationDao.store(weatherObjectAggregationList);
        
        LOG.debug("Reading aggregated data..."); 
        List<WeatherObjectAggregation> read = aggregationDao.read();
        
        for (WeatherObjectAggregation weatherObjectAggregation : read) {
            LOG.debug(weatherObjectAggregation.toString());
        }


    }

}
