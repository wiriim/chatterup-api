package com.chatterup.chatterup.repository;

import com.chatterup.chatterup.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
    Collection<Chat> findByUsersUsername(String usersUsername);
}
