package mteo.savand.dao;

import java.io.IOException;

import mteo.savand.dto.WeatherObjectDto;


public interface WeatherStorageDao {

    void store(WeatherObjectDto weatherObjectDto) throws IOException;
    
}
