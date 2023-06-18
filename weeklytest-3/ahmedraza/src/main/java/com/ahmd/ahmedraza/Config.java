package com.ahmd.ahmedraza;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Car getobj(){
        return new Car("red");
    }
}
