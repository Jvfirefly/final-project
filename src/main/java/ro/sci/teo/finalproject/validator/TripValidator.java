package ro.sci.teo.finalproject.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ro.sci.teo.finalproject.model.Trip;
import ro.sci.teo.finalproject.model.User;
import ro.sci.teo.finalproject.service.SecurityService;
import ro.sci.teo.finalproject.service.TripService;
import ro.sci.teo.finalproject.service.UserService;

/**
 * @author Teo
 */
@Component
public class TripValidator implements Validator {
    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;

    @Autowired
    private SecurityService securityService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Trip.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Trip trip = (Trip) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (trip.getName().length() > 30) {
            errors.rejectValue("name", "Size.tripForm.name");
        }

        User user = userService.findByUsername(securityService.findLoggedInUsername());
        if (tripService.findTripByNameAndUserId(trip.getName(), user.getUserId()) != null) {
            errors.rejectValue("name", "Duplicate.tripForm.name");
        }
    }
}
