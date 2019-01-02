package com.hm.dao;

import java.util.List;
import java.util.Set;

import com.hm.domain.Role;
import com.hm.domain.User;
import com.hm.domain.UserRoleLink;

public interface UserMapper extends BaseMapper<User> {
	public void saveMiddleTable(UserRoleLink obj);

	public void deleteMiddleTable(Long id);

	public List<Long> findEIdByRId(Long id);

	public List<String> findAllPermissionNameByLoginUser(Long loginUserId);

	public Set<Role> getRolesByeId(Long id);
}
