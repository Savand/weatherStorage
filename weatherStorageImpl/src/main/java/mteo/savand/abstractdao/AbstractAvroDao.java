package mteo.savand.abstractdao;

import java.io.File;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mteo.savand.avro_generate.batch.WeatherObject;
import mteo.savand.dao.WeatherObjectDaoImpl;

public abstract class AbstractAvroDao<T> {
    
    protected final Logger LOG = LoggerFactory.getLogger(getClass());
    
    private DataFileWriter<T> dataFileWriter;
    private DataFileWriter<T> fileWriter;
    private DatumWriter<T> weatherDatumWriter;

    private DatumReader<T> weatherDatumReader;
    private DataFileReader<T> fileReader;
    private File storageFile;
}
