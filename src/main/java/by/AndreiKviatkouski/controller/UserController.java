package by.AndreiKviatkouski.controller;

import by.AndreiKviatkouski.entity.Status;
import by.AndreiKviatkouski.entity.User;
import by.AndreiKviatkouski.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "user";
    }

    @PostMapping("/user")
    public String updateStatusUser( Long userId, Status status, String action,Model model) {
        if (action.equals("go")) {
            model.addAttribute("status",status);
            userService.updateStatusUser(status, userId);
        }

        return "redirect:/user";
    }

    @GetMapping("/user/{userId}")
    public String getUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.userList(userId));
        return "view";
    }


    @PutMapping("/user/{userId}/edit")
    public String editUser(@PathVariable("userId") Status status, User userForm, Long userId, Model model) {
        model.addAttribute("allUsers", userService.userList(userId));
        model.addAttribute("status", status);
        return "edit";
    }


    @GetMapping("/user/new")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "new";
    }

    @PostMapping("/user/new")
    public String addUser(Model model) {
        return "new";
    }
}
