package com.ecommerce.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.product.dto.ProductList;
import com.ecommerce.product.entity.Product;
import com.ecommerce.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	/**
	 * @author Muthu 
	 * Method is used to display the product details based on the
	 *         partial name entered
	 * @param productName
	 * @return ProductResponseDto which contains details of product that includes
	 *         its name,description,quantity available,category and its price
	 */
	@Override
	public List<ProductList> getProductDetails(String productName) {
		log.info("fetching details from repository");
		List<ProductList> productList = new ArrayList<>();
		List<Product> product = productRepository.findByProductNameContaining(productName);
		product.forEach(productDetails -> {
			ProductList productDetailsList = new ProductList();
			BeanUtils.copyProperties(productDetails, productDetailsList);
			productList.add(productDetailsList);
		});
		return productList;
	}

}
