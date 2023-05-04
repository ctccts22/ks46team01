package ks46team01.common.company.info.util;
import ks46team01.common.company.info.dto.CompanyInfoDTO;
import ks46team01.common.company.info.entity.CompanyInfo;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class CompanyInfoConverter {
    public static CompanyInfoDTO entityToDto(CompanyInfo companyInfo) {
        CompanyInfoDTO companyInfoDto = new CompanyInfoDTO();
        try {
            BeanUtils.copyProperties(companyInfoDto, companyInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyInfoDto;
    }

    public static CompanyInfo dtoToEntity(CompanyInfoDTO companyInfoDto) {
        CompanyInfo companyInfo = new CompanyInfo();
        try {
            BeanUtils.copyProperties(companyInfo, companyInfoDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyInfo;
    }
}
