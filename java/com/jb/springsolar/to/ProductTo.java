package com.jb.springsolar.to;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.jb.springsolar.model.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductTo {
	@NotNull
	private String sku;
	@JsonAlias("detail")
	private ProductDetailTo productDetailTo;
	
	  public static ProductTo toProductTo(Product product) {
		  return ProductTo.builder().sku(product.getSku())
				  .productDetailTo(ProductDetailTo.toProductDetailTo(product))
				  .build();
	  }

}
