package com.vdy.reactive.reactiveweb.controller;

import com.vdy.reactive.reactiveweb.model.User;
import com.vdy.reactive.reactiveweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
