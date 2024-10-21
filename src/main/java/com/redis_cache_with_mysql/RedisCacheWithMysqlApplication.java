package com.redis_cache_with_mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisCacheWithMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheWithMysqlApplication.class, args);
	}

}
