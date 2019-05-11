package ro.sci.teo.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.teo.finalproject.model.Trip;
import ro.sci.teo.finalproject.model.TripRepository;

/**
 * @author Teo
 */
@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;

    @Override
    public void saveTrip(Trip trip) {
        tripRepository.save(trip);
    }
}
