package mteo.savand.util;

import java.util.LinkedList;
import java.util.List;

import mteo.savand.avro_generate.aggregation.WeatherObjectAggregation;
import mteo.savand.avro_generate.batch.WeatherObject;

public class WeatherDataAggregatorUtil {

    private WeatherDataAggregatorUtil(){};
    
    public static List<WeatherObjectAggregation> getAggregatedDataGroupedyStatinId(
            List<WeatherObject> dataFromCache) {
        List<WeatherObjectAggregation> resultList = new LinkedList<>();
        
        //TODO implement aggregation
        
        return resultList;
    }

}
