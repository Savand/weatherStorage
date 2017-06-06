package mteo.savand.dao;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mteo.savand.avro_generate.aggregation.WeatherObjectAggregation;

public class WeatherObjectAggregationImpl implements WeatherObjectAggregationDao {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherObjectAggregationImpl.class);
    
    @Override
    public void store(List<WeatherObjectAggregation> weatherObjectAggregationList)
            throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public List<WeatherObjectAggregation> read() {
        // TODO Auto-generated method stub
        return null;
    }

}
