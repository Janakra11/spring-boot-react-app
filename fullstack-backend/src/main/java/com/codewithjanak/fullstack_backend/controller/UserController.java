package com.codewithjanak.fullstack_backend.controller;

import com.codewithjanak.fullstack_backend.exception.UserNotFoundException;
import com.codewithjanak.fullstack_backend.model.User;
import com.codewithjanak.fullstack_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user){
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id")Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
        return ResponseEntity.ok(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User newUSer, @PathVariable("id") Long id){

        User user = userRepository.findById(id)
                .map(u ->{
                        u.setUserName(newUSer.getUserName());
                        u.setEmail(newUSer.getEmail());
                        u.setName(newUSer.getName());
                    return userRepository.save(u);
        }).orElseThrow(()-> new UserNotFoundException(id));
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id")Long id) {

        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);

        return ResponseEntity.ok("User with id:"+id+" deleted successfully");
    }
 }
