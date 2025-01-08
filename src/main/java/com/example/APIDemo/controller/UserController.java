package com.example.APIDemo.controller;

import com.example.APIDemo.dto.User;
import com.example.APIDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        return ResponseEntity.ok(userRepository.getUser(id));
    }

    @GetMapping
    public ResponseEntity<User> getUserByEID(@RequestParam("eid") String eid) {
        return ResponseEntity.ok(userRepository.getUser(eid));
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.addUser(user));
    }

    @PutMapping
    public ResponseEntity<User> editUser(@RequestBody User user) {
        if (userRepository.getUsers().stream().anyMatch(user1 -> user1.getId() == user.getId())) {
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
