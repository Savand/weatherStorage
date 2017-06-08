package mteo.savand.web.usecase;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mteo.savand.dto.WeatherObjectDto;
import mteo.savand.service.WeatherObjectService;
import mteo.savand.service.WeatherObjectServiceImpl;

public class StorageBatchUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(StorageBatchUseCase.class);

    private WeatherObjectService service;

    public StorageBatchUseCase() {
        service = new WeatherObjectServiceImpl();
    }

    public boolean store(WeatherObjectDto weatherObjectDto) {

        LOG.trace("service.store(weatherObjectDto) invocation");
        try {
            service.store(weatherObjectDto);
        } catch (IOException e) {
            LOG.error("IO exception while calling service.store(weatherObjectDto); ", e);
            return false;
        }

        return true;
    }

}
