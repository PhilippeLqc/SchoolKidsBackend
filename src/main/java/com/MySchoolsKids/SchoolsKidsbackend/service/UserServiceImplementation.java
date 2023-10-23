package com.MySchoolsKids.SchoolsKidsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.MySchoolsKids.SchoolsKidsbackend.model.User;
import com.MySchoolsKids.SchoolsKidsbackend.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired

    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User fetchUserByEmailAndPassword(String tempEmail, String tempPassword) {
        User user = userRepository.findByEmail(tempEmail);
        if (user != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(tempPassword, user.getPassword())) {
                return user;
            }
        }
        return null;

    }

    @Override
    public User fetchUserByEmail(String tempEmail) {
        return userRepository.findByEmail(tempEmail);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
