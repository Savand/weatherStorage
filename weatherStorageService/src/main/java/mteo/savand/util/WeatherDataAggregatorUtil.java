package mteo.savand.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import mteo.savand.avro_generate.aggregation.WeatherObjectAggregation;
import mteo.savand.avro_generate.batch.WeatherObject;

public class WeatherDataAggregatorUtil {

    private WeatherDataAggregatorUtil() {};

    public static List<WeatherObjectAggregation> getAggregatedDataGroupedByStationId(
            List<WeatherObject> dataFromCache) {
        List<WeatherObjectAggregation> resultList = new LinkedList<>();

        Collection<List<WeatherObject>> listsByStationId = getListsGroupedByStationId(dataFromCache);



        return resultList;
    }

    private static Collection<List<WeatherObject>> getListsGroupedByStationId(
            List<WeatherObject> dataFromCache) {
        return dataFromCache.stream().collect(Collectors.groupingBy(WeatherObject::getStationId))
                .values();
    }

}
