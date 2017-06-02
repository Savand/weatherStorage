package mteo.savand.web;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mteo.savand.dao.WeatherStorageDao;
import mteo.savand.dao.WeatherStorageDaoImpl;
import mteo.savand.dto.WeatherObjectDto;
import mteo.savand.web.util.ErrorMessageDto;

@RestController
@RequestMapping("/rest/weather")
public class WeatherStorageController {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherStorageController.class);
    
    private WeatherStorageDao dao;
    
    
    public WeatherStorageController() {
        dao = new WeatherStorageDaoImpl();
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> store(@Valid @RequestBody WeatherObjectDto weatherObjectDto, Errors errors){
        LOG.debug("Validating object that came to controller");
        
        if (errors.hasErrors()) {

            // get all errors
            List<ObjectError> allErrors = errors.getAllErrors();
            List<ErrorMessageDto> dtoErrorList = new LinkedList<>();
            
            for (ObjectError objectError : allErrors) {
                String targetName = objectError.getObjectName();
                String message = objectError.getDefaultMessage();
                dtoErrorList.add(new ErrorMessageDto(targetName, message));
            }
            
            LOG.debug(dtoErrorList.toString());
            return ResponseEntity.badRequest().body(dtoErrorList);

        }
        
        LOG.debug("store triggered in controller");
        try {
            dao.store(weatherObjectDto);
        } catch (IOException e) {
            LOG.debug("IO exception with the next content " + e);
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        
        return ResponseEntity.ok().build();
        
    }
}
