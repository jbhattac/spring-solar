package com.jb.springsolar.to;


import com.jb.springsolar.model.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDetailTo {
	private String title;
	private String description;
	private Double price;
	private String currency;

	private Double averageprice;
	private Double highestprice;
	private Double lowestprice;
	private Double medianprice;
	private Integer occurencecount;
	
	  public static ProductDetailTo toProductDetailTo(Product product) {
		  return ProductDetailTo.builder()
				    .description(product.getDescription())
					.currency(product.getCurrency())
					.title(product.getTitle())
					.price(product.getPrice())
					.averageprice(product.getAverageprice())
					.highestprice(product.getHighestprice())
					.lowestprice(product.getLowestprice())
					.medianprice(product.getMedianprice())
					.occurencecount(product.getOccurencecount())
					.build();   
	  }
}
