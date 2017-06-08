package mteo.savand.dao;

import mteo.savand.abstractdao.AbstractAvroDao;
import mteo.savand.avro_generate.batch.WeatherObject;


public class WeatherObjectDaoBatchImpl extends AbstractAvroDao<WeatherObject> implements WeatherObjectBatchDao<WeatherObject>{

    public WeatherObjectDaoBatchImpl() {
        super(WeatherObject.class);
    }

}
