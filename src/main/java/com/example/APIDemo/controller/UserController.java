package com.example.APIDemo.controller;

import com.example.APIDemo.dto.User;
import com.example.APIDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(userRepository.getUser(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping
    public ResponseEntity<?> getUserByEID(@RequestParam("eid") String eid) {
        try {
            return ResponseEntity.ok(userRepository.getUser(eid));
        } catch (Exception e) {
            InputStream in = getClass().getResourceAsStream("/418.jpeg");
            return ResponseEntity.status(418).contentType(MediaType.IMAGE_JPEG).body(new InputStreamResource(in));
        }
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.addUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable("id") int id, @RequestBody User user) {
        if (userRepository.getUsers().stream().anyMatch(user1 -> user1.getId() == id)) {
            return ResponseEntity.ok(userRepository.modify(user));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        boolean ok = userRepository.removeUser(id);
        if (ok) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

}
