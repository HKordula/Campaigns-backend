package org.example.campaigns;

import org.example.campaigns.entity.User;
import org.example.campaigns.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepo userRepo;

    public DataLoader(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("admin");
        user.setEmeraldFunds(50000.0);
        userRepo.save(user);
    }
}