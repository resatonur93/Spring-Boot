package com.onurk.api;

import com.onurk.entity.User;
import com.onurk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {


    private final UserRepository userRepository;

    @PostConstruct
    public void init(){
        User users= new User();
        users.setFirstName("Onur");
        users.setLastName("KURT");
        users.setAddress("test");
        users.setBirthOfDate(Calendar.getInstance().getTime());
        users.setId("K0001");
        userRepository.save(users);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<User>>getUser(@PathVariable String search){
    List<User> users=userRepository.findByFirstNameLikeOrLastNameLike(search,search);
    return ResponseEntity.ok(users);

    }
}
