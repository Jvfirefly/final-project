package ro.sci.teo.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.teo.finalproject.model.User;
import ro.sci.teo.finalproject.service.SecurityService;
import ro.sci.teo.finalproject.service.UserService;
import ro.sci.teo.finalproject.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author Teo
 */
@Controller
public class UserController {
    @Autowired
    private UserValidator userValidator;

    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @GetMapping("/signup")
    public String showSignUp(Model model) {
        model.addAttribute("user", new User());

        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "signup";
        }
        userService.saveUser(user);
        securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());

        return "redirect:/trips";
    }

    @GetMapping("/login")
    public String logIn() {
        return "login";
    }

    @GetMapping("/edit-profile")
    public ModelAndView showUser() {
        ModelAndView mv = new ModelAndView("edit-profile");
        String loggedInUsername = securityService.findLoggedInUsername();
        User user = userService.findByUsername(loggedInUsername);
        mv.addObject("user", user);

        return mv;
    }

    @PostMapping("/edit-profile")
    public String updateUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/edit-profile";
        }
        userService.saveUser(user);

        return "edit-profile";
    }

    @GetMapping("/logout")
    public String logOut (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login?logout";
    }
}
