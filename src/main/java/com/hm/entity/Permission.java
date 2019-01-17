package com.hm.entity;

import java.io.Serializable;

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
@TableName("t_permission")
@Builder
public class Permission implements Serializable {

	private static final long serialVersionUID = 1L;
	@Tolerate
	 public Permission() {
		 
	}
	
	@Tolerate
	public Permission(String name, String resource) {
		this.name = name;
		this.resource = resource;
	}


	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField("name")
	private String name;

	@TableField("resource")
	private String resource;

	@TableField("state")
	private Integer state;

	@TableField("menu_id")
	private Long menuId;
	
	private Menu menu;

}
