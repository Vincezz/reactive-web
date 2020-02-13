package com.vdy.reactive.reactiveweb.service;

import com.vdy.reactive.reactiveweb.model.User;
import com.vdy.reactive.reactiveweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Mono<User> createUser(User user) {
        log.info("Create user {}", user.toString());
        return userRepository.save(user);
    }

    public Mono<User> getUser(Long id) {
        return userRepository.findById(id);
    }
}
