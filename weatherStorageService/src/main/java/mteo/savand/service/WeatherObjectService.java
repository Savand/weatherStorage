package mteo.savand.service;

import java.io.IOException;

import mteo.savand.avro_generate.batch.WeatherObject;
import mteo.savand.dao.WeatherObjectBatchDao;
import mteo.savand.dto.WeatherObjectDto;

public interface WeatherObjectService {
    
    /**
     * Store data to the file and to the caching object
     * @param weatherObjectDto
     * @throws IOException
     */
    void store(WeatherObjectDto weatherObjectDto) throws IOException;
    
    
    /**
     * get dao to access the file
     * @return
     */
    WeatherObjectBatchDao<WeatherObject> getDaoBatch();
    

}
