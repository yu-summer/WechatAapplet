package com.summer.graduate.controller;

import com.google.gson.Gson;
import com.summer.graduate.entities.User;
import com.summer.graduate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName com.summer.graduate.controller.UserController
 * @Description TODO
 * @Author summer
 * @Date 2019/3/8 15:35
 * @Version 1.0
 **/
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "doLogin.do", method = RequestMethod.POST)
	public Map<String, String> login(String username, String password) {
		Map<String, String> resultMap = new HashMap<>();
		User user = userService.getUserByNameAngPassw(username, password);
		if (user == null) {
			System.out.println("登录失败");
			resultMap.put("result", "error");
		} else {
			System.out.println("登录成功");
			resultMap.put("result", username);
			resultMap.put("userType", user.getType().toString());
		}
		return resultMap;
	}

	@ResponseBody
	@RequestMapping(value = "doRegister.do", method = RequestMethod.POST)
	public Map<String, String> register(String username, String password, String address) {
		String result = "fail";
		if (userService.getUserByUsername(username) != null) {
			result = "nameExist";
		} else {
			userService.createUser(username, password, address);
			result = "success";
		}
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("result", result);
		return resultMap;
	}

	@ResponseBody
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public Map<String, String> update(String username, String password, String address) {
		String result = "fail";
		userService.updateUser(username, password, address);
		result = "success";
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("result", result);
		return resultMap;
	}

	@ResponseBody
	@RequestMapping(value = "managerUser.do", method = RequestMethod.GET)
	public String getAllUsers(@RequestParam(value = "username", defaultValue = "") String username) {
		List<User> users = userService.getUsers(username);

		Gson gson = new Gson();
		Map<String, List<User>> userList = new HashMap<>();
		userList.put("users", users);
		return gson.toJson(userList);
	}

	@ResponseBody
	@RequestMapping(value = "upgradeOrDowngrade.do", method = RequestMethod.GET)
	public String upgradeOrDowngrade(String username, Integer type) {
		String result_mess = "success";
		Map<String, String> result = new HashMap<>();
		try {
			userService.upgradeOrDowngrade(username, type);
		} catch (Exception e) {
			e.printStackTrace();
			result_mess = "error";
		} finally {
			result.put("result", result_mess);
			String json = new Gson().toJson(result);
			return json;
		}
	}
}
