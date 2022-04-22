package com.jb.springsolar.service;

import org.springframework.stereotype.Service;

import com.jb.springsolar.model.Product;
import com.jb.springsolar.model.ProductAIDetails;
import com.jb.springsolar.to.ProductTo;

@Service
public class ProductService {
	
	
	
	private  ProductAIDetails productAIDetails;
	
	public Product fetchEnhancedProduct(ProductTo productTo) {
		return fetchFakeEnhancedProduct(productTo);
	}

	
	private Product fetchFakeEnhancedProduct(ProductTo productTo) {
		productAIDetails = ProductAIDetails.builder()
				.averageprice(new Double(3.28))
				.highestprice(new Double(3.00))
				.lowestprice(new Double(3.00))
				.medianprice(new Double(3.30))
				.occurencecount(new Integer(23)).build();
		return Product.toProduct(productTo,productAIDetails);
	}

}
