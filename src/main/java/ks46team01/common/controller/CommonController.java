package ks46team01.common.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.admin.info.entity.Admin;
import ks46team01.user.info.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CommonController {

	@GetMapping("/intro")
	public String introPage() {
		return "intro";
	}
	@GetMapping("/")
	public String mainPage() {
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
