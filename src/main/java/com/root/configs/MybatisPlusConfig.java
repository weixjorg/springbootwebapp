package com.root.configs;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;

@EnableTransactionManagement
@Configuration
//@MapperScan("com.root.dao")
public class MybatisPlusConfig {

 /**
  * 分页插件
  */
//	/*
 @Bean
 public PaginationInterceptor paginationInterceptor() {
     return new PaginationInterceptor();
 }
//*/
 /**
  * 打印 sql
  */
///*	
 @Bean
 public PerformanceInterceptor performanceInterceptor() {
     PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
     //格式化sql语句
     Properties properties = new Properties();
     properties.setProperty("format", "true");
     performanceInterceptor.setProperties(properties);
     return performanceInterceptor;
 }
// */
}

