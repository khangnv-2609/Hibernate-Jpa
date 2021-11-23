package com.example.selfgeneratedtextid.service.UserImpl;

import com.example.selfgeneratedtextid.entity.User;
import com.example.selfgeneratedtextid.repo.UserRepository;
import com.example.selfgeneratedtextid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository ;
    @Override
    public User addUser(User user) {
         return  userRepository.save(user);
    }
}
