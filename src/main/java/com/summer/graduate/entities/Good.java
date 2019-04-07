package com.summer.graduate.entities;


import lombok.Data;

import java.util.Date;

/**
 * @ClassName com.summer.graduate.entities.Good
 * @Description 商品实体
 * @Author summer
 * @Date 2019/4/5 10:36
 * @Version 1.0
 **/
@Data
public class Good {
	private Integer id;
	private String name;
	private double price;
	private String info;
	private Date ts;
}
