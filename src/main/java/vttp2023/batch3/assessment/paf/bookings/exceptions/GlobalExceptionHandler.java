package vttp2023.batch3.assessment.paf.bookings.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler({ListingNotAvailableException.class})
    public String handleListingNotAvailable(ListingNotAvailableException ex, Model model, HttpSession session) {

        System.out.println(ex.getMessage());
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("country", session.getAttribute("country"));
		model.addAttribute("pax", session.getAttribute("pax"));
		model.addAttribute("minPrice", session.getAttribute("minPrice"));
		model.addAttribute("maxPrice", session.getAttribute("maxPrice"));
        return "error";

    }
}
