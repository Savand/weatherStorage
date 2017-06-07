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

        Map<CharSequence, Float> aggrHumidity = new HashMap<>();

        aggrHumidity.put("max%", 66.5f);
        aggrHumidity.put("min%", 34.4f);
        aggrHumidity.put("avg%", 47.7f);

        Map<CharSequence, Float> aggrTemperature = new HashMap<>();

        aggrTemperature.put("maxCelsium", 28f);
        aggrTemperature.put("minCelsium", 21f);
        aggrTemperature.put("avgCelsium", 26f);

        Map<CharSequence, Float> aggrWindSpeed = new HashMap<>();

        aggrWindSpeed.put("maxKnots", 9.5f);
        aggrWindSpeed.put("minKnots", 3f);
        aggrWindSpeed.put("avgKnots", 5.5f);


        WeatherObjectAggregation weatherObjectAggr = WeatherObjectAggregation.newBuilder()
                .setDate(DateTime.now())
                .setGeoLocationObjectBuilder(mteo.savand.avro_generate.aggregation.GeoLocationObject
                        .newBuilder().setLatitude(22.2f).setLongitude(11.2f))
                .setStationId(77).setHumidityAggregateDataInPercentage(aggrHumidity)
                .setTemperatureAggregateDataInDegreesCelsious(aggrTemperature)
                .setWindSpeedAggregateDataInKnots(aggrWindSpeed).build();
        
        Map<CharSequence, Float> aggrHumidity1 = new HashMap<>();
        aggrHumidity1.put("maxKnots", 11f);
        aggrHumidity1.put("minKnots", 5f);
        aggrHumidity1.put("avgKnots", 4f);
        
        Map<CharSequence, Float> aggrTemperature1 = new HashMap<>();
        
        aggrTemperature1.put("maxCelsium", 22f);
        aggrTemperature1.put("minCelsium", 10f);
        aggrTemperature1.put("avgCelsium", 13f);
        
        Map<CharSequence, Float> aggrWindSpeed1 = new HashMap<>();
        
        aggrWindSpeed1.put("max%", 77.5f);
        aggrWindSpeed1.put("min%", 50.4f);
        aggrWindSpeed1.put("avg%", 47.7f);

        WeatherObjectAggregation weatherObjectAggr1 = WeatherObjectAggregation.newBuilder()
                .setDate(DateTime.now())
                .setGeoLocationObjectBuilder(mteo.savand.avro_generate.aggregation.GeoLocationObject
                        .newBuilder().setLatitude(22.2f).setLongitude(11.2f))
                .setStationId(99).setHumidityAggregateDataInPercentage(aggrHumidity1)
                .setTemperatureAggregateDataInDegreesCelsious(aggrTemperature1)
                .setWindSpeedAggregateDataInKnots(aggrWindSpeed1).build();

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
