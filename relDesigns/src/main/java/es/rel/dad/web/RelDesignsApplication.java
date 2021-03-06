package es.rel.dad.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

@EnableCaching
@SpringBootApplication
@EnableHazelcastHttpSession
public class RelDesignsApplication {

	private static final Log LOG= LogFactory.getLog(RelDesignsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RelDesignsApplication.class, args);
	}
	
	 @Bean
	 public Config config() {
		 Config config = new Config();
		 JoinConfig joinConfig = config.getNetworkConfig().getJoin();
		 joinConfig.getMulticastConfig().setEnabled(false);
		 
		 joinConfig.getTcpIpConfig().setEnabled(true).setMembers(Arrays.asList("rel-web1", "rel-web2"));
		 return config;
	 }
	

	@Bean
	public CacheManager cacheManager(){
		System.out.println("Activando cache...");
		return new ConcurrentMapCacheManager("itemsCache");
	}

}
