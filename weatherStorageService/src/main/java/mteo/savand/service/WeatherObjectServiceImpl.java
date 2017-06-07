package mteo.savand.service;

import java.io.File;
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

    
    public WeatherObjectServiceImpl(File batchFile) {
        LOG.debug("constructing WeatherObjectStorageServiceImpl...");
        daoBatch = new WeatherObjectDaoBatchImpl(batchFile,  WeatherObject.class);
    }


    @Override
    public void store(WeatherObjectDto weatherObjectDto) throws IOException {
        WeatherObject weatherObject = WeatherObjectFactory.convertToWeatherObject(weatherObjectDto);
        LOG.debug("dao.store(weatherObject) invocation");
        daoBatch.store(weatherObject);
        LOG.debug("WeatherObjectCache.add(weatherObject) invocation");
        WeatherObjectCache.add(weatherObject);
    }

    @Override
    public WeatherObjectBatchDao<WeatherObject> getDaoBatch() {
        return daoBatch;
    }



}
