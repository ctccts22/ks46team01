package ks46team01.user.info.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.auth.security.BcryptHashing;
import ks46team01.user.info.entity.User;
import ks46team01.user.info.repository.UserRepository;
import ks46team01.user.info.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    private final UserService userService;


    @PostMapping("/findPasswordUser")
    @ResponseBody
    public String sendTemporaryPassword(@RequestParam("username") String username,
                                        @RequestParam("email") String email) {
        try {
            userService.sendTemporaryPassword(username, email);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @GetMapping("/findPasswordUser")
    public String userPasswordFind() {
        return "user/findPasswordUser";
    }


    @GetMapping("/modifyUser/{username}")
    public String showModifyUserForm(@PathVariable("username") String username, Model model) {
        Optional<User> userOptional = userService.getUserByUsername(username);
        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
            return "user/modifyUser";
        } else {
            return "error"; // error message 404 view 사용예정
        }
    }

    @PostMapping("/modifyUser")
    public String modifyUser(@ModelAttribute("user") User user,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "user/modifyUser";
        }

        userService.modifyUser(user);
        return "redirect:/";
    }


    @PostMapping("/validatePassword")
    @ResponseBody
    public String validatePassword(@RequestParam("username") String username,
                                   @RequestParam("password_check") String passwordCheck,
                                   @RequestParam("new_password") String newPassword,
                                   @RequestParam("new_password_confirm") String newPasswordConfirm) {
        Optional<User> existingUserOptional = userService.getUserByUsername(username);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            if (BcryptHashing.verify(passwordCheck, existingUser.getPassword())) {
                // If the new password and its confirmation match, update the user's password
                if (!newPassword.isEmpty() && newPassword.equals(newPasswordConfirm)) {
                    String hashedNewPassword = BcryptHashing.hash(newPassword);
                    existingUser.setPassword(hashedNewPassword);
                    userService.modifyUser(existingUser);
                }
                return "true";
            } else {
                return "false";
            }
        } else {
            return "false";
        }
    }
    // 중복체크 ajax
    @GetMapping("/checkUsername")
    @ResponseBody
    public boolean checkUsername(@RequestParam("username") String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.isEmpty();
    }

    @GetMapping("/profileUser")
    public String userProfile(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            return "user/profileUser";
        } else {
            return "redirect:/auth/login";
        }
    }


//    @GetMapping("/listUser")
//    public String userList(Model model) {
//        List<User> userList = userRepository.findAll();
//        model.addAttribute("title", "회원목록조회");
//        model.addAttribute("userList", userList);
//        log.info("userList = {}", userList);
//        return "user/listUser";
//    }

    @GetMapping("/listUser")
    public String userList(Model model, @RequestParam(value = "username", required = false) String username) {
        List<User> users;
        if (username != null && !username.isEmpty()) {
            Optional<User> userOptional = userService.getUserByUsername(username);
            users = userOptional.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            users = userService.getAllUsers();
        }
        model.addAttribute("userList", users);
        return "user/listUser";
    }


    @GetMapping("/addUser")
    public String userAdd(Model model) {
        model.addAttribute("title", "회원가입");
        model.addAttribute("user", new User());
        log.info("user={}",  new User());
        return "user/addUser";
    }

    @PostMapping("/addUser")
    public String registerUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/";
    }


}

