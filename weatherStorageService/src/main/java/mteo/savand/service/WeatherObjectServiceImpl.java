package mteo.savand.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mteo.savand.avro_generate.batch.WeatherObject;
import mteo.savand.cache.WeatherObjectCache;
import mteo.savand.dao.WeatherObjectBatchDao;
import mteo.savand.dao.WeatherObjectDaoBatchImpl;
import mteo.savand.dto.WeatherObjectDto;
import mteo.savand.util.WeatherObjectFactory;

public class WeatherObjectServiceImpl implements WeatherObjectService{

    private static final Logger LOG = LoggerFactory.getLogger(WeatherObjectServiceImpl.class);
    
    private WeatherObjectBatchDao<WeatherObject> daoBatch;

    
    public WeatherObjectServiceImpl() {
        LOG.trace("constructing WeatherObjectStorageServiceImpl...");
        daoBatch = new WeatherObjectDaoBatchImpl();
    }


    @Override
    public void store(WeatherObjectDto weatherObjectDto) throws IOException {
        WeatherObject weatherObject = WeatherObjectFactory.convertToWeatherObject(weatherObjectDto);
        LOG.trace("dao.store(weatherObject) invocation");
        daoBatch.store(weatherObject);
        LOG.trace("WeatherObjectCache.add(weatherObject) invocation");
        WeatherObjectCache.add(weatherObject);
    }

    @Override
    public WeatherObjectBatchDao<WeatherObject> getDaoBatch() {
        return daoBatch;
    }

}
