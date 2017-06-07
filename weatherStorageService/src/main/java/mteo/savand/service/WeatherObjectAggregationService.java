package mteo.savand.service;

import java.io.IOException;
import java.util.List;

import mteo.savand.avro_generate.aggregation.WeatherObjectAggregation;
import mteo.savand.dao.WeatherObjectAggregationDao;

public interface WeatherObjectAggregationService {

    /**
     * get dao to access the file with aggregation data
     * @return
     */
    WeatherObjectAggregationDao<WeatherObjectAggregation> getAggregationDao();
    
    /**
     * Stores data to the aggregated data file
     * @param weatherAggregatedObjects
     * @throws IOException
     */
    boolean storeWeatherObjectAggregationList(List<WeatherObjectAggregation> weatherAggregatedObjects);
}
