package com.summer.graduate.entities;

import lombok.Data;

/**
 * @ClassName com.summer.graduate.entities.PurchaseRecordService
 * @Description 购买记录实体
 * @Author summer
 * @Date 2019/4/5 10:25
 * @Version 1.0
 **/
@Data
public class PurchaseRecord {
	private Integer id;
	private Integer good_id;
	private Integer quantity;
	private double money;
	private Data ts;
}
