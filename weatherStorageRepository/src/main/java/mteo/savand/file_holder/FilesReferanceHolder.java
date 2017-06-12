package mteo.savand.file_holder;

import java.io.File;

import org.apache.avro.specific.SpecificRecordBase;

import mteo.savand.avro_generate.aggregation.WeatherObjectAggregation;
import mteo.savand.avro_generate.batch.WeatherObject;

public class FilesReferanceHolder {

    private static final String BATCH_FILE_ENAME = "d://batchFile"; //TODO make file name configurable from properties in resources folder
    private static final String AGGREGATION_FILE_ENAME = "d://aggregationFile"; //TODO make file name configurable from properties in resources folder
    
    private final File batchFile;
    private final File aggregationFile;
   
    private final static FilesReferanceHolder fileHolder = new FilesReferanceHolder();

    
    public static FilesReferanceHolder getInstance(){
        return fileHolder;
    }
    
    private FilesReferanceHolder() {
        this.batchFile = new File(BATCH_FILE_ENAME);
        this.aggregationFile = new File(AGGREGATION_FILE_ENAME);
    }

    public <T extends SpecificRecordBase> File getFIle(final Class<T> type) {
        if (type.equals(WeatherObject.class)) {
            return batchFile;
        } else if (type.equals(WeatherObjectAggregation.class)) {
            return aggregationFile;
        }

        return null;
    }

}
