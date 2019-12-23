package com.ecommerce.product.service;

import java.util.List;

import com.ecommerce.product.dto.ProductList;

public interface ProductService {

	List<ProductList> getProductDetails(String productName);

}
