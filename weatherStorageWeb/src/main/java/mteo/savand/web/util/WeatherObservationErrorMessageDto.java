package mteo.savand.web.util;

public final class WeatherObservationErrorMessageDto {

    private final String observationName;
    private final String message;

    public WeatherObservationErrorMessageDto(String observationName, String message) {
        this.observationName = observationName;
        this.message = message;
    }

    public String getObservationName() {
        return observationName;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ObservationErrorMessageDto [observationName=" + observationName + ", message="
                + message + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + ((observationName == null) ? 0 : observationName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WeatherObservationErrorMessageDto other = (WeatherObservationErrorMessageDto) obj;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        if (observationName == null) {
            if (other.observationName != null)
                return false;
        } else if (!observationName.equals(other.observationName))
            return false;
        return true;
    }

}
