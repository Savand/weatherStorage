package mteo.savand.dao;

import java.io.IOException;
import java.util.List;

import mteo.savand.avro_batch.WeatherObject;


public interface WeatherObjectStorageDao {

    
    /**
     * Stores one object to the file that is specified as constructor argument
     * @param weatherObject
     * @throws IOException
     */
    void store(WeatherObject weatherObject) throws IOException;

    
    /**
     * reads all stored records from the file
     * @return
     */
    List<WeatherObject> read();
    
}
