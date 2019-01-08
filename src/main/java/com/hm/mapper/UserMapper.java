package com.hm.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hm.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hm
 * @since 2019-01-07
 */
public interface UserMapper extends BaseMapper<User> {
	
	public List<User> getALLUserAndRole();
	
	public User findByName(String name); 
}
