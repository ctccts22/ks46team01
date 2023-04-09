package ks46team01.admin.service;

import ks46team01.admin.entity.Admin;
import ks46team01.admin.repository.AdminRepository;
import ks46team01.auth.entity.Role;
import ks46team01.auth.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        admin.setRoleId(adminRole);
        adminRepository.save(admin);
    }


}

