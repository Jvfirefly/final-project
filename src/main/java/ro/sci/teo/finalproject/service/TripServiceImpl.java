package ro.sci.teo.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ro.sci.teo.finalproject.model.Trip;
import ro.sci.teo.finalproject.model.TripRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

    @Override
    public void saveImg(MultipartFile imageFile) throws Exception {
        String directory = System.getProperty("user.dir") + "/src/main/resources/static/photos/";
        byte[] bytes = imageFile.getBytes();
        Path pathAndFileName = Paths.get(directory, imageFile.getOriginalFilename());
        Files.write(pathAndFileName, bytes);
    }

    @Override
    public List<Trip> findTripsByUserId(int userId) {
        return tripRepository.findTripsByUserId(userId);
    }

    @Override
    public Trip findTripById(int tripId) {
        return tripRepository.findTripById(tripId);
    }

    @Override
    public Trip findTripByNameAndUserId(String name, int userId) {
        return tripRepository.findTripByNameAndUserId(name, userId);
    }
}
