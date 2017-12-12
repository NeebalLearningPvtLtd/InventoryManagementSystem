package com.kossine.ims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = { "classpath:hibernate_jpa.properties", "classpath:excel_to_db.properties" })
public class ImsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImsApplication.class, args);
	}
}
