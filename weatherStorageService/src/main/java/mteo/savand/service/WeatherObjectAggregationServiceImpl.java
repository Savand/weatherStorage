package mteo.savand.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mteo.savand.avro_generate.aggregation.WeatherObjectAggregation;
import mteo.savand.avro_generate.batch.WeatherObject;
import mteo.savand.cache.WeatherObjectCache;
import mteo.savand.dao.WeatherObjectAggregationDao;
import mteo.savand.dao.WeatherObjectAggregationDaoImpl;
import mteo.savand.util.WeatherDataAggregatorUtil;

public class WeatherObjectAggregationServiceImpl implements WeatherObjectAggregationService {
    
    private static final Logger LOG = LoggerFactory.getLogger(WeatherObjectAggregationServiceImpl.class);

    private WeatherObjectAggregationDao<WeatherObjectAggregation> daoAggregation;
    
    
    public WeatherObjectAggregationServiceImpl(File aggregationFile) {
        LOG.debug("constructing WeatherObjectAggregationServiceImpl...");
        daoAggregation = new WeatherObjectAggregationDaoImpl(aggregationFile, WeatherObjectAggregation.class);
    }

    @Override
    public WeatherObjectAggregationDao<WeatherObjectAggregation> getAggregationDao() {
        return daoAggregation;
    }

    private boolean storeAggregatedList(List<WeatherObjectAggregation> weatherObjects) {
        try {
            daoAggregation.store(weatherObjects);
        } catch (IOException e) {
            LOG.error(e.getStackTrace().toString());
            return false;
        }
        
        return true;
    }
    
    @Override
    public List<WeatherObjectAggregation> aggregateAndStoreCurrentBatch() {
        LOG.debug("aggregating data from cache");
        List<WeatherObject> dataFromCache = WeatherObjectCache.getAndClearCurrentWeatherDataCache();
        
        List<WeatherObjectAggregation> aggregatedWeatherobjects =
                getAggregatedWeatherObjects(dataFromCache);
        
        storeAggregatedList(aggregatedWeatherobjects);
        
        return aggregatedWeatherobjects;
    }

    private List<WeatherObjectAggregation> getAggregatedWeatherObjects(
            List<WeatherObject> dataFromCache) {
        return WeatherDataAggregatorUtil.getAggregatedDataGroupedyStatinId(dataFromCache);
    }

    
}
