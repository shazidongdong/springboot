package com.hm.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
@TableName("t_user")
@Builder
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Tolerate
	public User() {}
	
	public User(Integer id, String username, String realname, String password, String tel, String email,
			LocalDate createTime, LocalDate updateTime, Integer status, List<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.realname = realname;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.status = status;
		this.roles = roles;
	}

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField("username")
	private String username;

	@TableField("realname")
	private String realname;

	@TableField("password")
	private String password;

	@TableField("tel")
	private String tel;

	@TableField("email")
	private String email;

	@TableField("createTime")
	private LocalDate createTime;

	@TableField("updateTime")
	private LocalDate updateTime;

	@TableField("status")
	private Integer status;
	
	@Builder.Default
	private List<Role> roles = new ArrayList<Role>();
	
}
