package com.hm.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.Menu;
import com.hm.service.IUserService;
import com.hm.service.IloginService;
import com.hm.service.impl.UserServiceImpl;

@Controller
public class LoginController {
	@Autowired
	IloginService loginService;
	@Autowired
	IUserService UserService;

	@PostMapping("/shiro/login")
	public String shiroLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			 String salt="("+username+")";  
	         String md5Pwd=new Md5Hash(password,salt).toString();
	         //传递token给shiro的realm
	         UsernamePasswordToken token = new UsernamePasswordToken(username,md5Pwd); 
			//UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			System.out.println(password + "1111111" + username);
			token.setRememberMe(true);
			try {
				// 执行登录 该token传递至realm中
				currentUser.login(token);
				return "redirect:/list.html";
			} catch (AuthenticationException ae) {
				System.out.println("失败" + ae.getMessage());
			}
		}
		// 重定向public、static文件夹下的list.html
		//return "redirect:/list.html";
		 return "login";
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

	@GetMapping("/getMenu")
	@ResponseBody
	public List<Menu> getMenu() {
		List<Menu> list = UserService.findMenuById(1);
		System.out.println(list.toString());
		return list;
	}
}
