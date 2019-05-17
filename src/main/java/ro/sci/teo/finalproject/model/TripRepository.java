package ro.sci.teo.finalproject.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Teo
 */
@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
    @Query(value="select * from trip where user_id=:value and deleted=false", nativeQuery = true)
    List<Trip> findTripsByUserId(@Param("value") int userId);

    @Query(value="select * from trip where trip_id=:value", nativeQuery = true)
    Trip findTripById(@Param("value") int tripId);
}
