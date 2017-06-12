package mteo.savand.web.controller.error_handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.Errors;


public class ErrorsTranslator {
    
    public static List<ErrorDto> from(final Errors errors) {

        final List<ErrorDto> dtoErrors = errors.getFieldErrors().stream().map(fieldError -> {
            return new ErrorDto(fieldError.getField(),
                    fieldError.getDefaultMessage());
        }).collect(Collectors.toList());

        return dtoErrors;
    }

}
