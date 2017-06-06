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
     * Stores data to the batch file and to the caching object for further data aggregation
     * @param weatherObjectDto
     * @throws IOException
     */
    List<WeatherObjectAggregation> aggregateAndStoreCurrentBatch();
}
