package com.jb.springsolar.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jb.springsolar.config.SolrConfig;
import com.jb.springsolar.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SolrConfig.class)
public class ProductRepositoryTest {
	
	@Autowired
    private ProductRepository productRepository;

   @Before
    public void clearSolrData() {
        productRepository.deleteAll();
    }

    @Test
    public void whenSavingProduct_thenAvailableOnRetrieval() throws Exception {

        final Product product = Product.builder().sku("article123").build();

        productRepository.save(product);
        final Product retrievedProduct = productRepository.findBySku(product.getSku());
        assertEquals(product.getSku(), retrievedProduct.getSku());
    }


}
