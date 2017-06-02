package mteo.savand.web.util;

public class ObservationErrorMessageDto {

    private String observationName;
    private String message;
   
    
    public ObservationErrorMessageDto(String observationName, String message) {
        this.observationName = observationName;
        this.message = message;
    }
    
    public String getObservationName() {
        return observationName;
    }
    public void setObservationName(String observationName) {
        this.observationName = observationName;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
