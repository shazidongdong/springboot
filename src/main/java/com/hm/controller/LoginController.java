package com.hm.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hm.service.IloginService;

@Controller
public class LoginController {
	@Autowired
	IloginService loginService;

	@PostMapping("/shiro/login")
	public String shiroLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			try {
				// 执行登录
				currentUser.login(token);
			} catch (AuthenticationException ae) {
				System.out.println("失败" + ae.getMessage());
			}
		}

		return "redirect:/list.html";
		// return "list";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/admin/date")
	public String date() {
		System.out.println("1111111111");
		loginService.date();
		return "redirect:/list.html";
	}
}
