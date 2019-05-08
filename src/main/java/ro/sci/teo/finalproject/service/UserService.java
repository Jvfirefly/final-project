package ro.sci.teo.finalproject.service;

import ro.sci.teo.finalproject.model.User;

/**
 * @author Teo
 */
public interface UserService {
    /**
     * Encrypts the user's password, sets the user roles and saves the
     * new user in the database using the UserRepository.
     *
     * @param user a new user
     */
    void saveUser(User user);

    User findByUsername(String username);
}
