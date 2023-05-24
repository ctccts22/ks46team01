package ks46team01.common.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.admin.company.entity.Company;
import ks46team01.admin.company.repository.CompanyRepository;
import ks46team01.admin.info.entity.Admin;
import ks46team01.common.company.contract.entity.CompanyContractApprove;
import ks46team01.common.company.contract.repository.CompanyContractApproveRepository;
import ks46team01.common.company.info.repository.CompanyInfoRepository;
import ks46team01.user.info.entity.User;
import ks46team01.user.info.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class CommonController {

	private final CompanyInfoRepository companyInfoRepository;
	private final CompanyRepository companyRepository;

	private final CompanyContractApproveRepository companyContractApproveRepository;
	@GetMapping("/intro")
	public String introPage() {
		return "intro";
	}
	@GetMapping("/")
	public String mainPage(Model model) {
		Optional<Company> cafeCompany = companyRepository.findByCompanyIdx(1L);
		Optional<Company> farmCompany = companyRepository.findByCompanyIdx(2L);
		Optional<Company> wasteCompany = companyRepository.findByCompanyIdx(3L);

		long totalUsers = companyInfoRepository.count();

		long cafeUsers = cafeCompany.map(companyInfoRepository::countByCompanyIdx).orElse(0L);
		long farmUsers = farmCompany.map(companyInfoRepository::countByCompanyIdx).orElse(0L);
		long wasteUsers = wasteCompany.map(companyInfoRepository::countByCompanyIdx).orElse(0L);

		long contractAchievements = companyContractApproveRepository.countByCompanyContractApproveStatus("Y");

		model.addAttribute("totalUsers", totalUsers);
		model.addAttribute("cafeUsers", cafeUsers);
		model.addAttribute("farmUsers", farmUsers);
		model.addAttribute("wasteUsers", wasteUsers);
		model.addAttribute("contractAchievements", contractAchievements);

		return "main";
	}





	@GetMapping("/layout/default")
	public String yourMethodName(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			model.addAttribute("user", user);
		}

		Admin admin = (Admin) session.getAttribute("adminUser");
		if (admin != null) {
			model.addAttribute("admin", admin);
		}
		return "layout/default";
	}
	@ModelAttribute("user")
	public User getUser(HttpSession session) {
		User user = (User) session.getAttribute("user");
		return user;
	}

	@ModelAttribute("admin")
	public Admin getAdmin(HttpSession session) {
		Admin admin = (Admin) session.getAttribute("adminUser");
		return admin;
	}
}
