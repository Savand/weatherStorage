package mteo.savand.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mteo.savand.avro_generate.aggregation.WeatherObjectAggregation;
import mteo.savand.dao.WeatherObjectAggregationDao;
import mteo.savand.dao.WeatherObjectAggregationDaoImpl;

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
    
    @Override
    public boolean storeWeatherObjectAggregationList(List<WeatherObjectAggregation> weatherObjects) {
        
        try {
            daoAggregation.store(weatherObjects);
        } catch (IOException e) {
            LOG.error(e.getStackTrace().toString());
            return false;
        }
        
        return true;
    }


    
}
