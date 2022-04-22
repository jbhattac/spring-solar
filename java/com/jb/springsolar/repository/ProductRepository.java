package com.jb.springsolar.repository;


import org.springframework.data.solr.repository.SolrCrudRepository;

import com.jb.springsolar.model.Product;

public interface ProductRepository extends SolrCrudRepository<Product, String> {

    public Product findBySku(String sku);


}