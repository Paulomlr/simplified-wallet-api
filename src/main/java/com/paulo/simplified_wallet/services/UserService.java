package com.paulo.simplified_wallet.services;

import com.paulo.simplified_wallet.entities.User;
import com.paulo.simplified_wallet.repositories.UserRepository;
import com.paulo.simplified_wallet.services.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
            new UserNotFoundException("User not found!"));
    }
}