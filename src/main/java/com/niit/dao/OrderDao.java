package com.niit.dao;

import java.util.List;

import com.niit.model.Order;

public interface OrderDao 
{
	public boolean addOrder(Order order);
	public boolean cancelOrder(Order order);
	public boolean updateOrder(Order order);
	public List<Order> displayOrders(Order order);

}
