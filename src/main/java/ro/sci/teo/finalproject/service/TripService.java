package ro.sci.teo.finalproject.service;

import org.springframework.web.multipart.MultipartFile;
import ro.sci.teo.finalproject.model.Trip;

/**
 * @author Teo
 */
public interface TripService {
    void saveTrip(Trip trip);

    Trip findByName(String name);

    void saveImg(MultipartFile imageFile) throws Exception;
}
