package mteo.savand.dao;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mteo.savand.avro_batch.WeatherObject;


public class WeatherObjectStorageDaoImpl implements WeatherObjectStorageDao {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherObjectStorageDaoImpl.class);
    private DataFileWriter<WeatherObject> dataFileWriter;
    private DataFileWriter<WeatherObject> fileWriter;
    private DatumWriter<WeatherObject> weatherDatumWriter;

    private DatumReader<WeatherObject> weatherDatumReader;
    private DataFileReader<WeatherObject> fileReader;
    private File storageFile;

    public WeatherObjectStorageDaoImpl(File file) {
        LOG.debug("constructing WeatherStorageDaoImpl");
        storageFile = file;
        weatherDatumWriter = new SpecificDatumWriter<WeatherObject>(WeatherObject.class);
        weatherDatumReader = new SpecificDatumReader<WeatherObject>(WeatherObject.class);
        initFileWriter();
    }

    @Override
    public void store(WeatherObject weatherObject) throws IOException {
        if (fileReader != null) {
            fileReader.close();
        }

        LOG.debug("writing object to the file");
        fileWriter.append(weatherObject);
    }


    @Override
    public List<WeatherObject> read() {
        prepareFileReading();

        LOG.debug("reading from file");
        List<WeatherObject> result = new LinkedList<>();
        fileReader.forEach(item -> result.add(item));

        return result;
    }


    private void prepareFileReading() {
        try {
            if (fileWriter != null) {
                fileWriter.close();
            }

            fileReader = new DataFileReader<WeatherObject>(storageFile, weatherDatumReader);
        } catch (IOException e) {
            LOG.error("IOException while creating dataFileReader", e.getStackTrace().toString());
        }

        reconnectToFileWriter();
    }

    private void initFileWriter() {
        dataFileWriter = new DataFileWriter<WeatherObject>(weatherDatumWriter);
        try {
            fileWriter = dataFileWriter.create(WeatherObject.getClassSchema(), storageFile);
        } catch (IOException e) {
            LOG.error("IOException while creating dataFileWriter", e.getStackTrace().toString());
        }

    }

    private void reconnectToFileWriter() {
        try {
            fileWriter = dataFileWriter.appendTo(storageFile);
        } catch (IOException e) {
            LOG.error("IOException while recconecting dataFileWriter",
                    e.getStackTrace().toString());
        }

    }

}
