package com.hm.config;

import java.util.LinkedHashMap;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ShiroConfig {
	// 管理shiro生命周期,调用ioc中shiro bean的生命周期方法
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean(name = "shiroRealm")
	@DependsOn("lifecycleBeanPostProcessor")
	public ShiroRealm shiroRealm() {
		ShiroRealm shiroRealm = new ShiroRealm();
		return shiroRealm;
	}

	@Bean(name = "cacheManager")
	@DependsOn("lifecycleBeanPostProcessor")
	public EhCacheManager cacheManager() {
		EhCacheManager ehCacheManager = new EhCacheManager();
		return ehCacheManager;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(shiroRealm());
		securityManager.setCacheManager(cacheManager());// 用户授权认证信息cache
		return securityManager;
	}

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		LinkedHashMap<String, String> filterChainDefinitionManager = new LinkedHashMap<>();
//		filterChainDefinitionManager.put("/user/**", "authc,roles[user]");
//		filterChainDefinitionManager.put("/admin/**", "authc,roles[admin]");//authc 必须认证后访问
		filterChainDefinitionManager.put("/login", "anon");
		filterChainDefinitionManager.put("/shiro/login", "anon");
		filterChainDefinitionManager.put("/shiro/logout", "logout");
		filterChainDefinitionManager.put("/statistic/**", "anon");// 静态资源不拦截
		filterChainDefinitionManager.put("/**", "authc,roles[user]");// 其他资源全部拦截
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
//		shiroFilterFactoryBean.setLoginUrl("/login");
//		shiroFilterFactoryBean.setSuccessUrl("/");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        return shiroFilterFactoryBean;
	}
	
}
