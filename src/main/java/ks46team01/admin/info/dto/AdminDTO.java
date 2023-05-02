package ks46team01.admin.info.dto;

import java.sql.Timestamp;
import java.util.List;

import ks46team01.admin.company.entity.Company;
import ks46team01.admin.inventory.entity.Inventory;
import ks46team01.auth.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {

    private String adminUsername;

    private String adminPassword;

    private Role roleIdx;

    private String adminName;

    private Timestamp adminLogin;

    private Timestamp adminLogout;

    private List<Company> companies;

    private List<Inventory> inventories;

}
