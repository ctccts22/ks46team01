package ks46team01.user.controller;

import ks46team01.user.entity.User;
import ks46team01.user.repository.UserRepository;
import ks46team01.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    private final UserService userService;


    @GetMapping("/listUser")
    public String userList(Model model) {
        List<User> listUser = userRepository.findAll();
        model.addAttribute("listUser", listUser);
        return "user/listUser";
    }
    @GetMapping("/addUser")
    public String userAdd(Model model) {
        model.addAttribute("user", new User());
        return "user/addUser";
    }

    @PostMapping("/addUser")
    public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        userService.createUser(user);
        redirectAttributes.addFlashAttribute("message", "User registered successfully!");
        return "redirect:/user/listUser";
    }
}

