package com.hm.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
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
		//AuthenticationToken转换为UsernamePasswordToken   token controller中获取表单保存
		UsernamePasswordToken upToken= (UsernamePasswordToken)token;
		String username = upToken.getUsername();
		System.out.println(username+"--------------------------------");
		log.info("验证当前Subject时获取到token为：" + token.toString());
		User user = UserService.findByName(username);
		//抛出异常
		if(user ==null) {
			throw new UnknownAccountException("用户不存在");
		}
		if(!upToken.getPassword().equals(user.getPassword())) {
			
		}
		//根据用户情况，来构建AuthenticationInfo对象并返回，一般实现类SimpleAuthenticationInfo
		//认证实体信息，username或者对应用户实体对象
		Object principal = user.getUsername();
		//密码
		Object credentials = user.getPassword();
		//当前realm对象的name调用父类getName()即可
		String realmName = getName();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
		return info;
	}

}
