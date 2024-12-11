package com.tewrwe;

import com.tewrwe.models.Asset;
import com.tewrwe.models.User;
import com.tewrwe.repositories.AssetRepository;
import com.tewrwe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TewrweApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssetRepository assetRepository;

    public static void main(String[] args) {
        SpringApplication.run(TewrweApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Insert Users
        User user1 = new User();
        user1.setUsername("Alice");
        user1.setEmail("alice@example.com");
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("Bob");
        user2.setEmail("bob@example.com");
        userRepository.save(user2);

        Asset asset1 = new Asset();
        asset1.setTitle("Laptop");
        asset1.setDescription("A high-performance laptop.");
        asset1.setPrice(999.99);
        asset1.setFileUrl("http://example.com/laptop.jpg");
        asset1.setCreatedAt(new Date());
        assetRepository.save(asset1);

        Asset asset2 = new Asset();
        asset2.setTitle("Table");
        asset2.setDescription("A wooden dining table.");
        asset2.setPrice(299.99);
        asset2.setFileUrl("http://example.com/table.jpg");
        asset2.setCreatedAt(new Date());
        assetRepository.save(asset2);
    }
}
