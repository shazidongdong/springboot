package com.hm.service.impl;

import com.hm.entity.User;
import com.hm.mapper.UserMapper;
import com.hm.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

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
	
	@Override
	public List<User> getALLUserAndRole() {
		List<User> allUserAndRole = getALLUserAndRole();
	 	return allUserAndRole;
	}

}
