package com.niit.dao;

import com.niit.model.CartItem;

public interface CartItemDao 
{
	public void addCart(CartItem cart);
	public void deleteCart(CartItem cart);
	public void updateCart(CartItem cart);
	public void displayCart(CartItem cart);

}
