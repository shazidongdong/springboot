package com.hm.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@SuppressWarnings("unused")
public class User {
	
	private Integer id;

	private String username;

	private String realname;

	private String password;

	private String tel;

	private String email;

	private Date createtime;

	private Date updatetime;

	private Integer status;

	private Long roleId;

	private List<Role> roles= new ArrayList<Role>();

}