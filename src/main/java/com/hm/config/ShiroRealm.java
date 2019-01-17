package com.hm.config;

import java.util.HashSet;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hm.entity.Role;
import com.hm.entity.User;
import com.hm.service.IUserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ShiroRealm  extends AuthorizingRealm{
	@Autowired
	 IUserService UserService;
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取登录用户信息
		User user = (User) principals.getPrimaryPrincipal();
		System.out.println(user.toString());
		//利用登录用户获取所有权限
		List<Role> roles = user.getRoles();
		HashSet<String> rolesSet = new HashSet<>();
		for (Role role : roles) {
			rolesSet.add(role.getName());
			log.info(role.getName());
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(rolesSet) ;
		return info;
	}
	/**
	 * 认证
	 */
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
			throw new UnknownAccountException("输入错误");
		}
		//根据用户情况，来构建AuthenticationInfo对象并返回，一般实现类SimpleAuthenticationInfo
		//认证实体信息，username或者对应用户实体对象 -----授权时获取当前对象
		Object principal = user;
		//密码
		Object credentials = user.getPassword();
		//当前realm对象的name调用父类getName()即可
		String realmName = getName();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
		//credentialsSalt 添加盐值唯一字符窜或者username
		//info = new SimpleAuthenticationInfo(principal, hashedCredentials, credentialsSalt, realmName)
		return info;
	}

}
