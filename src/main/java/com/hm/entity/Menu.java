package com.hm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
 * @since 2019-01-17
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

	
    @Tolerate
    public Menu() {

	}
    
    @Tolerate
	public Menu(String menuName, String url, Menu parent) {
		this.menuName = menuName;
		this.url = url;
		this.parent = parent;
	}
	@TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("parentId")
    private Integer parentId;

    @TableField("menuName")
    private String menuName;
    
    @TableField("url")
    private String url;
    
    @TableField("state")
    private Integer state;
    /**
     * 	上级菜单
     */
    private Menu parent;
    
    private List<Menu> children = new ArrayList<Menu>();
    
    public List<Menu> getChildren() {
		if (children.size() == 0) {
			return null;
		}
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}
}
