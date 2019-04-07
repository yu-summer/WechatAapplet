package com.summer.graduate.dao;

import com.summer.graduate.entities.Good;
import com.summer.graduate.entities.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodDao {
	//罗列出商品
	List<Good> showGoods();

	Good showGoodById(Integer id);

	void addOrder(Order order);

	//查找一个用户的订单
	List<Order> getAllOrderByUsername(String username);

	void deleteOrderById(Integer id);


	//	购物车start
	//添加到购物车
	void addToShoppingCart(Order order);

	void deleteShoppingCart(Integer id);

	//显示购物车订单
	List<Order> getAllCartByUsername(String username);

	void updateCartById(@Param("id") Integer id, @Param("quantity") Integer quantity, @Param("money") double money);

	//结算购物车
	void settlementCart(@Param("ids") List<Integer> ids);
	// 购物车 end
}
