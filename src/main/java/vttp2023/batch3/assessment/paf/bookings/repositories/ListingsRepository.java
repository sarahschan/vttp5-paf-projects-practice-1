package vttp2023.batch3.assessment.paf.bookings.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ListingsRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<String> getCountries(){
		
		List<String> countries = mongoTemplate.findDistinct(new Query(), "address.country", "listings", String.class);

		Collections.sort(countries);
		
		return countries;
	}

	
	//TODO: Task 3


	//TODO: Task 4
	

	//TODO: Task 5


}
