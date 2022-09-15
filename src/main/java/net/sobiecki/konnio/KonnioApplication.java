package net.sobiecki.konnio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class KonnioApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(KonnioApplication.class, args);
	}

}
