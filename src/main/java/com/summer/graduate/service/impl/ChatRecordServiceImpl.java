package com.summer.graduate.service.impl;

import com.summer.graduate.dao.ChatRecordDao;
import com.summer.graduate.entities.ChatRecord;
import com.summer.graduate.service.ChatRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName com.summer.graduate.service.impl.ChatRecordServerImpl
 * @Description TODO
 * @Author summer
 * @Date 2019/4/3 11:32
 * @Version 1.0
 **/
@Service
public class ChatRecordServiceImpl implements ChatRecordService {

	@Autowired
	private ChatRecordDao chatRecordDao;

	@Override
	public void addChatRecord(ChatRecord chatRecord) {
		chatRecordDao.addChatRecord(chatRecord);
	}
}
