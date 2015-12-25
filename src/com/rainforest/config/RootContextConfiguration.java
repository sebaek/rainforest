package com.rainforest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
        basePackages = "com.rainforest.site",
        excludeFilters =
        @ComponentScan.Filter(Controller.class)
)
public class RootContextConfiguration {

}
