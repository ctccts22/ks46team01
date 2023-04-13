//package ks46team01.common.security.config;
//
//import ks46team01.admin.entity.Admin;
//import ks46team01.admin.service.AdminService;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final AdminService adminService;
//
//    public UserDetailsServiceImpl(AdminService adminService) {
//        this.adminService = adminService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Admin> adminOptional = adminService.findByAdminUsername(username);
//        if (!adminOptional.isPresent()) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//
//        Admin admin = adminOptional.get();
//        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(admin.getRoleIdx().getRoleName().name()));
//
//        return new org.springframework.security.core.userdetails.User(admin.getAdminUsername(), admin.getAdminPassword(), authorities);
//    }
//}
