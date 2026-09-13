package com.ecommerce.auth.config;

import com.ecommerce.auth.entity.User;
import com.ecommerce.auth.enums.Role;
import com.ecommerce.auth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;

@Configuration
public class DataInitializer {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initAdmin(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        return args -> createUsers();
    }

    private void createUsers() {
        createUserIfNotExists(
                "admin@example.com",
                "Super",
                "Admin",
                "Admin@123",
                Role.ADMIN
        );

        createUserIfNotExists(
                "user@example.com",
                "Demo",
                "User",
                "Password123",
                Role.USER
        );
    }

    private void createUserIfNotExists(
            String email,
            String firstName,
            String lastName,
            String password,
            Role role
    ) {
        this.userRepository.findByEmail(email)
                .orElseGet(() -> {
                            User user = User.builder()
                                    .firstName(firstName)
                                    .lastName(lastName)
                                    .email(email)
                                    .password(this.passwordEncoder.encode(password))
                                    .role(role)
                                    .timeZone("Asia/Kolkata")
                                    .verified(true)
                                    .createdAt(Instant.now())
                                    .build();

                            System.out.println(role + " created");
                            return this.userRepository.save(user);
                        }
                );
    }
}
