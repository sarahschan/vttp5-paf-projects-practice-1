package vttp2023.batch3.assessment.paf.bookings.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;

@Service
public class ListingsService {
	
	@Autowired
	ListingsRepository listingsRepo;

	public List<String> getCountries(){
		return listingsRepo.getCountries();
	}


	
	//TODO: Task 3


	//TODO: Task 4
	

	//TODO: Task 5


}
