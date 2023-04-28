package ks46team01.user.info.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.auth.security.BcryptHashing;
import ks46team01.user.info.entity.User;
import ks46team01.user.info.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

        @PostMapping("/findPasswordUser")
        @ResponseBody
        public String sendTemporaryPassword(@RequestParam("username") String username,
                                            @RequestParam("email") String email) {
            log.info("임시 암호 보내기: {}, email: {}", username, email);
            try {
                userService.sendTemporaryPassword(username, email);
                return "success";
            } catch (Exception e) {
                log.error("임시 암호를 보내는 중 오류 발생: {}", e.getMessage());
                return e.getMessage();
            }
        }

        @GetMapping("/findPasswordUser")
        public String userPasswordFind() {
            log.info("비밀번호 찾기 사용자 페이지 표시");
            return "user/findPasswordUser";
        }

        @GetMapping("/modifyUser/{username}")
        public String showModifyUserForm(@PathVariable("username") String username, Model model) {
            log.info("아이디에 대한 사용자 양식 수정 표시: {}", username);
            Optional<User> userOptional = userService.getUserByUsername(username);
            if (userOptional.isPresent()) {
                model.addAttribute("user", userOptional.get());
                return "user/modifyUser";
            } else {
                log.warn("사용자 이름에 대한 사용자를 찾을 수 없습니다: {}", username);
                return "error"; // error message 404 view 사용예정
            }
        }

        @PostMapping("/modifyUser")
        public String modifyUser(@ModelAttribute("user") User user,
                                 BindingResult bindingResult, Model model) {
            log.info("회원수정: {}", user);
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
            log.info("아이디를 위한 비빌번호 검증: {}", username);
            Optional<User> existingUserOptional = userService.getUserByUsername(username);
            if (existingUserOptional.isPresent()) {
                User existingUser = existingUserOptional.get();
                if (BcryptHashing.verify(passwordCheck, existingUser.getPassword())) {
                    // 새 암호와 확인이 일치하는 경우 사용자 암호 업데이트
                    if (!newPassword.isEmpty() && newPassword.equals(newPasswordConfirm)) {
                        String hashedNewPassword = BcryptHashing.hash(newPassword);
                        existingUser.setPassword(hashedNewPassword);
                        userService.modifyUser(existingUser);
                    }
                    return "true";
                } else {
                    log.warn("사용자 이름에 대한 잘못된 암호 검사: {}", username);
                    return "false";
                }
            } else {
                log.warn("회원에 대한 아이디를 찾을 수 없습니다: {}", username);
                return "false";
            }
        }

        @GetMapping("/checkUsername")
        @ResponseBody
        public boolean checkUsername(@RequestParam("username") String username) {
            log.info("사용자 이름 확인 : {}", username);
            Optional<User> userOptional = userService.getUserByUsername(username);
            return userOptional.isEmpty();
        }

        @GetMapping("/profileUser")
        public String userProfile(HttpSession session, Model model) {
            User user = (User) session.getAttribute("user");
            log.info("사용자에 대한 사용자 프로필 표시: {}", user);
            if (user != null) {
                model.addAttribute("user", user);
                return "user/profileUser";
            } else {
                log.warn("세션에서 사용자를 찾을 수 없음");
                return "redirect:/auth/login";
            }
        }
    @GetMapping("/listUser")
    public String userList(Model model, @RequestParam(value = "username", required = false) String username) {
        log.info("사용자 이름 목록: {}", username);
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
            log.info("사용자 등록 양식 표시");
            model.addAttribute("title", "회원가입");
            model.addAttribute("users", new User());
            log.info("user={}", new User());
            return "user/addUser";
        }

        @PostMapping("/addUser")
        public String registerUser(@ModelAttribute User user) {
            log.info("새 사용자 등록: {}", user);
            userService.createUser(user);
            return "redirect:/";
        }

        @GetMapping("/deleteUser/{username}")
        public String showDeleteUserForm(@PathVariable("username") String username, Model model) {
            log.info("사용자 이름에 대한 삭제아이디 양식 표시: {}", username);
            Optional<User> userOptional = userService.getUserByUsername(username);
            if (userOptional.isPresent()) {
                model.addAttribute("user", userOptional.get());
                return "user/deleteUser";
            } else {
                log.warn("회원에 대한 아이디를 찾을 수 없습니다: {}", username);
                return "error"; // error message 404 view 사용예정
            }
        }

        @PostMapping("/deleteUser")
        public String deleteUser(@RequestParam("username") String username, HttpSession session) {
            log.info("사용자 이름에 대한 삭제아이디 양식 표시: {}", username);
            Optional<User> userOptional = userService.getUserByUsername(username);
            if (userOptional.isPresent()) {
                userService.deleteUser(username);
                session.invalidate();
                return "redirect:/";
            } else {
                log.warn("회원에 대한 아이디를 찾을 수 없습니다: {}", username);
                return "error"; // error message 404 view 사용예정
            }
        }

        @PostMapping("/validatePasswordForDelete")
        @ResponseBody
        public String validatePasswordForDelete(@RequestParam("username") String username,
                                                @RequestParam("password_check") String passwordCheck) {
            log.info("아이디 삭제 작업에 대한 암호 유효성을 검사: {}", username);
            Optional<User> existingUserOptional = userService.getUserByUsername(username);
            if (existingUserOptional.isPresent()) {
                User existingUser = existingUserOptional.get();
                if (BcryptHashing.verify(passwordCheck, existingUser.getPassword())) {
                    return "true";
                } else {
                    log.warn("사용자 이름에 대한 삭제 작업의 암호 검사가 잘못되었습니다: {}", username);
                    return "false";
                }
            } else {
                log.warn("회원에 대한 아이디를 찾을 수 없습니다: {}", username);
                return "false";
            }
        }
    }
