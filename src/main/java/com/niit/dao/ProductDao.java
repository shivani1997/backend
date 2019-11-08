package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDao 
{
	public void addProduct(Product product);
	public void deleteProduct(ProductDao product);
	public void updateProduct(ProductDao product);
	public List<ProductDao> displayProducts();
	public ProductDao displayProductById(ProductDao product);
	public ProductDao displayProductByName(ProductDao product);
	public Object getProductid();

}
