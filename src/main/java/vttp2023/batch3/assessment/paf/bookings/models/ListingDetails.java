package vttp2023.batch3.assessment.paf.bookings.models;

public class ListingDetails {
    
    private String id;
    private String description;
    private String street;
    private String suburb;
    private String country;
    private String pictureUrl;
    private double price;
    private String amenities;


    public ListingDetails() {
    
    }


    @Override
    public String toString() {
        return "ListingDetails [id=" + id + ", description=" + description + ", street=" + street + ", suburb=" + suburb
                + ", country=" + country + ", pictureUrl=" + pictureUrl + ", price=" + price + ", amenities="
                + amenities + "]";
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getSuburb() {
        return suburb;
    }
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPictureUrl() {
        return pictureUrl;
    }
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getAmenities() {
        return amenities;
    }
    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

}
