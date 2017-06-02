package mteo.savand.util;
//package util;
//
//import java.io.File;
//
//import org.apache.avro.file.DataFileWriter;
//import org.apache.avro.io.DatumWriter;
//import org.apache.avro.specific.SpecificDatumWriter;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import mteo.savand.dao.WeatherStorageDaoImpl;
//
//public class DataFileWriterUtil { //TODO use as factory in dao
//
//    private static final Logger LOG = LoggerFactory.getLogger(DataFileWriterUtil.class);
//    
//    private DataFileWriterUtil() {};
//
//    private <T> DataFileWriter<T> getFileWriter(File file, T clazz){
//        DatumWriter<T> userDatumWriter = new SpecificDatumWriter<>();
//        DataFileWriter<T> dataFileWriter = new DataFileWriter<>(userDatumWriter);
//        
//        return dataFileWriter;
//    };
//
//
//}
