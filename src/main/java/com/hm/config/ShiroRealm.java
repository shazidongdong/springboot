package com.hm.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hm.entity.User;
import com.hm.service.IUserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ShiroRealm  extends AuthorizingRealm{
	@Autowired
	 IUserService UserService;
	/**
	 * 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Object user = principals.getPrimaryPrincipal();
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken= (UsernamePasswordToken)token;
		String username = upToken.getUsername();
		log.info("验证当前Subject时获取到token为：" + token.toString());
		User user = UserService.findByName(username);
		if(user !=null) {
			
		}
		return null;
	}

}
