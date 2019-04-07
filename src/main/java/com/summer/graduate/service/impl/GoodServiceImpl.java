package com.summer.graduate.service.impl;

import com.summer.graduate.dao.GoodDao;
import com.summer.graduate.entities.Good;
import com.summer.graduate.entities.Order;
import com.summer.graduate.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName com.summer.graduate.service.impl.GoodServiceImpl
 * @Description TODO
 * @Author summer
 * @Date 2019/4/5 10:39
 * @Version 1.0
 **/
@Service
public class GoodServiceImpl implements GoodService {

	@Autowired
	private GoodDao goodDao;

	@Override
	public List<Good> showGoods() {
		return goodDao.showGoods();
	}

	@Override
	public Good showGoodById(Integer id) {
		return goodDao.showGoodById(id);
	}

	@Override
	public void addOrder(Order order) {
		goodDao.addOrder(order);
	}

	@Override
	public List<Order> getAllOrderByUsername(String username) {
		return goodDao.getAllOrderByUsername(username);
	}

	@Override
	public void deleteOrderById(Integer id) {
		goodDao.deleteOrderById(id);
	}

	@Override
	public void addToShoppingCart(Order order) {
		goodDao.addToShoppingCart(order);
	}

	@Override
	public void deleteShoppingCart(Integer id) {
		goodDao.deleteShoppingCart(id);
	}

	@Override
	public List<Order> getAllCartByUsername(String username) {
		return goodDao.getAllCartByUsername(username);
	}

	@Override
	public void updateCartById(Integer id, Integer quantity, double money) {
		goodDao.updateCartById(id, quantity, money);
	}

	@Override
	public void settlementCart(List<Integer> ids) {
		goodDao.settlementCart(ids);
	}
}
