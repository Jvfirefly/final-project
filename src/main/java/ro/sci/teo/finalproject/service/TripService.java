package ro.sci.teo.finalproject.service;

import org.springframework.web.multipart.MultipartFile;
import ro.sci.teo.finalproject.model.Trip;

import java.util.List;

/**
 * @author Teo
 */
public interface TripService {
    void saveTrip(Trip trip);

    void saveImg(MultipartFile imageFile) throws Exception;

    List<Trip> findTripsByUserId(int userId);
}
