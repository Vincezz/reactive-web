package com.vdy.reactive.reactiveweb.controller;

import com.vdy.reactive.reactiveweb.model.User;
import com.vdy.reactive.reactiveweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping

    private Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
