package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepo;
import net.javaguides.springboot.util.ResponseFactory;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/api/v2/")
public class UserController {

    @Autowired
    private UserRepo repo;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User userData) {
        User user = repo.findByUserId(userData.getUserId());
        if (user != null && user.getPassword().equals(userData.getPassword())) {
            return ResponseFactory.createSuccessResponse(user);
        } else {
            return ResponseFactory.createErrorResponse("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User userData) {
        User user = repo.findByUserId(userData.getUserId());
        if (user != null && user.getUserId().equals(userData.getUserId())) {
            return ResponseFactory.createErrorResponse("User already exists");
        } else {
            return ResponseFactory.createSuccessResponse(repo.save(userData));
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return ResponseFactory.createSuccessResponse(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User userData) {
        User user = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        user.setName(userData.getName());
        user.setEmail(userData.getEmail());
        User updatedUser = repo.save(user);
        return ResponseFactory.createSuccessResponse(updatedUser);
    }

}
