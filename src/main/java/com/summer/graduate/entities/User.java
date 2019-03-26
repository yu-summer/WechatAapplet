package com.summer.graduate.entities;

import lombok.Data;

/**
 * @ClassName com.summer.graduate.entities.User
 * @Description TODO
 * @Author summer
 * @Date 2019/3/8 15:24
 * @Version 1.0
 **/
@Data
public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer type;
}
 