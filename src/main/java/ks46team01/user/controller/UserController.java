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
import java.util.Optional;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    private final UserService userService;

    // UserController.java
    @GetMapping("/checkUsername")
    @ResponseBody
    public boolean checkUsername(@RequestParam("username") String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.isEmpty();
    }

    @GetMapping("/listUser")
    public String userList(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "user/listUser";
    }
    @GetMapping("/addUser")
    public String userAdd(Model model) {
        model.addAttribute("user", new User());
        return "user/addUser";
    }

    @PostMapping("/addUser")
    public String registerUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/";
    }


}

