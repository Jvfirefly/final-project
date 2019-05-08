package ro.sci.teo.finalproject.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Teo
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
