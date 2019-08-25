package com.mz;


import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;


@SpringBootApplication
@EnableSwagger2
public class PhoneBookApplication {

    @Autowired
    private ResourceLoader resourceLoader;

    public static void main(String[] args){

        SpringApplication.run(PhoneBookApplication.class, args);
    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("" + "/.*/.*")).build().pathMapping("");
    }

    @Bean
    public DozerBeanMapperFactoryBean dozer() {
        DozerBeanMapperFactoryBean dozer = new DozerBeanMapperFactoryBean();
        dozer.setMappingFiles(loadResources());
        return dozer;
    }

    public Resource[] loadResources() {
        Resource[] resources = null;
        try {
            resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                    .getResources("classpath*:dozer/**/*.dzr.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resources;
    }
}
