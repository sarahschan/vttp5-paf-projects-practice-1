package vttp2023.batch3.assessment.paf.bookings.exceptions;

public class UnableToProcessBookingException extends RuntimeException {
    
    public UnableToProcessBookingException(String message){
        super(message);
    }
}
