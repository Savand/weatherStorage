package mteo.savand.abstractdao;

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
import org.apache.avro.specific.SpecificRecordBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract avro dao that has a File object as argument that will serve as a storage.
 * 
 * 
 * @author Andrii_Savka
 *
 * @param <T>
 */
public abstract class AbstractAvroDao<T extends SpecificRecordBase> implements GenericDao<T> {

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    protected DataFileWriter<T> dataFileWriter;
    protected DataFileWriter<T> fileWriter;
    protected DatumWriter<T> datumWriter;
    protected Class<T> type;

    protected DatumReader<T> datumReader;
    protected DataFileReader<T> fileReader;
    protected File storageFile;

    public AbstractAvroDao(File file, Class<T> typeParameterClass) {
        LOG.debug("constructing WeatherStorageDaoImpl");
        this.storageFile = file;
        this.datumWriter = new SpecificDatumWriter<>(typeParameterClass);
        this.datumReader = new SpecificDatumReader<>(typeParameterClass);
        this.type = typeParameterClass;
        initFileWriter();
    }


    @Override
    public void store(T object) throws IOException {
        if (fileReader != null) {
            fileReader.close();
        }

        LOG.debug("writing object to the file");
        fileWriter.append(object);
    }

    @Override
    public List<T> read() {
        prepareFileReading();

        LOG.debug("reading from file");
        List<T> result = new LinkedList<>();
        fileReader.forEach(item -> result.add(item));

        return result;
    }


    private void prepareFileReading() {
        try {
            if (fileWriter != null) {
                fileWriter.close();
            }

            fileReader = new DataFileReader<T>(storageFile, datumReader);
        } catch (IOException e) {
            LOG.error("IOException while creating dataFileReader", e.getStackTrace().toString());
        }

        reconnectToFileWriter();
    }


    private void reconnectToFileWriter() {
        try {
            fileWriter = dataFileWriter.appendTo(storageFile);
        } catch (IOException e) {
            LOG.error("IOException while recconecting dataFileWriter",
                    e.getStackTrace().toString());
        }

    }


    private void initFileWriter() {
        dataFileWriter = new DataFileWriter<T>(datumWriter);
        try {
            fileWriter = dataFileWriter.create(type.newInstance().getSchema(), storageFile);
        } catch (IOException e) {
            LOG.error("IOException while creating dataFileWriter", e.getStackTrace().toString());
        } catch (InstantiationException e) {
            LOG.error(e.getStackTrace().toString());
        } catch (IllegalAccessException e) {
            LOG.error(e.getStackTrace().toString());
        }

    }
}
