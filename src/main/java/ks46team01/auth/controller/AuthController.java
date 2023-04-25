package ks46team01.auth.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks46team01.auth.security.BcryptHashing;
import ks46team01.user.info.entity.User;
import ks46team01.user.info.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    @GetMapping("/login")
    public String loginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        HttpServletResponse response,
                        Model model) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent() && BcryptHashing.verify(password, userOptional.get().getPassword())) {
            User user = userOptional.get();
            if (user.getIsDel().equals("Y")) {
                model.addAttribute("error", "This account has been deleted.");
                return "auth/login";
            }

            session.setAttribute("user", user);

            // Create a cookie
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24); // Set cookie expiration time to 24 hours
            cookie.setHttpOnly(true); // Prevent access to the cookie from JavaScript
            cookie.setPath("/"); // Set the path for the cookie

            // Add the cookie to the response
            response.addCookie(cookie);

            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid username or password.");
            return "auth/login";
        }
    }



    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}
