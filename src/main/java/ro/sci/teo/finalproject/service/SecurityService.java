package ro.sci.teo.finalproject.service;

/**
 * This interface was created to provide current logged-in user and auto login user after registration.
 *
 * @author Teo
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
