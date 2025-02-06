package vttp2023.batch3.assessment.paf.bookings.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2023.batch3.assessment.paf.bookings.models.Listing;
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


	//TODO: Task 4
	

	//TODO: Task 5


}
