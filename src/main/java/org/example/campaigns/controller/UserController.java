package org.example.campaigns.controller;

import lombok.AllArgsConstructor;
import org.example.campaigns.entity.User;
import org.example.campaigns.exception.ResourceNotFoundException;
import org.example.campaigns.repo.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserRepo userRepo;

    @GetMapping("/{userId}/balance")
    public ResponseEntity<Double> getUserBalance(@PathVariable Integer userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return ResponseEntity.ok(user.getEmeraldFunds());
    }
}
