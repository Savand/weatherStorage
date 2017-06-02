package mteo.savand.dao;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mteo.savand.avro_generate.WeatherObject;
import mteo.savand.dto.WeatherObjectDto;
import mteo.savand.util.WeatherObjectFactory;


public class WeatherStorageDaoImpl implements WeatherStorageDao {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherStorageDaoImpl.class);
    private DataFileWriter<WeatherObject> dataFileWriter;
    
    public WeatherStorageDaoImpl() {
        LOG.debug("initialiation of dataFileWriter");
        DatumWriter<WeatherObject> userDatumWriter = new SpecificDatumWriter<WeatherObject>(WeatherObject.class);
        dataFileWriter = new DataFileWriter<WeatherObject>(userDatumWriter);
    }

    @Override
    public void store(WeatherObjectDto weatherObjectDto) throws IOException {
        LOG.debug("writing object to fie");
        WeatherObject weatherObject = WeatherObjectFactory.convertToWeatherObject(weatherObjectDto);
        DataFileWriter<WeatherObject> fileWriter = dataFileWriter.create(weatherObject.getSchema(), new File("objects.avro"));
        fileWriter.append(weatherObject);
        fileWriter.close();
    }

}
