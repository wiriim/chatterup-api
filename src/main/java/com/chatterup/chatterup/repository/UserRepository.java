package com.chatterup.chatterup.repository;

import com.chatterup.chatterup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
