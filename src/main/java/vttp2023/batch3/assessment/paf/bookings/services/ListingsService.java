package vttp2023.batch3.assessment.paf.bookings.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2023.batch3.assessment.paf.bookings.models.Listing;
import vttp2023.batch3.assessment.paf.bookings.models.ListingDetails;
import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;

@Service
public class ListingsService {
	
	@Autowired
	ListingsRepository listingsRepo;


	public List<String> getCountries(){
		return listingsRepo.getCountries();
	}


	public List<Listing> getSearchResults(String country, int pax, double minPrice, double maxPrice) {
		
		List<Document> getSearchResults = listingsRepo.getSearchResults(country, pax, minPrice, maxPrice);

		List<Listing> listings = new ArrayList<>();

		for (Document d : getSearchResults){
			Listing listing = new Listing();
				listing.setId(d.getString("_id"));
				listing.setName(d.getString("name"));
				listing.setPrice(d.getDouble("price"));
				listing.setPictureUrl(d.getString("picture_url"));

			listings.add(listing);
		}

		return listings;
	}


	public ListingDetails getListingDetails(String id){

		Document d = listingsRepo.getListingDetails(id);

		String amenitiesString = "-";

		List<String> amenitiesArray = d.getList("amenities", String.class);

		if (!amenitiesArray.isEmpty()) {
			StringBuilder amenitiesStringBuilder = new StringBuilder();
			for (int i = 0; i < amenitiesArray.size() - 1; i++){
				amenitiesStringBuilder.append(amenitiesArray.get(i)).append(", ");
			}
			amenitiesStringBuilder.append(amenitiesArray.get(amenitiesArray.size() - 1));
			amenitiesString = amenitiesStringBuilder.toString();
		}
		
		ListingDetails listingDetails = new ListingDetails();
			listingDetails.setId(d.getString("_id"));
			listingDetails.setDescription(d.getString("description"));
			listingDetails.setStreet(d.getString("street"));
			listingDetails.setSuburb(d.getString("suburb").isBlank() ? "(suburb not listed)" : d.getString("suburb"));
			listingDetails.setCountry(d.getString("country"));
			listingDetails.setPictureUrl(d.getString("picture_url"));
			listingDetails.setAmenities(amenitiesString);

		return listingDetails;
	}
	

	//TODO: Task 5


}
