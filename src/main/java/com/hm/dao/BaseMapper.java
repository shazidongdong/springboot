package com.hm.dao;

import java.util.List;


public interface BaseMapper<T> {
	/**添加*/
	public void save(T obj);
	
	/**修改、更新*/
	public void update(T obj);

	/**根据id删除一个*/
	public void delete(Long id);

	/**根据id获取一个*/
	public T get(Long id);

	/**获取全部*/
	public List<T> getAll();
	
	/**查询总页数*/
	//public int findTotal(BaseQuery baseQuery);

	/**查询分页*/
	//public List<T> findLimit(BaseQuery baseQuery);

}
