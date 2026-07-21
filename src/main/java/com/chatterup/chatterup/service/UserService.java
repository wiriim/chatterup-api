package com.chatterup.chatterup.service;

import com.chatterup.chatterup.model.User;
import com.chatterup.chatterup.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> getById(int id){
        return userRepository.findById(id);
    }

    public Optional<User> getByUsername(String username){
        return userRepository.findByUsernameIgnoreCase(username);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
