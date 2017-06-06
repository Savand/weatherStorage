package mteo.savand.dao;

import java.io.IOException;
import java.util.List;

import mteo.savand.abstractdao.GenericDao;
import mteo.savand.avro_generate.aggregation.WeatherObjectAggregation;

public interface WeatherObjectAggregationDao<T> extends GenericDao<T>{

    /**
     * Stores aggregated weather objects
     * 
     * @param weatherObjectAggregationList
     * @throws IOException
     */
    void store(List<WeatherObjectAggregation> weatherObjectAggregationList) throws IOException;
           
    
}
