package ks46team01.admin.service;

import ks46team01.admin.entity.Admin;
import ks46team01.admin.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }
}

