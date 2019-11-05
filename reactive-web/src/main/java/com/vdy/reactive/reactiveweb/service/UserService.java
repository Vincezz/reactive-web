package com.vdy.reactive.reactiveweb.service;

import com.vdy.reactive.reactiveweb.model.User;
import com.vdy.reactive.reactiveweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }
}
