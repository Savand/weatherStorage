package mteo.savand.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;

import mteo.savand.avro_generate.aggregation.GeoLocationObject;
import mteo.savand.avro_generate.aggregation.WeatherObjectAggregation;
import mteo.savand.avro_generate.batch.WeatherObject;

public class WeatherDataAggregatorUtil {

    private WeatherDataAggregatorUtil() {};

    public static List<WeatherObjectAggregation> getAggregatedDataGroupedByStationId(
            List<WeatherObject> dataFromCache) {
        List<WeatherObjectAggregation> resultList = new LinkedList<>();

        Collection<List<WeatherObject>> listsByStationId =
                getListsGroupedByStationId(dataFromCache);

        resultList = aggregateObjectsInCollecion(listsByStationId);

        return resultList;
    }

    private static List<WeatherObjectAggregation> aggregateObjectsInCollecion(
            Collection<List<WeatherObject>> listsByStationId) {
        List<WeatherObjectAggregation> resultList = new LinkedList<>();
        DateTime now = DateTime.now();
        for (List<WeatherObject> list : listsByStationId) {
            resultList.add(getAggregatedObjectFromList(list, now));
        }

        return resultList;
    }

    private static WeatherObjectAggregation getAggregatedObjectFromList(List<WeatherObject> list,
            DateTime now) {
        WeatherObject weatherObject = list.get(0);
        mteo.savand.avro_generate.batch.GeoLocationObject geoLocationObjectBatch =
                weatherObject.getGeoLocationObject();

        WeatherObjectAggregation aggregatedObject =
                WeatherObjectAggregation.newBuilder().setDate(now)
                        .setGeoLocationObjectBuilder(GeoLocationObject
                                .newBuilder().setLatitude(geoLocationObjectBatch.getLatitude())
                                .setLongitude(geoLocationObjectBatch.getLongitude()))
                        .setStationId(weatherObject.getStationId())
                        .setHumidityAggregateDataInPercentage(
                                getAggregatedData(getHumidityData(list)))
                        .setTemperatureAggregateDataInDegreesCelsious(
                                getAggregatedData(getTemperatureData(list)))
                        .setWindSpeedAggregateDataInKnots(getAggregatedData(getWindSpeedData(list)))
                        .build();

        return aggregatedObject;
    }


    private static List<Float> getAggregatedData(List<Float> data) {
        Float max = Collections.max(data);
        Float min = Collections.min(data);
        Float average = (float) data.stream().mapToDouble(a -> a).average().getAsDouble();
        return Arrays.asList(min, max, average);
    }

    private static List<Float> getWindSpeedData(List<WeatherObject> list) {
        return list.stream().map(a -> (float) a.getWind().getWindSpeedInKnots())
                .collect(Collectors.toList());
    }

    private static List<Float> getTemperatureData(List<WeatherObject> list) {
        return list.stream().map(a -> (float) a.getTemperatureInDegreesCelsious())
                .collect(Collectors.toList());
    }

    private static List<Float> getHumidityData(List<WeatherObject> list) {
        return list.stream().map(a -> (float) a.getHumidityInPercentage())
                .collect(Collectors.toList());
    }

    private static Collection<List<WeatherObject>> getListsGroupedByStationId(
            List<WeatherObject> dataFromCache) {
        return dataFromCache.stream().collect(Collectors.groupingBy(WeatherObject::getStationId))
                .values();
    }

}
