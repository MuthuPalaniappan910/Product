package com.ecommerce.product.controller;

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

import com.ecommerce.product.constants.ApplicationConstants;
import com.ecommerce.product.dto.ProductList;
import com.ecommerce.product.service.ProductService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductControllerTest {
	@Mock
	ProductService productService;

	@InjectMocks
	ProductController productController;

	List<ProductList> productList = null;
	List<ProductList> productList1 = null;
	ProductList productDetailsList = null;

	@Before
	public void before() {
		productList = new ArrayList<>();
		productDetailsList = new ProductList();
		productDetailsList.setProductName("abc");
		productList.add(productDetailsList);
	}

	@Test
	public void testGetProductDetailsPositive() {
		Mockito.when(productService.getProductDetails("abc")).thenReturn(productList);
		Integer expected = productController.getProductDetails("abc").getStatusCodeValue();
		assertEquals(ApplicationConstants.PRODUCT_SUCCESSCODE, expected);
	}

	@Test
	public void testGetProductDetailsNegative() {
		Mockito.when(productService.getProductDetails("def")).thenReturn(productList1);
		Integer expected = productController.getProductDetails("abc").getStatusCodeValue();
		assertEquals(ApplicationConstants.PRODUCT_FAILURECODE, expected);
	}
}
