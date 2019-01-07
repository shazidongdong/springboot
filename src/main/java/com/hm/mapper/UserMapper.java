package com.hm.mapper;

import com.hm.entity.User;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
}
