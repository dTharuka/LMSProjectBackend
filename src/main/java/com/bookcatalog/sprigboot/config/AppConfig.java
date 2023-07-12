package com.bookcatalog.sprigboot.config;

import com.bookcatalog.sprigboot.service.impl.LoginServiceImpl;
import com.bookcatalog.sprigboot.service.impl.RegisterServiceImpl;
import com.bookcatalog.sprigboot.service.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {UserServiceImpl.class , RegisterServiceImpl.class, LoginServiceImpl.class})
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
