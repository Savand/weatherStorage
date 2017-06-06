package mteo.savand.service;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import mteo.savand.avro_generate.batch.WeatherObject;
import mteo.savand.dao.WeatherObjectDao;
import mteo.savand.dao.WeatherObjectDaoImpl;
import mteo.savand.dto.WeatherObjectDto;
import mteo.savand.util.WeatherObjectFactory;

public class WeatherObjectStorageServiceImpl implements WeatherObjectStorageService{

    private WeatherObjectDao dao;
    private List<WeatherObject> aggregationDataList;
    
    public WeatherObjectStorageServiceImpl(File batchFile, File aggregationFile) {
        dao = new WeatherObjectDaoImpl(batchFile);
        aggregationDataList = new LinkedList<>();
    }

    @Override
    public void store(WeatherObjectDto weatherObjectDto) throws IOException {
        WeatherObject weatherObject = WeatherObjectFactory.convertToWeatherObject(weatherObjectDto);
        dao.store(weatherObject);
        aggregationDataList.add(weatherObject);
    }

    @Override
    public WeatherObjectDao getDao() {
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
