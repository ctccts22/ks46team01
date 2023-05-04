package ks46team01.admin.info.dto;

import ks46team01.auth.dto.RoleDTO;
import lombok.*;

import java.sql.Timestamp;

@Data
public class AdminDTO {
    private String adminUsername;
    private String adminPassword;
    private String adminName;
    private Timestamp adminLogin;
    private Timestamp adminLogout;
    private RoleDTO role;
}