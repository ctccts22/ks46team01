package ks46team01.admin.company.info.service;

import ks46team01.common.company.info.dto.CompanyInfoDTO;
import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.common.company.info.repository.CompanyInfoRepository;
import ks46team01.user.info.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CompanyInfoService {
    private final CompanyInfoRepository companyInfoRepository;

    public CompanyInfoDTO updateCompanyInfo(Long companyInfoIdx, String companyInfoName, String companyInfoLicenseNumber, String companyInfoAddress, String companyInfoIsDel, LocalDateTime companyInfoIsDelDate) {
        Optional<CompanyInfo> existingCompanyInfoOptional = companyInfoRepository.findByCompanyInfoIdx(companyInfoIdx);

        if (existingCompanyInfoOptional.isPresent()) {
            CompanyInfo existingCompanyInfo = existingCompanyInfoOptional.get();
            existingCompanyInfo.setCompanyInfoIdx(companyInfoIdx);
            existingCompanyInfo.setCompanyInfoName(companyInfoName);
            existingCompanyInfo.setCompanyInfoLicenseNumber(companyInfoLicenseNumber);
            existingCompanyInfo.setCompanyInfoAddress(companyInfoAddress);
            existingCompanyInfo.setCompanyInfoIsDel(companyInfoIsDel);
            existingCompanyInfo.setCompanyInfoIsDelDate(companyInfoIsDelDate != null ? Timestamp.valueOf(companyInfoIsDelDate) : null);
            //수정날짜 업데이트
            existingCompanyInfo.setCompanyInfoUpdate(new Timestamp(System.currentTimeMillis()));
            CompanyInfo updatedCompanyInfo = companyInfoRepository.save(existingCompanyInfo);
            return CompanyInfoDTO.fromEntity(updatedCompanyInfo);
        } else {
            throw new RuntimeException();
        }
    }
}

