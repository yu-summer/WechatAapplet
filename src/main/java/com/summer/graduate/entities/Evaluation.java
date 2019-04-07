package com.summer.graduate.entities;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName com.summer.graduate.entities.Evaluation
 * @Description 商品评价实体
 * @Author summer
 * @Date 2019/4/5 10:22
 * @Version 1.0
 **/
@Data
public class Evaluation {
	private Integer id;
	private Integer good_id;
	private String username;
	private String content;
	private Date ts;
}
