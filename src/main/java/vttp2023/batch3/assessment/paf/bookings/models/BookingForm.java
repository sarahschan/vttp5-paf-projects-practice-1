package vttp2023.batch3.assessment.paf.bookings.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BookingForm {
    
        @NotNull(message = "Please enter your name")
        @Size(min = 3, max = 128, message ="Name must be between 3 and 60 characters")
    private String name;

        @NotNull(message = "Please enter your email")
        @Email(message = "Please enter a valid email address")
        @Size(min = 10, max = 128, message ="Email must be between 10 and 60 characters")
    private String email;

        @NotNull(message = "Please enter your arrival date")
        @Future(message = "Your arrival date must be in the future")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrival;

        @NotNull(message = "Please enter your stay duration in days")
        @Min(value = 1, message = "Minimum stay duration is 1 day")
    private int stay;


    public BookingForm() {
    }

    public BookingForm(String name, String email, Date arrival, int stay) {
        this.name = name;
        this.email = email;
        this.arrival = arrival;
        this.stay = stay;
    }


    @Override
    public String toString() {
        return "BookingForm [name=" + name + ", email=" + email + ", arrival=" + arrival + ", stay=" + stay + "]";
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getArrival() {
        return arrival;
    }
    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }
    public int getStay() {
        return stay;
    }
    public void setStay(int stay) {
        this.stay = stay;
    }

}
