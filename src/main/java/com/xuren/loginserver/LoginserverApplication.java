package com.xuren.loginserver;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.xuren.loginserver.mapper")
public class LoginserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginserverApplication.class, args);
	}

}
