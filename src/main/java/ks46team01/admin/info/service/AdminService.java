package ks46team01.admin.info.service;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.info.repository.AdminRepository;
import ks46team01.auth.entity.Role;
import ks46team01.auth.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

    public Optional<Admin> findByAdminUsername(String adminUsername) {
        return adminRepository.findByAdminUsername(adminUsername);
    }

    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

}


