package com.hm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hm.entity.Menu;
import com.hm.entity.User;
import com.hm.mapper.UserMapper;
import com.hm.service.IUserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hm
 * @since 2019-01-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<User> getALLUserAndRole() {
		List<User> allUserAndRole = userMapper.getALLUserAndRole();
	 	return allUserAndRole;
	}

	@Override
	public User findByName(String name) {
		return userMapper.findByName(name);
		
	}

	@Override
	public List<Menu> findMenuById(Integer id) {
		List<Menu> list = userMapper.findMenuById(id);
		return list;
	}

}
