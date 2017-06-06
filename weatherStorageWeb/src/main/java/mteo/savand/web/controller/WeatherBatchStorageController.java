package mteo.savand.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mteo.savand.dto.WeatherObjectDto;
import mteo.savand.service.WeatherObjectService;
import mteo.savand.service.WeatherObjectServiceImpl;
import mteo.savand.web.util.ObservationErrorMessageDto;

@RestController
@RequestMapping("/rest/weather")
public class WeatherBatchStorageController {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherBatchStorageController.class);
    
    private WeatherObjectService service;
    

    public WeatherBatchStorageController() {
        service = new WeatherObjectServiceImpl(new File("restWeatherData.avro"));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> store(@Valid @RequestBody WeatherObjectDto weatherObjectDto, Errors errors){
        LOG.debug("Validating object that came to controller");
        if (errors.hasErrors()) {
            // get all errors
            List<FieldError> fieldErrors = errors.getFieldErrors();
            
            List<ObservationErrorMessageDto> dtoErrors = fieldErrors.stream()
            .map(fieldError -> {
               return new ObservationErrorMessageDto(fieldError.getField(), fieldError.getDefaultMessage());
            }).collect(Collectors.toList());
            
            LOG.debug(fieldErrors.toString());
            return ResponseEntity.badRequest().body(dtoErrors);
        }
        
        LOG.debug("store triggered in controller");
        try {
            service.store(weatherObjectDto);
        } catch (IOException e) {
            LOG.error("IO exception with the next content " + e);
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
        
    }
    

}
