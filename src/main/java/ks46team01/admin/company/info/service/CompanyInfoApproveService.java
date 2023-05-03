package ks46team01.admin.company.info.service;

import ks46team01.admin.info.entity.Admin;
import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.common.company.info.entity.CompanyInfoApprove;
import ks46team01.common.company.info.repository.CompanyInfoApproveRepository;
import ks46team01.common.company.info.repository.CompanyInfoRepository;
import ks46team01.user.info.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CompanyInfoApproveService {
    private final CompanyInfoApproveRepository companyInfoApproveRepository;
    private final CompanyInfoRepository companyInfoRepository;

    public CompanyInfoApprove updateCompanyInfoApprove(Long companyInfoApproveIdx, LocalDate companyInfoApproveDate, String companyInfoApproveStatus, String companyInfoApproveContent, Admin admin, Long companyInfoIdx) {
        CompanyInfoApprove exCompanyInfoApprove;

        if (companyInfoApproveIdx != null) {
            Optional<CompanyInfoApprove> exCompanyInfoApproveOptional = companyInfoApproveRepository.findWithCompanyInfoAndAdminByUsername(companyInfoApproveIdx);

            if (exCompanyInfoApproveOptional.isPresent()) {
                exCompanyInfoApprove = exCompanyInfoApproveOptional.get();
            } else {
                exCompanyInfoApprove = new CompanyInfoApprove();
                exCompanyInfoApprove.setCompanyInfoApproveIdx(companyInfoApproveIdx);
            }
        } else {
            exCompanyInfoApprove = new CompanyInfoApprove();
        }

        Optional<CompanyInfo> companyInfoOptional = companyInfoRepository.findByCompanyInfoIdx(companyInfoIdx);
        if (companyInfoOptional.isPresent()) {
            CompanyInfo companyInfo = companyInfoOptional.get();

            // CompanyInfoApprove and CompanyInfo 사이 관계 설정
            exCompanyInfoApprove.setCompanyInfoIdx(companyInfo);
        } else {
            throw new RuntimeException("CompanyInfo not found with companyInfoIdx: " + companyInfoIdx);
        }

        exCompanyInfoApprove.setCompanyInfoApproveDate(Date.valueOf(companyInfoApproveDate));
        exCompanyInfoApprove.setCompanyInfoApproveStatus(companyInfoApproveStatus);
        exCompanyInfoApprove.setCompanyInfoApproveContent(companyInfoApproveContent);
        exCompanyInfoApprove.setAdminUsername(admin);

        return companyInfoApproveRepository.save(exCompanyInfoApprove);
    }
}


