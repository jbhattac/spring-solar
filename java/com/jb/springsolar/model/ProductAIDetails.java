package com.jb.springsolar.model;


import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ProductAIDetails {
	
	private Double averageprice;
	private Double highestprice;
	private Double lowestprice;
	private Double medianprice;
	private Integer occurencecount;

}
