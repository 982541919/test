package com.heima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableEurekaClient
public class ConsumerApplication {
	
	@Bean // 该注解类似于spring中的 <bean>标签，会在启动的时候执行改方法  4
	@LoadBalanced // 加上该注解使用rebbon，让RestTemplate具备rebbon的负载均衡能力
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
