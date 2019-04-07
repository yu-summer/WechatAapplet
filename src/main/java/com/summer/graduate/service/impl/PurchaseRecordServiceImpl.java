package com.summer.graduate.service.impl;

import com.summer.graduate.dao.PurchaseRecordDao;
import com.summer.graduate.entities.PurchaseRecord;
import com.summer.graduate.service.PurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @ClassName com.summer.graduate.service.impl.PurchaseRecordServiceImpl
 * @Description TODO
 * @Author summer
 * @Date 2019/4/5 10:29
 * @Version 1.0
 **/
@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

	@Autowired
	private PurchaseRecordDao purchaseRecordDao;

	@Override
	public void addRecord(PurchaseRecord purchaseRecord) {
		purchaseRecordDao.addRecord(purchaseRecord);
	}
}
