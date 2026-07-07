package com.chatterup.chatterup.repository;

import com.chatterup.chatterup.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
}
