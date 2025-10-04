package com.borisdvlpr.sample.service.impl;

import com.borisdvlpr.sample.domain.entities.User;
import com.borisdvlpr.sample.repository.UserRepository;
import com.borisdvlpr.sample.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }
}
