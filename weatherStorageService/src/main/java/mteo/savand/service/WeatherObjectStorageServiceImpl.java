package mteo.savand.service;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import mteo.savand.avro_batch.WeatherObject;
import mteo.savand.dao.WeatherObjectStorageDao;
import mteo.savand.dao.WeatherObjectStorageDaoImpl;
import mteo.savand.dto.WeatherObjectDto;
import mteo.savand.util.WeatherObjectFactory;

public class WeatherObjectStorageServiceImpl implements WeatherObjectStorageService{

    private WeatherObjectStorageDao dao;
    private List<WeatherObject> aggregationDataList;
    
    public WeatherObjectStorageServiceImpl(File batchFile, File aggregationFile) {
        dao = new WeatherObjectStorageDaoImpl(batchFile);
        aggregationDataList = new LinkedList<>();
    }

    @Override
    public void store(WeatherObjectDto weatherObjectDto) throws IOException {
        WeatherObject weatherObject = WeatherObjectFactory.convertToWeatherObject(weatherObjectDto);
        dao.store(weatherObject);
        aggregationDataList.add(weatherObject);
    }

    @Override
    public WeatherObjectStorageDao getDao() {
        return dao;
    }

    @Override
    public List<WeatherObject> aggregateCurrentBatch() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean storeAggregatedList(List<WeatherObject> weatherObjects) {
        // TODO Auto-generated method stub
        return false;
    }
    

}
