package vttp2023.batch3.assessment.paf.bookings.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vttp2023.batch3.assessment.paf.bookings.models.Form;
import vttp2023.batch3.assessment.paf.bookings.models.Listing;
import vttp2023.batch3.assessment.paf.bookings.models.ListingDetails;
import vttp2023.batch3.assessment.paf.bookings.services.ListingsService;

@Controller
@RequestMapping("")
public class ListingsController {

	@Autowired
	ListingsService listingsService;


	@GetMapping("")
	public String landingPage(Model model){
		
		List<String> countries = listingsService.getCountries();
		Form form = new Form();
			form.setCountry("");

		model.addAttribute("form", form);
		model.addAttribute("countries", countries);
		
		return "landingPage";
	}
	
	@GetMapping("/search")
	public String search(@Valid @ModelAttribute Form form, BindingResult result, Model model, HttpSession session){
		
		if (result.hasErrors() || (form.getMinPrice() > form.getMaxPrice())){

			if (form.getMinPrice() > form.getMaxPrice()){
				model.addAttribute("invalidMaxPrice", "Max price must be greater than min price");
			}

			List<String> countries = listingsService.getCountries();
			model.addAttribute("countries", countries);
			model.addAttribute("form", form);

			return "landingPage";
		}

		session.setAttribute("country", form.getCountry());
		session.setAttribute("pax", form.getPax());
		session.setAttribute("minPrice", form.getMinPrice());
		session.setAttribute("maxPrice", form.getMaxPrice());

		List<Listing> listings = listingsService.getSearchResults(form.getCountry(), form.getPax(), form.getMinPrice(), form.getMaxPrice());
		model.addAttribute("country", form.getCountry());
		model.addAttribute("listings", listings);
		
		
		return "resultsPage";
	}


	@GetMapping("/listing/{id}")
	public String listingDetails(@PathVariable String id, Model model, HttpSession session){

		Optional<ListingDetails> opt = listingsService.getListingDetails(id);

		if (opt.isEmpty()){
			model.addAttribute("listingId", id);
			model.addAttribute("country", session.getAttribute("country"));
			model.addAttribute("pax", session.getAttribute("pax"));
			model.addAttribute("minPrice", session.getAttribute("minPrice"));
			model.addAttribute("maxPrice", session.getAttribute("maxPrice"));
			return "listingNotFound";
		}

		model.addAttribute("listingDetails", opt.get());
		model.addAttribute("country", session.getAttribute("country"));
		model.addAttribute("pax", session.getAttribute("pax"));
		model.addAttribute("minPrice", session.getAttribute("minPrice"));
		model.addAttribute("maxPrice", session.getAttribute("maxPrice"));

		return "listingDetails";
	}


}
