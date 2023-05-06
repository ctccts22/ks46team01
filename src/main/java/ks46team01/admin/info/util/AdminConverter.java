package ks46team01.admin.info.util;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.info.dto.AdminDTO;
import ks46team01.auth.dto.RoleDTO;
import ks46team01.auth.entity.Role;
import ks46team01.auth.util.RoleConverter;
import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;

public class AdminConverter {

    public static AdminDTO entityToDTO(Admin admin) {
        AdminDTO dto = new AdminDTO();
        BeanUtils.copyProperties(admin, dto);

        if (admin.getRoleIdx() != null) {
            Role role = Hibernate.unproxy(admin.getRoleIdx(), Role.class);
            RoleDTO roleDTO = RoleConverter.entityToDTO(role);
            dto.setRole(roleDTO);
        }

        return dto;
    }

    public static Admin dtoToEntity(AdminDTO dto) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(dto, admin);
        Role role = RoleConverter.dtoToEntity(dto.getRole());
        admin.setRoleIdx(role);

        return admin;
    }
}
