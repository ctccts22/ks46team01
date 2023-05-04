package ks46team01.auth.dto;

import ks46team01.auth.entity.Role;
import lombok.Data;

@Data
public class RoleDTO {
    private Long roleIdx;
    private Role.RoleName roleName;
}