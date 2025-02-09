package vttp2023.batch3.assessment.paf.bookings.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp2023.batch3.assessment.paf.bookings.exceptions.ListingNotAvailableException;
import vttp2023.batch3.assessment.paf.bookings.models.BookingForm;
import vttp2023.batch3.assessment.paf.bookings.repositories.BookingRepository;

@Service
public class BookingService {
    
    @Autowired
    BookingRepository bookingRepository;

    @Transactional
    public Optional<String> processBooking(String listingId, BookingForm bookingForm) {

        // check availability
        int availablilty = bookingRepository.getAvailability(listingId);
        if (availablilty < bookingForm.getStay()) {
            throw new ListingNotAvailableException(String.format("Listing %s is not available for %d days", listingId, bookingForm.getStay()));
        }

        // insert into reservation table
        String reservationId = bookingRepository.createReservation(listingId, bookingForm);

        // update availability
        Boolean updatedAvailability = bookingRepository.updateAvailability(listingId, bookingForm.getStay());

        if (reservationId != null && updatedAvailability) {
            return Optional.of(reservationId);
        }

        return Optional.empty();

    }
}
