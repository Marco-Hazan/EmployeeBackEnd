//package com.accenture.ProgettoImpiegati;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class AppConfiguration {
//
//@Autowired
//
//@SuppressWarnings("deprecation")
//@Bean
//public WebMvcConfigurer corsConfigurer() {
//    return new WebMvcConfigurerAdapter() {
//        @Override
//        public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/**")
//                    .allowedOrigins("http://localhost:4200")
//                    .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
//                    .allowedHeaders("Content-Type", "Date", "Total-Count", "loginInfo")
//                    .exposedHeaders("Content-Type", "Date", "Total-Count", "loginInfo")
//                    .maxAge(3600);
//        }
//    };
//}}
