package mteo.savand.cache;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mteo.savand.avro_generate.batch.WeatherObject;

public final class WeatherObjectCache{
    
    private static final Logger LOG = LoggerFactory.getLogger(WeatherObjectCache.class);

    private static List<WeatherObject> syncronizedDataList = startNewCache();

    private WeatherObjectCache() {}

    private static List<WeatherObject> startNewCache() {
        LOG.debug("create new cache");
        return Collections.synchronizedList(new LinkedList<>());
    }
    
    public static void add(WeatherObject obj){
        syncronizedDataList.add(obj);
    }
    
    /**
     * fetches data for aggregation and clears cache
     * 
     * @return
     */
    public static List<WeatherObject> getAndClearCurrentWeatherDataCache() {
        List<WeatherObject> resultList = new LinkedList<>();
        
        synchronized(syncronizedDataList){
            resultList = syncronizedDataList;
            syncronizedDataList = startNewCache();
        }
        
        return resultList;
    }
    
    
    
}
