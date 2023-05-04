package ks46team01.auth.util;

import ks46team01.auth.dto.RoleDTO;
import ks46team01.auth.entity.Role;
import org.springframework.beans.BeanUtils;

public class RoleConverter {

    public static RoleDTO entityToDTO(Role role) {
        RoleDTO dto = new RoleDTO();
        BeanUtils.copyProperties(role, dto);
        return dto;
    }

    public static Role dtoToEntity(RoleDTO dto) {
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        return role;
    }
}
