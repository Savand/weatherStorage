package mteo.savand.dao;

import java.io.File;

import mteo.savand.abstractdao.AbstractAvroDao;
import mteo.savand.avro_generate.batch.WeatherObject;


public class WeatherObjectDaoBatchImpl extends AbstractAvroDao<WeatherObject> implements WeatherObjectBatchDao<WeatherObject>{

    public WeatherObjectDaoBatchImpl(File file, Class<WeatherObject> typeParameterClass) {
        super(file, typeParameterClass);
    }

}
