package ro.sci.teo.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
    public String addTrip(@RequestParam("photo1") MultipartFile imageFile1,
                          @RequestParam("photo2") MultipartFile imageFile2,
                          @ModelAttribute("trip") @Valid Trip trip, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-trip";
        }

        try{
            tripService.saveImg(imageFile1);
            tripService.saveImg(imageFile2);
        }catch(Exception e){
            e.printStackTrace();
            return "new-trip";
        }

        trip.setUserId(2);
        trip.setPhoto1(imageFile1.getOriginalFilename());
        trip.setPhoto2(imageFile2.getOriginalFilename());
        tripService.saveTrip(trip);
        return "redirect:/login";
    }
}
