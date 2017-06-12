package mteo.savand.dao;

import java.io.IOException;
import java.util.List;

import mteo.savand.abstractdao.AbstractAvroDao;
import mteo.savand.avro_generate.aggregation.WeatherObjectAggregation;

public class WeatherObjectAggregationDaoImpl extends AbstractAvroDao<WeatherObjectAggregation>
        implements WeatherObjectAggregationDao<WeatherObjectAggregation> {


    public WeatherObjectAggregationDaoImpl() {
        super(WeatherObjectAggregation.class);
    }

    @Override
    public void store(final List<WeatherObjectAggregation> weatherObjectAggregationList)
            throws IOException {
        weatherObjectAggregationList.forEach(item -> {
            try {
                store(item);
            } catch (final IOException e) {
                LOG.error("IOException while storing aggregated objects", e);
            }
        });

    }

}
