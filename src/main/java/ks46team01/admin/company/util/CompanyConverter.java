package ks46team01.admin.company.util;


import ks46team01.admin.company.dto.CompanyDTO;
import ks46team01.admin.company.entity.Company;
import ks46team01.admin.info.entity.Admin;
import org.springframework.beans.BeanUtils;
import ks46team01.admin.info.dto.AdminDTO;
import ks46team01.admin.info.util.AdminConverter;

public class CompanyConverter {

    public static CompanyDTO entityToDTO(Company company) {
        CompanyDTO dto = new CompanyDTO();
        BeanUtils.copyProperties(company, dto);
        // Convert Admin to AdminDTO
        AdminDTO adminDTO = AdminConverter.entityToDTO(company.getAdminUsername());
        dto.setAdminUsername(adminDTO);
        return dto;
    }

    public static Company dtoToEntity(CompanyDTO dto) {
        Company company = new Company();
        BeanUtils.copyProperties(dto, company);
        // Convert AdminDTO to Admin
        Admin admin = AdminConverter.dtoToEntity(dto.getAdminUsername());
        company.setAdminUsername(admin);
        return company;
    }
}

/**
 * 엔티티에서 dto로 컨버트
 * Company company = // obtain Company entity from repository
 * CompanyDTO dto = CompanyConverter.entityToDTO(company);
 *
 * dto에서 엔티티로 컨버트
 * CompanyDTO companyDTO = // get CompanyDTO from user input or other sources
 * Company convertedCompany = CompanyConverter.dtoToEntity(companyDTO);
 */