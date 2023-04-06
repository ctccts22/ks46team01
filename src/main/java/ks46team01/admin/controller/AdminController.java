package ks46team01.admin.controller;

import ks46team01.admin.entity.Admin;
import ks46team01.admin.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("/listAdmin")
    public String adminList(Model model) {
        List<Admin> adminList = adminRepository.findAll();
        model.addAttribute("adminList", adminList);
        return "admin/listAdmin";
    }

    @GetMapping("/addAdmin")
    public String showAddAdminForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin/addAdmin";
    }

    @PostMapping("/addAdmin")
    public String addAdmin(@ModelAttribute Admin admin, RedirectAttributes redirectAttributes) {
        adminRepository.save(admin);
        redirectAttributes.addFlashAttribute("message", "Admin added successfully");
        return "redirect:/admin/listAdmin";
    }

    @PostMapping("/updateAdmin")
    public ResponseEntity<String> updateAdmin(@RequestBody Admin admin) {
        adminRepository.save(admin);
        return ResponseEntity.ok("Admin updated successfully");
    }

    @DeleteMapping("/deleteAdmin/{adminUsername}")
    public ResponseEntity<String> deleteAdmin(@PathVariable("adminUsername") String adminUsername) {
        Optional<Admin> optionalAdmin = adminRepository.findByAdminUsername(adminUsername);
        if (optionalAdmin.isPresent()) {
            adminRepository.delete(optionalAdmin.get());
            return ResponseEntity.ok("Admin deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


