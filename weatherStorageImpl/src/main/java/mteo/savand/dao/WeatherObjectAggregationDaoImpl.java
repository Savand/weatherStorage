package mteo.savand.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import mteo.savand.abstractdao.AbstractAvroDao;
import mteo.savand.avro_generate.aggregation.WeatherObjectAggregation;

public class WeatherObjectAggregationDaoImpl extends AbstractAvroDao<WeatherObjectAggregation>
        implements WeatherObjectAggregationDao<WeatherObjectAggregation> {


    public WeatherObjectAggregationDaoImpl(File file,
            Class<WeatherObjectAggregation> typeParameterClass) {
        super(file, typeParameterClass);
    }

    @Override
    public void store(List<WeatherObjectAggregation> weatherObjectAggregationList)
            throws IOException {
        weatherObjectAggregationList.forEach(item -> {
            try {
                store(item);
            } catch (IOException e) {
                LOG.error(e.getStackTrace().toString());
            }
        });

    }

}
