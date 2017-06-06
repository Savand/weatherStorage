package mteo.savand.service;

import java.io.IOException;
import java.util.List;

import mteo.savand.avro_batch.WeatherObject;
import mteo.savand.dao.WeatherObjectStorageDao;
import mteo.savand.dto.WeatherObjectDto;

public interface WeatherObjectStorageService {
    
    /**
     * Stores data to the batch file and to the caching object for further data aggregation
     * @param weatherObjectDto
     * @throws IOException
     */
    void store(WeatherObjectDto weatherObjectDto) throws IOException;

    
    /**
     * Returns the data source that this WeatherObjectStorageService object represents.
     * @return 
     */
    WeatherObjectStorageDao getDao();
    
    
    /**
     * Aggregates cached data and clears the cache
     */
    public List<WeatherObject> aggregateCurrentBatch();
    
    
    /**
     * Stores aggregated data to the aggregation data storage
     */
    public boolean storeAggregatedList(List<WeatherObject> weatherObjects);
}
