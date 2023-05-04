package ks46team01.admin.company.dto;

import ks46team01.admin.company.unit.entity.CompanyUnit;
import ks46team01.admin.info.dto.AdminDTO;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
public class CompanyDTO {
        private Long companyIdx;
        private String companyType;
        private AdminDTO adminUsername;
        private Timestamp companyDate;

        private List<CompanyUnit> companyUnits;

    }
