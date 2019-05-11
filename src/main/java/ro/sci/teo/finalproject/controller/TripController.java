package ro.sci.teo.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sci.teo.finalproject.model.Trip;
import ro.sci.teo.finalproject.service.SecurityService;
import ro.sci.teo.finalproject.service.TripService;

import javax.validation.Valid;

/**
 * @author Teo
 */
@Controller
public class TripController {
    @Autowired
    TripService tripService;

    @Autowired
    SecurityService securityService; //to verify session

    @GetMapping("/new-trip")
    public String showNewTripForm(Model model) {
        model.addAttribute("trip", new Trip());
        return "new-trip";
    }

    @PostMapping("/new-trip")
    public String addTrip(@Valid Trip trip, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-trip";
        }
        trip.setUserId(1);
        tripService.saveTrip(trip);
        return "redirect:/login";
    }
}
