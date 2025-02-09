package vttp2023.batch3.assessment.paf.bookings.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import vttp2023.batch3.assessment.paf.bookings.models.BookingForm;

@Repository
public class BookingRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getAvailability(String listingId) {

        int availability = jdbcTemplate.queryForObject(SQLQueries.GET_OCCUPANCY, Integer.class, listingId);

        return availability;

    }


    public String createReservation(String listingId, BookingForm bookingForm){
        String resvId = UUID.randomUUID().toString().substring(0, 8);

        jdbcTemplate.update(SQLQueries.INSERT_RESERVATION, resvId, bookingForm.getName(), bookingForm.getEmail(), listingId, bookingForm.getArrival(), bookingForm.getStay());

        return resvId;
    }





    public boolean updateAvailability(String listingId, int stay){
        int availability = getAvailability(listingId);
        int newAvailability = availability - stay;

        int availabilityUpdated = jdbcTemplate.update(SQLQueries.UPDATE_AVAILABILITY, newAvailability, listingId);

        if (availabilityUpdated == 1) {
            return true;
        } else {
            return false;
        }
    }



    // public String createReservation(String listingId, BookingForm bookingForm) {
    //     KeyHolder keyHolder = new GeneratedKeyHolder();

    //     PreparedStatementCreator psc = new PreparedStatementCreator() {

    //         @Override
    //         public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
    //             PreparedStatement ps = con.prepareStatement(SQLQueries.INSERT_RESERVATION, Statement.RETURN_GENERATED_KEYS);
    //                 ps.setString(1, bookingForm.getName());
    //                 ps.setString(2, bookingForm.getEmail());
    //                 ps.setString(3, listingId);
    //                 ps.setDate(4, new java.sql.Date(bookingForm.getArrival().getTime()));
    //                 ps.setInt(5, bookingForm.getStay());

    //                 return ps;
    //         }
    //     };

    //     jdbcTemplate.update(psc, keyHolder);

    //     String reservationId = keyHolder.getKey().toString();

    //     return reservationId;
    // }
}
