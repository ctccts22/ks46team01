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
            cookie.setMaxAge(60 * 60 * 24); // Set cookie expiration time to 24 hours
            cookie.setHttpOnly(true); // Prevent access to the cookie from JavaScript
            cookie.setPath("/"); // Set the path for the cookie

            // Add the cookie to the response
            response.addCookie(cookie);

            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid username or password.");
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
