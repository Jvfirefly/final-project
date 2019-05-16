package ro.sci.teo.finalproject.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Teo
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
