package ks46team01.admin.controller;

import ks46team01.admin.entity.Admin;
import ks46team01.admin.repository.AdminRepository;
import ks46team01.auth.entity.Role;
import ks46team01.auth.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    private final AdminRepository adminRepository;
    private final RoleRepository roleRepository;

    public AdminController(AdminRepository adminRepository, RoleRepository roleRepository) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
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
    public String addAdmin(@ModelAttribute Admin admin) {
        Role adminRole = roleRepository.findByRoleName(Role.RoleName.ADMIN);
        admin.setRoleIdx(adminRole);
        adminRepository.save(admin);
        return "redirect:/admin/listAdmin";
    }

}


