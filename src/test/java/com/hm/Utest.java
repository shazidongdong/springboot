package com.hm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hm.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Utest {
	@Autowired
	IUserService UserService;
	@Test
	public void findmenuById() {
		UserService.findMenuById(1);
	}
}
