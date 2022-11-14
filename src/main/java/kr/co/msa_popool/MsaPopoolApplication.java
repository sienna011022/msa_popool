package kr.co.msa_popool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MsaPopoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaPopoolApplication.class, args);
    }

}
