package ro.sci.teo.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.teo.finalproject.model.Trip;
import ro.sci.teo.finalproject.model.User;
import ro.sci.teo.finalproject.service.SecurityService;
import ro.sci.teo.finalproject.service.TripService;
import ro.sci.teo.finalproject.service.UserService;
import ro.sci.teo.finalproject.validator.TripValidator;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Teo
 */
@Controller
public class TripController {
    @Autowired
    TripValidator tripValidator;

    @Autowired
    UserService userService;

    @Autowired
    TripService tripService;

    @Autowired
    SecurityService securityService;

    @GetMapping("/new-trip")
    public String showNewTripForm(Model model) {
        model.addAttribute("trip", new Trip());

        return "new-trip";
    }

    @PostMapping("/new-trip")
    public String addTrip(@RequestParam("photoFile1") MultipartFile photoFile1,
                          @RequestParam("photoFile2") MultipartFile photoFile2,
                          @ModelAttribute("trip") @Valid Trip trip, BindingResult bindingResult) {
        tripValidator.validate(trip, bindingResult);

        if (bindingResult.hasErrors()) {
            return "new-trip";
        }

        try {
            tripService.saveImg(photoFile1);
            tripService.saveImg(photoFile2);
        } catch (Exception e) {
            e.printStackTrace();
            return "new-trip";
        }

        trip.setUser(userService.findByUsername(securityService.findLoggedInUsername()));
        trip.setPhoto1(photoFile1.getOriginalFilename());
        trip.setPhoto2(photoFile2.getOriginalFilename());
        tripService.saveTrip(trip);

        return "redirect:/trips";
    }

    @GetMapping("/trips")
    public ModelAndView showTrips(@RequestParam(name = "choice", required = false) Integer tripId) {
        User user = userService.findByUsername(securityService.findLoggedInUsername());
        List<Trip> trips = tripService.findTripsByUserId(user.getUserId());

        if (trips.isEmpty())
            return new ModelAndView("redirect:/new-trip");

        ModelAndView mv = new ModelAndView("trips");
        mv.addObject("trips", trips);

        if (tripId == null) {
            mv.addObject("trip", trips.get(0)); //first trip to appear on the page after login
        } else {
            Trip selectedTrip = new Trip();
            for (Trip trip : trips)
                if (trip.getTripId() == tripId)
                    selectedTrip = trip;
            mv.addObject("trip", selectedTrip);
        }

        return mv;
    }

    @GetMapping("/edit-trip/{id}")
    public ModelAndView showTrip(@PathVariable("id") int tripId) {
        ModelAndView mv = new ModelAndView("edit-trip");
        Trip tripToEdit = tripService.findTripById(tripId);
        mv.addObject("trip", tripToEdit);

        return mv;
    }

    @PostMapping("/edit-trip/{id}")
    public String updateTrip(@RequestParam("photoFile1") MultipartFile photoFile1,
                             @RequestParam("photoFile2") MultipartFile photoFile2,
                             @ModelAttribute("trip") @Valid Trip trip, BindingResult bindingResult) {
        tripValidator.validate(trip, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/edit-trip/{id}";
        }

        try {
            tripService.saveImg(photoFile1);
            tripService.saveImg(photoFile2);
        } catch (Exception e) {
            e.printStackTrace();
            return "/edit-trip/{id}";
        }

        trip.setUser(userService.findByUsername(securityService.findLoggedInUsername()));
        trip.setPhoto1(photoFile1.getOriginalFilename());
        trip.setPhoto2(photoFile2.getOriginalFilename());
        tripService.saveTrip(trip);

        return "/edit-trip/{id}";
    }

    @PostMapping("/delete")
    public String deleteTrip(@RequestParam(name = "id", required = false) int tripId) {
        Trip tripToDelete = tripService.findTripById(tripId);
        tripToDelete.setDeleted();
        tripService.saveTrip(tripToDelete);

        return "redirect:/trips";
    }
}
