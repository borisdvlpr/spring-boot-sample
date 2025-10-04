package com.borisdvlpr.sample.service;

import com.borisdvlpr.sample.domain.entities.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
}
