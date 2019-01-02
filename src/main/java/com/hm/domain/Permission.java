package com.hm.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("unused")
public class Permission {
    private Integer id;

    private String name;

    private String resource;

    private Integer state;

    private Long menuId;

}