package pe.jsaire.apibuses.exceptions;

public class BusNotFoundException extends RuntimeException {
    
    public BusNotFoundException(String message) {
        super(message);
    }
}
