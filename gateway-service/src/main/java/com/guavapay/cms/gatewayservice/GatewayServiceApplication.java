package com.guavapay.cms.gatewayservice;

import com.guavapay.cms.gatewayservice.dao.entity.UserEntity;
import com.guavapay.cms.gatewayservice.dao.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableDiscoveryClient
@SpringBootApplication
@RequiredArgsConstructor
public class GatewayServiceApplication implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity userEntity = new UserEntity(1L, "test_user", "password", true);
        userRepository.save(userEntity);
    }
}
