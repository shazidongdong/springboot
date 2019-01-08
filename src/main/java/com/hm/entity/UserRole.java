package com.hm.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
@Builder
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("user_Id")
    private Long userId;

    @TableField("role_Id")
    private Long roleId;


}
