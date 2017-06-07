package mteo.savand.web.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import mteo.savand.web.util.WeatherObservationErrorMessageDto;

public class ErrorsTranslator {

    private static final Logger LOG = LoggerFactory.getLogger(ErrorsTranslator.class);

    public static List<WeatherObservationErrorMessageDto> from(Errors errors) {
        List<FieldError> fieldErrors = errors.getFieldErrors();

        List<WeatherObservationErrorMessageDto> dtoErrors = fieldErrors.stream().map(fieldError -> {
            return new WeatherObservationErrorMessageDto(fieldError.getField(),
                    fieldError.getDefaultMessage());
        }).collect(Collectors.toList());

        LOG.debug(fieldErrors.toString());

        return dtoErrors;
    }

}
