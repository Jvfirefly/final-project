package ro.sci.teo.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.teo.finalproject.model.User;
import ro.sci.teo.finalproject.service.SecurityService;
import ro.sci.teo.finalproject.service.UserService;

import javax.validation.Valid;

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
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String registration(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        userService.saveUser(user);
        //securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String logIn(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/edit-profile")
    public ModelAndView showUser() {
        ModelAndView mv = new ModelAndView("edit-profile");
        mv.addObject("user", userService.findByUsername("teoenache"));
        return mv;
    }
}
