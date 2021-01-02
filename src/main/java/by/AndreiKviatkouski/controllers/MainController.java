package by.AndreiKviatkouski.controllers;

import by.AndreiKviatkouski.entities.User;
import by.AndreiKviatkouski.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String index(@ModelAttribute("userForm") User userForm) {
        return "login";
    }

    @PostMapping()
    public String check(@ModelAttribute("userForm") @Valid User userForm,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        if (userService.check(userForm)) {
            System.out.println(true);
            return "users/user";
        }
        System.out.println(false);
        return "login";
    }
}
