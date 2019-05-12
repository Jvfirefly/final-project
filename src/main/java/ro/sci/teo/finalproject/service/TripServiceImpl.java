package ro.sci.teo.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ro.sci.teo.finalproject.model.Trip;
import ro.sci.teo.finalproject.model.TripRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    public Trip findByName(String name) {
        return tripRepository.findByName(name);
    }

    @Override
    public void saveImg(MultipartFile imageFile) throws Exception {
        String directory = "/photos/";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(directory + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }
}
