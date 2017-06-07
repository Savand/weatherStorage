package mteo.savand.web.scheduler;


public interface WeatherAggregationScheduler {

    /**
     * Retrieve weather objects from inmemory storage, 
     * aggregate data and store the result to aggregated data file.
     * The method has to be invoked by a scheduler (by default - once
     * per hour)
     */
    
    void executeAggregation();

}
