package com.hm.service.impl;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

import com.hm.service.IloginService;
@Service
public class LoginServiceImpl implements IloginService {
		@RequiresRoles({"role0"})
		public void date() {
			System.out.println(new Date()+"time");
		}
}
