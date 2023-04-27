package ks46team01.auth.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.info.repository.AdminRepository;
import ks46team01.admin.info.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Optional;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthAdminController {

    private final AdminRepository adminRepository;
    private final AdminService adminService; // Inject AdminService


    @GetMapping("/loginAdmin")
    public String loginForm() {
        return "auth/loginAdmin";
    }

    @PostMapping("/loginAdmin")
    public String login(@RequestParam("username") String adminUsername,
                        @RequestParam("password") String adminPassword,
                        HttpSession session,
                        HttpServletResponse response,
                        Model model) {
        Optional<Admin> adminUserOptional = adminRepository.findByAdminUsername(adminUsername);
        if (adminUserOptional.isPresent() && adminUserOptional.get().getAdminPassword().equals(adminPassword)) {
            Admin admin = adminUserOptional.get();
            admin.setAdminLogin(new Timestamp(System.currentTimeMillis()));
            adminService.updateAdmin(admin); // Update the login timestamp

            session.setAttribute("adminUser", admin);
            session.setAttribute("userRole", "ROLE_ADMIN");
            log.debug("UserRole: " + session.getAttribute("userRole"));

            // Create a cookie
            Cookie cookie = new Cookie("adminUsername", adminUsername);
            cookie.setMaxAge(60 * 60 * 24); // 쿠키 만료 시간을 24시간으로 설정
            cookie.setHttpOnly(true); // JavaScript에서 쿠키에 대한 액세스 금지
            cookie.setPath("/"); // 쿠키 경로 설정

            // 응답에 쿠키 추가
            response.addCookie(cookie);

            return "redirect:/";
        } else {
            model.addAttribute("error", "로그인에 실패했습니다.");
            return "auth/loginAdmin";
        }
    }

    @GetMapping("/logoutAdmin")
    public String logout(HttpSession session) {
        // Retrieve the admin user from the session
        Admin admin = (Admin) session.getAttribute("adminUser");
        if (admin != null) {
            admin.setAdminLogout(new Timestamp(System.currentTimeMillis()));
            adminService.updateAdmin(admin); // Update the logout timestamp
        }

        session.invalidate();
        return "redirect:/auth/loginAdmin";
    }
}
