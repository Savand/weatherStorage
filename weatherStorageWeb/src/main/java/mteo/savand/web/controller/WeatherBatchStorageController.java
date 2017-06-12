package mteo.savand.web.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mteo.savand.dto.WeatherObjectDto;
import mteo.savand.web.controller.error_handler.ErrorsTranslator;
import mteo.savand.web.usecase.StorageBatchUseCase;

@Scope("request")
@RestController
@RequestMapping("/rest/weather")
public class WeatherBatchStorageController {
    
    private static final Logger LOG = LoggerFactory.getLogger(WeatherBatchStorageController.class);
    private final StorageBatchUseCase storageBatchUseCase;

    public WeatherBatchStorageController() {
        storageBatchUseCase = new StorageBatchUseCase();
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> store(@Valid @RequestBody final WeatherObjectDto weatherObjectDto,
            final Errors errors) {
        LOG.trace("Validating object that came to controller");

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(ErrorsTranslator.from(errors));
        }

        LOG.info("storing object '{}' ", weatherObjectDto);

        if (!storageBatchUseCase.store(weatherObjectDto)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


}
