package com.hm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hm
 * @since 2019-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @TableField("role_id")
    private Long roleId;


}
