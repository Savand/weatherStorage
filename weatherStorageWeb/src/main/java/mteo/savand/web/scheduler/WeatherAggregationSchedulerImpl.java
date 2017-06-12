package mteo.savand.web.scheduler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import mteo.savand.avro_generate.aggregation.WeatherObjectAggregation;
import mteo.savand.avro_generate.batch.WeatherObject;
import mteo.savand.cache.WeatherObjectCache;
import mteo.savand.service.WeatherObjectAggregationService;
import mteo.savand.service.WeatherObjectAggregationServiceImpl;
import mteo.savand.util.WeatherDataAggregatorUtil;

@Component
public class WeatherAggregationSchedulerImpl implements WeatherAggregationScheduler {

    private static final Logger LOG =
            LoggerFactory.getLogger(WeatherAggregationSchedulerImpl.class);

    private final WeatherObjectAggregationService service;

    public WeatherAggregationSchedulerImpl() {
        service = new WeatherObjectAggregationServiceImpl();
    }


    @Override
//     @Scheduled(cron="0 0 * * * *") //each hour
    @Scheduled(cron = "*/30 * * * * *") //each 30 sec
    public void executeAggregation() {
        final List<WeatherObject> dataFromCache = WeatherObjectCache.getDataAndClearCache();

        if (dataFromCache == null) {
            LOG.debug("dataFromCache is Empty or null. Nothing to aggregate");
            return;
        }

        final List<WeatherObjectAggregation> aggregatedWeatherobjects =
                WeatherDataAggregatorUtil.getAggregatedDataGroupedByStationId(dataFromCache);

        LOG.debug("trigger aggregate function");
        service.storeWeatherObjectAggregationList(aggregatedWeatherobjects);
    }

}
