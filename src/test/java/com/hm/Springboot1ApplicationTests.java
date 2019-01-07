package com.hm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hm.entity.Permission;
import com.hm.entity.Role;
import com.hm.entity.User;
import com.hm.service.IPermissionService;
import com.hm.service.IRoleService;
import com.hm.service.IUserService;
import com.hm.service.impl.PermissionServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot1ApplicationTests {
	@Autowired
	IUserService UserService;
	@Autowired
	IRoleService RoleService;
	@Autowired
	IPermissionService PermissionService;
	@Test
	public void contextLoads() {
		List<User> userList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			User user1 = User.builder().username("admin" + i).realname("a" + i).password("b" + i).tel("13261678796")
					.createTime(LocalDate.now()).status(1).build();
			userList.add(user1);
		}
		UserService.saveBatch(userList);

	}

	@Test
	public void saveRole() {
		List<Role> roleList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Role role = Role.builder().name("role" + i).build();
			roleList.add(role);
		}
		RoleService.saveBatch(roleList);
	}

	@Test
	public void savePermission() {
		List<Permission> permissionList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Permission permission = Permission.builder().name("p"+i).state(1).build();
			permissionList.add(permission);
		}
		PermissionService.saveBatch(permissionList);
	}
	@Test
	public void getALLUserAndRole() {
		System.out.println("11");
		List<User> list = UserService.getALLUserAndRole();
//		for (User user : list) {
//			System.out.println("id:" + user.getId());
//			List<Role> roles = user.getRoles();
//			for (Role role : roles) {
//				System.out.println("role:" + role.getName());
//			}
//		}
	}
}
