package com.summer.graduate.entities;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName com.summer.graduate.entities.Order
 * @Description 商品订单实体
 * @Author summer
 * @Date 2019/4/7 9:07
 * @Version 1.0
 **/
@Data
public class Order {
	private Integer id;
	private String username;
	private Integer good_id;
	private String good_name;
	private double price;
	private Integer quantity;
	private double money;
	private Integer is_pay;
	private Date ts;
}
