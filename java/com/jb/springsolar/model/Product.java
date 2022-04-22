package com.jb.springsolar.model;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import com.jb.springsolar.to.ProductTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SolrDocument(collection  = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Field("sku_s")
    private String sku;
	@Field("title_s")
	private String title;
	@Field("description_s")
	private String description;
	@Field("price_d")
	private Double price;
	@Field("currency_s")
	private String currency;
	@Field("averageprice_d")
	private Double averageprice;
	@Field("highestprice_d")
	private Double highestprice;
	@Field("lowestprice_d")
	private Double lowestprice;
	@Field("medianprice_d")
	private Double medianprice;
	@Field("occurencecount_i")
	private Integer occurencecount;
    
    public static Product toProduct(ProductTo productTo, ProductAIDetails productAIDetails) {
    	return Product.builder().sku(productTo.getSku())
    			.description(productTo.getProductDetailTo().getDescription())
				.currency(productTo.getProductDetailTo().getCurrency())
				.price(productTo.getProductDetailTo().getPrice())
				.title(productTo.getProductDetailTo().getTitle())
				.averageprice(productAIDetails.getAverageprice())
				.highestprice(productAIDetails.getHighestprice())
				.lowestprice(productAIDetails.getLowestprice())
				.medianprice(productAIDetails.getMedianprice())
				.occurencecount(productAIDetails.getOccurencecount())
				.build();    
    }
  
}
