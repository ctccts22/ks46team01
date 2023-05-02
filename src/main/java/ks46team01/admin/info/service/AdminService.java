package ks46team01.admin.info.service;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.info.repository.AdminRepository;
import ks46team01.auth.entity.Role;
import ks46team01.auth.repository.RoleRepository;
import ks46team01.user.info.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminService {

    private final AdminRepository adminRepository;
    private final RoleRepository roleRepository;

    public AdminService(AdminRepository adminRepository, RoleRepository roleRepository) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public void addAdmin(Admin admin) {
        Role adminRole = roleRepository.findByRoleName(Role.RoleName.ADMIN);
        admin.setRoleIdx(adminRole);
        adminRepository.save(admin);
    }

    public Optional<Admin> getAdminByAdminUsername(String adminUsername) {
        return adminRepository.findByAdminUsername(adminUsername);
    }

    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdminByUsername(String adminUsername) {
        adminRepository.deleteById(adminUsername);
    }

    public Admin modifyAdmin(String adminUsername, String adminPassword, String adminName) {
        Optional<Admin> existingAdminOptional = adminRepository.findByAdminUsername(adminUsername);

        if (existingAdminOptional.isPresent()) {
            Admin existingAdmin = existingAdminOptional.get();
            existingAdmin.setAdminUsername(adminUsername);
            existingAdmin.setAdminPassword(adminPassword);
            existingAdmin.setAdminName(adminName);
            return adminRepository.save(existingAdmin);

        } else {
            throw new RuntimeException("Admin not found with the given username: " + adminUsername);
        }
    }
}


