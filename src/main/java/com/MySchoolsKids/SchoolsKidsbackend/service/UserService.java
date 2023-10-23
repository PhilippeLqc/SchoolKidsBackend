package com.MySchoolsKids.SchoolsKidsbackend.service;

import com.MySchoolsKids.SchoolsKidsbackend.model.User;

public interface UserService {

    public User saveUser(User user); // Save user to database

    public User fetchUserByEmailAndPassword(String tempEmail, String tempPassword);

    public User fetchUserByEmail(String tempEmail);

    public Iterable<User> getAllUsers();
}
