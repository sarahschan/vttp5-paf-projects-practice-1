package vttp2023.batch3.assessment.paf.bookings.repositories;

import java.util.Collections;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ListingsRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	// db.listings.distinct("address.country")
	public List<String> getCountries(){
		
		List<String> countries = mongoTemplate.findDistinct(new Query(), "address.country", "listings", String.class);

		Collections.sort(countries);
		
		return countries;
	}

	
	// db.listings.aggregate([
    // { 
    //     $match: { 
    //         "address.country": { $regex: "^Australia$", $options: "i" },
    //         "accommodates": 2,
	//         "price": { $gte: 1, $lte: 100 }
    //     }
    // },
    // { 
    //     $project: { 
    //         "name": 1, 
    //         "price": 1, 
    //         "picture_url": "$images.picture_url"
    //     }
    // },
	// { 
    //     $sort: { "price": 1 }
    // }
	// ])
	public List<Document> getSearchResults(String country, int pax, double minPrice, double maxPrice) {

		Criteria criteria = Criteria.where("address.country").regex(country, "i")
									.and("accommodates").is(2)
									.and("price").gte(minPrice).lte(maxPrice);

		MatchOperation matchCriteria = Aggregation.match(criteria);

		ProjectionOperation projectFields = Aggregation
			.project("name", "price", "images.picture_url");
		
		SortOperation sortByPrice = Aggregation.sort(Sort.Direction.ASC, "price");

		Aggregation pipeline = Aggregation.newAggregation(matchCriteria, projectFields, sortByPrice);

		return mongoTemplate.aggregate(pipeline, "listings", Document.class).getMappedResults();
	}



	//TODO: Task 4
	

	//TODO: Task 5


}
