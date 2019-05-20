package ro.sci.teo.finalproject.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ro.sci.teo.finalproject.model.Trip;
import ro.sci.teo.finalproject.service.TripService;

/**
 * @author Teo
 */
public class TripValidator implements Validator {
    @Autowired
    TripService tripService;

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
        if (tripService.findTripByNameAndUserId(trip.getName(), trip.getUser().getUserId()) != null) {
            errors.rejectValue("name", "Duplicate.tripForm.name");
        }
    }
}
