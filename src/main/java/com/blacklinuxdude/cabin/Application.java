package com.blacklinuxdude.cabin;

import com.blacklinuxdude.cabin.service.AssetRepository;
import com.mongodb.DB;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import java.net.UnknownHostException;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Import(RepositoryRestMvcConfiguration.class)
public class Application {

    @Autowired
    AssetRepository assetRepository;

    private static final Log logger = LogFactory.getLog(Application.class);


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
    }




}