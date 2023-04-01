package com.companeros.msvclibro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsvcLibroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcLibroApplication.class, args);
	}

}
