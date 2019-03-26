package com.summer.graduate.entities;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName com.summer.graduate.entities.Article
 * @Description TODO
 * @Author summer
 * @Date 2019/3/24 9:35
 * @Version 1.0
 **/
@Data
public class Article {
	private Integer id;      //文章id
	private String title;    //文章标题
	private String text;     //文章内容
	private Date ts;         //时间戳
}
