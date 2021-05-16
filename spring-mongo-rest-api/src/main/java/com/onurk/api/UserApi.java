package com.onurk.api;

import com.onurk.entity.User;
import com.onurk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init(){
        User users= new User();
        users.setFirstname("Onur");
        users.setLastname("KURT");
        userRepository.save(users);
    }


    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));

    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }
}
