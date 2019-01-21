package com.hm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.User;
import com.hm.service.IUserRoleService;
import com.hm.service.IUserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hm
 * @since 2019-01-07
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService userService;
	@Autowired
	IUserRoleService UserRoleService;
	
	@GetMapping("/list")
	@ResponseBody
	public List<User> getAll(){
	 return	userService.getALLUserAndRole();
	}
	
	@GetMapping("/del/{id}")
	@ResponseBody
	public String delById(@PathVariable String id) {
		System.out.println(id);
		Integer id1 = Integer.valueOf(id);
		userService.removeById(id1);
		UserRoleService.removeById(id1);
		return "success";
	}
}
