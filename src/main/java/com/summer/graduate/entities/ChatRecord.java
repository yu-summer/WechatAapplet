package com.summer.graduate.entities;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName com.summer.graduate.entities.ChatRecord
 * @Description TODO
 * @Author summer
 * @Date 2019/4/2 17:23
 * @Version 1.0
 **/
@Data
public class ChatRecord {
	private Integer id;
	private String username;
	private String text;
	private Date ts;
}
