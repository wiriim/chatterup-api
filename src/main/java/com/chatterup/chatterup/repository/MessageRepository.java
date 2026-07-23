package com.chatterup.chatterup.repository;

import com.chatterup.chatterup.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    Collection<Message> findAllByChat_Id(int chatId);

    Collection<Message> findAllByChat_IdOrderByDateAsc(int chatId);
}
