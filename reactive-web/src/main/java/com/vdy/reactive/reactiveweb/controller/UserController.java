package com.vdy.reactive.reactiveweb.controller;

import com.vdy.reactive.reactiveweb.model.User;
import com.vdy.reactive.reactiveweb.service.UserService;
import lombok.AllArgsConstructor;
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

    @GetMapping("/generate")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<User> generate() {
        return userService.createUser(User.builder().firstName("generated").lastName("user").build());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

}
