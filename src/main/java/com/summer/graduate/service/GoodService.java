package com.summer.graduate.service;

import com.summer.graduate.entities.Good;
import com.summer.graduate.entities.Order;

import java.util.List;

public interface GoodService {
	List<Good> showGoods();

	Good showGoodById(Integer id);

	void addOrder(Order order);

	List<Order> getAllOrderByUsername(String username);

	void deleteOrderById(Integer id);

	void addToShoppingCart(Order order);

	void deleteShoppingCart(Integer id);

	List<Order> getAllCartByUsername(String username);

	void updateCartById(Integer id, Integer quantity, double money);

	void settlementCart(List<Integer> ids);
}
