package com.jb.springsolar.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = "com.jb.springsolar.repository")
@ComponentScan
public class SolrConfig {

    @Bean
    public SolrClient solrClient() {
    	 SolrClient client = new HttpSolrClient.Builder("http://localhost:8983/solr/").build();
        return client;
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
    	SolrTemplate template = new SolrTemplate(client);
        return template;
    }
}
