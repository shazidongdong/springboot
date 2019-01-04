package com.hm.config;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

public class ShiroConfig {
	// 管理shiro生命周期
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
	@Bean("shiroRealm")
	@DependsOn("lifecycleBeanPostProcessor")
	public ShiroRealm shiroRealm() {
			ShiroRealm shiroRealm = new ShiroRealm();
			return shiroRealm;
	}
}
