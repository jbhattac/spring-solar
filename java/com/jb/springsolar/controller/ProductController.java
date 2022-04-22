package com.jb.springsolar.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jb.springsolar.exception.NoProductFoundException;
import com.jb.springsolar.model.Product;
import com.jb.springsolar.repository.ProductRepository;
import com.jb.springsolar.service.ProductService;
import com.jb.springsolar.to.ProductTo;

@RestController()
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@PostMapping("/add")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ProductTo addProduct(@RequestBody ProductTo productTo) {
		Product product = productRepository.save(productService.fetchEnhancedProduct(productTo));
		return ProductTo.toProductTo(product);
	}
	
	@GetMapping("/detail/{sku}")
	@ResponseStatus(value = HttpStatus.OK)
	public ProductTo getProduct(@NotNull @PathVariable String sku) {
		Product product = productRepository.findBySku(sku);
		if(null == product) {
			throw new NoProductFoundException("Product not found with the sku "+sku);
		}
		return ProductTo.toProductTo(product);
	}

}
