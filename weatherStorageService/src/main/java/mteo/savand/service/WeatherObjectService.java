package mteo.savand.service;

import java.io.IOException;

import mteo.savand.avro_generate.batch.WeatherObject;
import mteo.savand.dao.WeatherObjectBatchDao;
import mteo.savand.dto.WeatherObjectDto;

public interface WeatherObjectService {
    
    /**
     * Stores data to the batch file and to the caching object for further data aggregation
     * @param weatherObjectDto
     * @throws IOException
     */
    void store(WeatherObjectDto weatherObjectDto) throws IOException;
    
    
    /**
     * get dao to access the file with batch data
     * @return
     */
    WeatherObjectBatchDao<WeatherObject> getDaoBatch();
    

}
