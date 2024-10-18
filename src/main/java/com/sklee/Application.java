package com.sklee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sklee.repository") // MyBatis Mapper 인터페이스가 위치한 패키지 경로
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	                      	
}
