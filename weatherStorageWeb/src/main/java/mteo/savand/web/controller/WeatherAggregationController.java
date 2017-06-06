package mteo.savand.web.controller;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import mteo.savand.service.WeatherObjectAggregationService;
import mteo.savand.service.WeatherObjectAggregationServiceImpl;

@Controller
public class WeatherAggregationController {
    
    private static final Logger LOG = LoggerFactory.getLogger(WeatherAggregationController.class);
    private static final String AGGR_FILE_NAME = "d://aggregationData.avro";
    
    private WeatherObjectAggregationService service;

    public WeatherAggregationController() {
        service = new WeatherObjectAggregationServiceImpl(new File(AGGR_FILE_NAME));
    }
    
    @Scheduled(cron="0 0 * * * ?")    
//    @Scheduled(cron="*/5 * * * * ?")    
    private void executeAggregation(){
        LOG.debug("trigger aggregate function");
        service.aggregateAndStoreCurrentBatch();
    }
    
}
