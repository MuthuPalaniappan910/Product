package com.ecommerce.product.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ecommerce.product.dto.ProductList;
import com.ecommerce.product.entity.Product;
import com.ecommerce.product.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceTest {
	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Mock
	ProductRepository productRepository;

	List<Product> productList = null;
	Product productDetailsList = null;

	@Before
	public void before() {
		productList = new ArrayList<>();
		productDetailsList = new Product();
		productDetailsList.setProductName("abc");
		productList.add(productDetailsList);
	}

	@Test
	public void testGetProductDetailsPositive() {
		Mockito.when(productRepository.findByProductNameContaining("abc")).thenReturn(productList);
		List<ProductList> expected = productServiceImpl.getProductDetails("abc");
		assertEquals(productList.size(), expected.size());
	}

}
