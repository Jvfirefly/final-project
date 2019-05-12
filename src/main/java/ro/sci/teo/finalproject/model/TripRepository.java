package ro.sci.teo.finalproject.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Teo
 */
public interface TripRepository extends JpaRepository<Trip, Integer> {
    Trip findByName(String name);
}
