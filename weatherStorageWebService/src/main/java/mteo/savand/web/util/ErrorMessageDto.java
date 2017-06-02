package mteo.savand.web.util;

public class ErrorMessageDto {

    private String targetName;
    private String message;
   
    
    public ErrorMessageDto(String targetName, String message) {
        this.targetName = targetName;
        this.message = message;
    }
    
    public String getTargetName() {
        return targetName;
    }
    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
