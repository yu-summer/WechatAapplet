package com.summer.graduate.controller;

import com.google.gson.Gson;
import com.summer.graduate.entities.Good;
import com.summer.graduate.entities.Order;
import com.summer.graduate.service.GoodService;
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
 * @ClassName com.summer.graduate.controller.GoodController
 * @Description TODO
 * @Author summer
 * @Date 2019/4/5 10:43
 * @Version 1.0
 **/
@Controller
@RequestMapping("shopping")
public class GoodController {

	@Autowired
	private GoodService goodService;

	@ResponseBody
	@RequestMapping(value = "showAllGood.do", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public String showAllGoods() {
		List<Good> goods = goodService.showGoods();
		Gson gson = new Gson();
		String json = gson.toJson(goods);
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "getGoodDetailById.do", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public String showGoodDetailById(Integer id) {
		Good good = goodService.showGoodById(id);
		String json = new Gson().toJson(good);
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "purchaseGood.do", method = RequestMethod.POST)
	public String purchaseGood(Integer good_id, String username, Integer quantity, double money) {
		String result_mess = "success";

		Good good = goodService.showGoodById(good_id);

		Order order = new Order();
		order.setGood_id(good_id);
		order.setUsername(username);
		order.setQuantity(quantity);
		order.setMoney(money);
		order.setGood_name(good.getName());
		order.setPrice(good.getPrice());

		Map<String, String> result = new HashMap<>();
		try {
			goodService.addOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
			result_mess = "error";
		} finally {
			result.put("result", result_mess);
			return new Gson().toJson(result);
		}
	}

	@ResponseBody
	@RequestMapping(value = "getAllOrderByUsername.do", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public String getAllOrderByUsername(String username) {
		List<Order> orders = goodService.getAllOrderByUsername(username);
		return new Gson().toJson(orders);
	}

	@ResponseBody
	@RequestMapping(value = "deleteOrderById.do", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public String deleteOrderById(Integer id) {
		String result_mess = "success";
		Map<String, String> result = new HashMap<>();

		try {
			goodService.deleteOrderById(id);
		} catch (Exception e) {
			e.printStackTrace();
			result_mess = "error";
		} finally {
			result.put("result", result_mess);
			return new Gson().toJson(result);
		}
	}

	@ResponseBody
	@RequestMapping(value = "addToShoppingCart.do", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public String addToShoppingCart(Integer good_id, String username, Integer quantity, double money){
		String result_mess = "success";
		Good good = goodService.showGoodById(good_id);

		Order order = new Order();
		order.setGood_id(good_id);
		order.setUsername(username);
		order.setQuantity(quantity);
		order.setMoney(money);
		order.setGood_name(good.getName());
		order.setPrice(good.getPrice());
		Map<String, String> result = new HashMap<>();

		try {
			goodService.addToShoppingCart(order);
		} catch (Exception e) {
			e.printStackTrace();
			result_mess = "error";
		} finally {
			result.put("result", result_mess);
			return new Gson().toJson(result);
		}
	}

	@ResponseBody
	@RequestMapping(value = "getAllCartByUsername.do", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public String getAllCartByUsername(String username) {
		List<Order> orders = goodService.getAllCartByUsername(username);
		return new Gson().toJson(orders);
	}

	@ResponseBody
	@RequestMapping(value = "updateCartById.do", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public void updateCartById(Integer id, Integer quantity, double money) {
		try {
			goodService.updateCartById(id, quantity, money);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping(value = "deleteShoppingCart.do", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public String deleteShoppingCart(Integer id) {
		String result_mess = "success";
		Map<String, String> result = new HashMap<>();

		try {
			goodService.deleteShoppingCart(id);
		} catch (Exception e) {
			e.printStackTrace();
			result_mess = "error";
		} finally {
			result.put("result", result_mess);
			return new Gson().toJson(result);
		}
	}

	@ResponseBody
	@RequestMapping(value = "settlementCart.do", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public String settlementCart(@RequestParam("ids") List<Integer> ids) {
		String result_mess = "success";
		Map<String, String> result = new HashMap<>();

		try {
			goodService.settlementCart(ids);
		} catch (Exception e) {
			e.printStackTrace();
			result_mess = "error";
		} finally {
			result.put("result", result_mess);
			return new Gson().toJson(result);
		}
	}
}
