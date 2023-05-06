package ks46team01.admin.company.dto;

import ks46team01.admin.company.entity.Company;
import ks46team01.admin.company.unit.entity.CompanyUnit;
import ks46team01.admin.info.dto.AdminDTO;
import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.info.repository.AdminRepository;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CompanyDTO {
        private Long companyIdx;
        private String companyType;
        private String adminUsername;
        private Timestamp companyDate;

        private List<CompanyUnit> companyUnits;

        public Company toEntity(AdminRepository adminRepository) {
                Company company = new Company();
                BeanUtils.copyProperties(this, company);

                Optional<Admin> admin = adminRepository.findByAdminUsername(this.adminUsername);
                admin.ifPresent(company::setAdminUsername);

                return company;
        }
        public static CompanyDTO fromEntity(Company company, AdminRepository adminRepository) {
                CompanyDTO companyDTO = new CompanyDTO();
                BeanUtils.copyProperties(company, companyDTO);
                companyDTO.setAdminUsername(company.getAdminUsername().getAdminUsername());
                return companyDTO;
        }

    }
