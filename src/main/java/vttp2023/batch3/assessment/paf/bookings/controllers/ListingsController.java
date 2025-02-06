package vttp2023.batch3.assessment.paf.bookings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import vttp2023.batch3.assessment.paf.bookings.models.Form;
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
	public String search(@Valid @ModelAttribute Form form, BindingResult result, Model model){
		
		if (result.hasErrors() || (form.getMinPrice() > form.getMaxPrice())){

			if (form.getMinPrice() > form.getMaxPrice()){
				model.addAttribute("invalidMaxPrice", "Max price must be greater than min price");
			}

			List<String> countries = listingsService.getCountries();
			model.addAttribute("countries", countries);
			model.addAttribute("form", form);

			return "landingPage";
		}

		return null;
	}

	//TODO: Task 3


	//TODO: Task 4
	

	//TODO: Task 5


}
