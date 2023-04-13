//package ks46team01.common.security.handler;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import ks46team01.admin.entity.Admin;
//import ks46team01.admin.service.AdminService;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.util.Optional;
//
//@Component
//public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    private final AdminService adminService;
//
//    public CustomAuthenticationSuccessHandler(AdminService adminService) {
//        this.adminService = adminService;
//    }
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        String adminUsername = authentication.getName();
//        Optional<Admin> adminOptional = adminService.findByAdminUsername(adminUsername);
//
//        if (adminOptional.isPresent()) {
//            Admin admin = adminOptional.get();
//            admin.setAdminLogin(new Timestamp(System.currentTimeMillis()));
//            adminService.updateAdmin(admin); // Use updateAdmin method
//        }
//
//        response.sendRedirect("/"); // Redirect to the desired page after successful login
//    }
//}
