package com.kossine.ims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


@EntityScan(basePackageClasses = { ImsApplication.class, Jsr310JpaConverters.class })
@SpringBootApplication
@PropertySource("classpath:hibernate_jpa.properties")
public class ImsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImsApplication.class, args);
	}
}
