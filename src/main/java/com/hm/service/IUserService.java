package com.hm.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hm.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hm
 * @since 2019-01-07
 */
public interface IUserService extends IService<User> {
	public List<User> getALLUserAndRole();
	
	public User findByName(String name); 
}
