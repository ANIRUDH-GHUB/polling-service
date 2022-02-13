package com.au.polling.service;

import com.au.polling.model.User;
import com.au.polling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return this.userRepository.save(user);
    }
    public List<User> findAll(){
        return this.userRepository.findAll();
    }
    public User findByUsername(String username){
        return this.userRepository.findByUsername(username);
    }
}
