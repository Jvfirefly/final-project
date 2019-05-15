package ro.sci.teo.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.sci.teo.finalproject.model.Trip;
import ro.sci.teo.finalproject.service.TripService;

import javax.validation.Valid;

/**
 * @author Teo
 */
@Controller
public class TripController {
    @Autowired
    TripService tripService;

    @GetMapping("/new-trip")
    public String showNewTripForm(Model model) {
        model.addAttribute("trip", new Trip());
        return "new-trip";
    }

    @PostMapping("/new-trip")
    public String addTrip(@RequestParam("photoFile1") MultipartFile photoFile1,
                          @RequestParam("photoFile2") MultipartFile photoFile2,
                          @ModelAttribute("trip") @Valid Trip trip, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-trip";
        }

        try{
            tripService.saveImg(photoFile1);
            tripService.saveImg(photoFile2);
        }catch(Exception e){
            e.printStackTrace();
            return "new-trip";
        }

        //trip.setUserId(2);
        trip.setPhoto1(photoFile1.getOriginalFilename());
        trip.setPhoto2(photoFile2.getOriginalFilename());
        tripService.saveTrip(trip);
        return "redirect:/login";
    }

    @GetMapping("/trips")
    public String showTrips() {
        //model.addAttribute("trip", new Trip());
        return "trips";
    }
}
