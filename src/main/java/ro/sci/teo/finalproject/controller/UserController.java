package ro.sci.teo.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sci.teo.finalproject.model.User;
import ro.sci.teo.finalproject.service.SecurityService;
import ro.sci.teo.finalproject.service.UserService;

/**
 * @author Teo
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("userForm", new User());

        return "main";
    }
}
