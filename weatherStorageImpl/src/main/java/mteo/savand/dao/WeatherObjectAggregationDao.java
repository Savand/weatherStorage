package mteo.savand.dao;

import java.io.IOException;
import java.util.List;

import mteo.savand.avro_generate.aggregation.WeatherObjectAggregation;

public interface WeatherObjectAggregationDao {

    /**
     * Stores one object to the file that is specified as constructor argument
     * @param weatherObject
     * @throws IOException
     */
    void store(List<WeatherObjectAggregation> weatherObjectAggregationList) throws IOException;

    
    /**
     * reads all stored records from the file
     * @return
     */
    List<WeatherObjectAggregation> read();
    
}
