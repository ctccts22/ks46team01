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
                model.addAttribute("error", "존재하지 않는 회원입니다.");
                return "auth/login";
            }

            session.setAttribute("user", user);

            // Create a cookie
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24); // 쿠키 만료 시간을 24시간으로 설정
            cookie.setHttpOnly(true); // JavaScript에서 쿠키에 대한 액세스 금지
            cookie.setPath("/"); // 쿠키 경로 설정

            // 응답에 쿠키 추가
            response.addCookie(cookie);

            return "redirect:/";
        } else {
            model.addAttribute("error", "로그인에 실패했습니다.");
            return "auth/login";
        }
    }



    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}
