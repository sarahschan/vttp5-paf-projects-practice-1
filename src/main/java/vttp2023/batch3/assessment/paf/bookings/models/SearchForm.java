package vttp2023.batch3.assessment.paf.bookings.models;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class SearchForm {
    
        @NotNull(message = "Please select a country")
    private String country;

        @NotNull(message = "Please enter number of person(s)")
        @Min(value = 1, message = "Booking must be for a minimum of 1 pax")
        @Max(value = 10, message = "Booking must be for a maximum of 10 pax")
        @Digits(integer = 2, fraction = 0, message = "Hours must be a whole number")
    private int pax;

        @NotNull(message = "Please enter a minimum price per night")
        @Min(value = 1, message = "Minimum price is $1")
        @Max(value = 10000, message = "Maximum price is $10000")
        @Digits(integer = 5, fraction = 2, message = "Minimum price must be a number with a maximum of 2 decimal places")
    private double minPrice;

        @NotNull(message = "Please enter a maximum price per night")
        @Min(value = 1, message = "Minimum price is $1")
        @Max(value = 10000, message = "Maximum price is $10000")
        @Digits(integer = 5, fraction = 2, message = "Maximum price must be a number with a maximum of 2 decimal places")
    private double maxPrice;



    public SearchForm() {
    }

    public SearchForm(String country, int pax, double minPrice, double maxPrice) {
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
