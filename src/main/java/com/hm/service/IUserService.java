package com.hm.service;

import com.hm.entity.User;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

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
}
