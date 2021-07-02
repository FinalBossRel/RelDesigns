package es.rel.dad.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

//@EnableCaching
@SpringBootApplication
public class RelDesignsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelDesignsApplication.class, args);
	}
/*
	@Bean
	public CacheManager cacheManager() {
		System.out.println("Activando cache...");
		return new ConcurrentMapCacheManager("clientes");
	}
*/
}
