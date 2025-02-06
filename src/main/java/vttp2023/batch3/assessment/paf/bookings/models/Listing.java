package vttp2023.batch3.assessment.paf.bookings.models;

public class Listing {
    
    private String id;
    private String name;
    private double price;
    private String pictureUrl;


    public Listing() {
    }


    @Override
    public String toString() {
        return "Listing [id=" + id + ", name=" + name + ", price=" + price + ", pictureUrl=" + pictureUrl + "]";
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getPictureUrl() {
        return pictureUrl;
    }
    public void setPictureUrl(String imageUrl) {
        this.pictureUrl = imageUrl;
    }

}
