package com.hm.config;

import java.util.LinkedHashMap;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

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
//      realm.setCredentialsMatcher(hashedCredentialsMatcher());
		return shiroRealm;
	}
//	  处理认证匹配处理器：如果自定义需要实现继承HashedCredentialsMatcher
//    指定加密方式方式，也可以在这里加入缓存，当用户超过五次登陆错误就锁定该用户禁止不断尝试登陆
//    @Bean(name = "hashedCredentialsMatcher")
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
//        credentialsMatcher.setHashAlgorithmName("MD5");
//        credentialsMatcher.setHashIterations(2);
//        credentialsMatcher.setStoredCredentialsHexEncoded(true);
//        return credentialsMatcher;
//    }

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
		filterChainDefinitionManager.put("/logout", "logout");
		filterChainDefinitionManager.put("/user/**", "authc,roles[user]");
		filterChainDefinitionManager.put("/admin/**", "authc,roles[role0]");//authc 必须认证后访问
		filterChainDefinitionManager.put("/login", "anon");
		filterChainDefinitionManager.put("/getMenu", "anon");
		filterChainDefinitionManager.put("/shiro/login", "anon");
		filterChainDefinitionManager.put("/statistic/**", "anon");// 静态资源不拦截
		filterChainDefinitionManager.put("/**", "authc,roles[user]");// 其他资源全部拦截
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
//		shiroFilterFactoryBean.setLoginUrl("/login");
//		shiroFilterFactoryBean.setSuccessUrl("/list");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/login");
        return shiroFilterFactoryBean;
	}
	   @Bean
	    @ConditionalOnMissingBean
	    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
	        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
	        daap.setProxyTargetClass(true);
	        return daap;
	    }

	    @Bean
	    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
	        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
	        aasa.setSecurityManager(securityManager);
	        return aasa;
	    }

	
	 //thymeleaf模板引擎和shiro整合时使用
    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

	
}
