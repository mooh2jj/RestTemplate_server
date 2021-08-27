package com.example.server.controller;

import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server")
@Slf4j
public class ServerApiController {

    @GetMapping("/hello")
    public User get(@RequestParam String name, @RequestParam int age) {
        log.info("hello server요청");
        User user = new User();
        user.setName(name);
        user.setAge(age);
        log.info("user: "+ user);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public User post(@RequestBody User user, @PathVariable int userId, @PathVariable String userName) {
        log.info("userId : {}, userName", userId, userName);
        log.info("client req : {}", user);
        return user;
    }

    @PostMapping("/user/header")
    public User header(@RequestHeader(value = "x-authorization") String header, @RequestBody User user){
        log.info("header : {}",header);
        log.info("body : {}", user);
        System.out.println("###header 통과 header: "+ header);

        return user;
    }


}
