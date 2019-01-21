package com.hm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hm.service.IUserRoleService;
import com.hm.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Utest {
	@Autowired
	IUserService UserService;
	@Autowired
	IUserRoleService UserRoleService;
	
	@Test
	public void findmenuById() {
		UserService.findMenuById(1);
	}
	@Test
	public void delById() {
		Integer id =22;
		UserService.removeById(id);
		UserRoleService.removeById(id);
		System.out.println("sss");
	}
}
