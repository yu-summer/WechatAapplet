package com.summer.graduate.controller;

import com.summer.graduate.entities.ChatRecord;
import com.summer.graduate.service.ChatRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName com.summer.graduate.controller.MessageController
 * @Description TODO
 * @Author summer
 * @Date 2019/4/3 9:57
 * @Version 1.0
 **/
@Controller
public class MessageController {
	@Autowired
	private ChatRecordService chatRecordServer;

	//请求入口
	@RequestMapping(value="sentMessage.do",method= RequestMethod.POST)
	@ResponseBody
	public void TestWS(@RequestParam(value="username",required=true) String username,
	                     @RequestParam(value="message",required=true) String message){
		ChatRecord chatRecord = new ChatRecord();
		chatRecord.setUsername(username);
		chatRecord.setText(message);
		chatRecordServer.addChatRecord(chatRecord);
	}
}
