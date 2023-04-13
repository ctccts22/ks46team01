package ks46team01.auth.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.admin.entity.Admin;
import ks46team01.admin.repository.AdminRepository;
import ks46team01.admin.service.AdminService;
import ks46team01.auth.entity.Role;
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
                        Model model) {
        Optional<Admin> adminUserOptional = adminRepository.findByAdminUsername(adminUsername);
        if (adminUserOptional.isPresent() && adminUserOptional.get().getAdminPassword().equals(adminPassword)) {
            Admin admin = adminUserOptional.get();
            admin.setAdminLogin(new Timestamp(System.currentTimeMillis()));
            adminService.updateAdmin(admin); // Update the login timestamp

            session.setAttribute("adminUser", admin);
            session.setAttribute("userRole", "ROLE_ADMIN");
            log.debug("UserRole: " + session.getAttribute("userRole"));
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
