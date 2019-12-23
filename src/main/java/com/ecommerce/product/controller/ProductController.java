package com.ecommerce.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product.constants.ApplicationConstants;
import com.ecommerce.product.dto.ProductList;
import com.ecommerce.product.dto.ProductResponseDto;
import com.ecommerce.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/products")
@Slf4j
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class ProductController {
	@Autowired
	ProductService productService;

	/**
	 * @author Muthu
	 * 
	 *         Method is used to display the product details based on the partial
	 *         name entered
	 * 
	 * @param productName
	 * @return ProductResponseDto which contains details of product that includes
	 *         its name,description,quantity available,category and its price
	 */
	@GetMapping
	public ResponseEntity<ProductResponseDto> getProductDetails(@RequestParam String productName) {
		ProductResponseDto productResponseDto = new ProductResponseDto();
		log.info("Searching product details");
		List<ProductList> productList = productService.getProductDetails(productName);
		if (productList.isEmpty()) {
			productResponseDto.setMessage(ApplicationConstants.PRODUCTLIST_EMPTY_MESSAGE);
			productResponseDto.setStatusCode(ApplicationConstants.PRODUCT_FAILURECODE);
			return new ResponseEntity<>(productResponseDto, HttpStatus.NOT_FOUND);
		}
		productResponseDto.setMessage(ApplicationConstants.PRODUCTLIST_DISPLAY_MESSAGE);
		productResponseDto.setStatusCode(ApplicationConstants.PRODUCT_SUCCESSCODE);
		productResponseDto.setProductList(productList);
		return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
	}
}
