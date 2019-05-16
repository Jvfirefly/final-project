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
    Trip findByName(String name);

    @Query(value="select * from trip where user_id=:value", nativeQuery = true)
    List<Trip> findTripsByUserId(@Param("value") int userId);
}
