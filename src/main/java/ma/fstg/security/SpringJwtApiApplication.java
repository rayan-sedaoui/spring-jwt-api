package ma.fstg.security;

import ma.fstg.security.entities.Role;
import ma.fstg.security.entities.User;
import ma.fstg.security.repositories.RoleRepository;
import ma.fstg.security.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringJwtApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJwtApiApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            if (adminRole == null) {
                adminRole = new Role(null, "ROLE_ADMIN");
                roleRepository.save(adminRole);
            }

            if (userRepository.findByUsername("admin") == null) {
                User adminUser = new User();
                adminUser.setUsername("admin");
                adminUser.setPassword(passwordEncoder.encode("1234"));
                adminUser.setActive(true);
                adminUser.getRoles().add(adminRole);
                userRepository.save(adminUser);
                System.out.println("Utilisateur 'admin' créé avec succès !");
            }

            Role userRole = roleRepository.findByName("ROLE_USER");
            if (userRole == null) {
                userRole = new Role(null, "ROLE_USER");
                roleRepository.save(userRole);
            }

            if (userRepository.findByUsername("user1") == null) {
                User simpleUser = new User();
                simpleUser.setUsername("user1");
                simpleUser.setPassword(passwordEncoder.encode("1234"));
                simpleUser.setActive(true);
                simpleUser.getRoles().add(userRole);
                userRepository.save(simpleUser);
                System.out.println("Utilisateur 'user1' créé avec succès !");
            }
        };
    }

}