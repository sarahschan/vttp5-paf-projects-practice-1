package vttp2023.batch3.assessment.paf.bookings.exceptions;

public class ListingNotFoundException extends RuntimeException {
    
    public ListingNotFoundException(String message){
        super(message);
    }
}
