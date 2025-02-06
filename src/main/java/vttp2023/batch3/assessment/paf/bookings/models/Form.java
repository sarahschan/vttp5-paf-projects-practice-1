package vttp2023.batch3.assessment.paf.bookings.models;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class Form {
    
        @NotNull(message = "Please select a country")
    private String country;

        @NotNull(message = "Please enter number of person(s)")
        @Min(value = 1, message = "Booking must be for at least 1 pax")
        @Digits(integer = 2, fraction = 0, message = "Hours must be a whole number")
    private int pax;

        @NotNull(message = "Please enter a minimum price per night")
        @Min(value = 0, message = "Minimum price cannot be negative")
        @Digits(integer = 10, fraction = 2, message = "Minimum price must be a number with a maximum of 2 decimal places")
    private double minPrice;

        @NotNull(message = "Please enter a maximum price per night")
        @Positive(message = "Amount must be a positive number")
        @Digits(integer = 10, fraction = 2, message = "Minimum price must be a number with a maximum of 2 decimal places")
    private double maxPrice;



    public Form() {
    }

    public Form(String country, int pax, double minPrice, double maxPrice) {
        this.country = country;
        this.pax = pax;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

}
