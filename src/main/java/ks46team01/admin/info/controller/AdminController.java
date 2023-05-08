package ks46team01.admin.info.controller;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.info.service.AdminService;
import ks46team01.user.info.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/listAdmin")
    public String adminList(Model model, @RequestParam(value = "adminUsername", required = false) String adminUsername) {
        log.info("adminUsername={}", adminUsername);
        List<Admin> adminList;
        if (adminUsername != null && !adminUsername.isEmpty()) {
            Optional<Admin> adminOptional = adminService.getAdminByAdminUsername(adminUsername);
            adminList = adminOptional.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            adminList = adminService.getAllAdmins();
        }
        model.addAttribute("adminList", adminList);
        log.info("adminList={}", adminList);
        return "admin/listAdmin";
    }


    @GetMapping("/addAdmin")
    public String showAddAdminForm(Model model) {
        model.addAttribute("admin", new Admin());
        log.info("관리자 추가 양식 표시");
        return "admin/addAdmin";
    }

    @PostMapping("/addAdmin")
    @ResponseBody
    public ResponseEntity<?> addAdmin(@ModelAttribute Admin admin, Model model) {
        adminService.addAdmin(admin);
        log.info("Admin: {}", admin);
        return ResponseEntity.ok().body("관리자가 성공적으로 등록되었습니다.");
    }

    @PostMapping("/modifyAdmin")
    public String modifyAdmin(@RequestParam("adminUsername") String adminUsername,
                             @RequestParam("adminPassword") String adminPassword,
                             @RequestParam("adminName") String adminName,
                             Model model) {
        Admin modifiedAdmin = adminService.modifyAdmin(adminUsername, adminPassword, adminName);

        if (modifiedAdmin == null) {
            model.addAttribute("에러", "실패했습니다.");
        } else {
            model.addAttribute("성공", "성공했습니다.");
        }
        return "redirect:/admin/listAdmin";
    }

    @PostMapping("/delete/{adminUsername}")
    @ResponseBody
    public ResponseEntity<String> deleteAdmin(@PathVariable String adminUsername) {
        try {
            adminService.deleteAdminByUsername(adminUsername);
            return new ResponseEntity<>("삭제성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("삭제에러", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}


