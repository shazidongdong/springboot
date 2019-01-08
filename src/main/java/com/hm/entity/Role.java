package com.hm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.Tolerate;

/**
 * <p>
 * 
 * </p>
 *
 * @author hm
 * @since 2019-01-07
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_role")
@Builder
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	@Tolerate
	public Role() {
		super();
	}

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField("name")
	private String name;
	
//	private List<User> users = new ArrayList<User>();
	
    private List<Permission> permissions = new ArrayList<Permission>();

}
