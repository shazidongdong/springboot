package com.hm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.User;
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
	@GetMapping("/list")
	@ResponseBody
	public List<User> getAll(){
	 return	userService.getALLUserAndRole();
	}
}
