package com.MySchoolsKids.SchoolsKidsbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.MySchoolsKids.SchoolsKidsbackend.model.User;
import com.MySchoolsKids.SchoolsKidsbackend.response.UserResponse;
import com.MySchoolsKids.SchoolsKidsbackend.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // email regex
    private static final String EMAIL_REGEX = "^[\\w!#$%&’*+/=?`{|}~^-]+(\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    // password regex
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&+=]).*$";

    // Register User in MySQL Database
    @PostMapping("/signup")
    public ResponseEntity<UserResponse> saveUser(@RequestBody User user) {
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        String userEmail = user.getEmail();
        String userName = user.getName();
        UserResponse response;

        if (userEmail == null || userName == null || user.getPassword() == null) {
            response = new UserResponse("Champs obligatoires manquants.", null, null);
            return ResponseEntity.badRequest().body(response);
        }

        // email check
        if (!userEmail.matches(EMAIL_REGEX)) {
            response = new UserResponse("E-mail invalide.", null, null);
            return ResponseEntity.badRequest().body(response);
        }

        // check if email is already used
        if (userService.fetchUserByEmail(userEmail) != null) {
            response = new UserResponse("E-mail déjà utilisé.", null, null);
            return ResponseEntity.badRequest().body(response);
        }

        // password check
        if (!user.getPassword().matches(PASSWORD_REGEX)) {
            response = new UserResponse("Le mot de passe ne respecte pas les critères de complexité.", null, null);
            return ResponseEntity.badRequest().body(response);
        }

        user.setPassword(encodedPassword);
        User createdUser = userService.saveUser(user);

        response = new UserResponse("Utilisateur enregistré avec succès.", createdUser.getName(),
                createdUser.getEmail());
        return ResponseEntity.ok(response);
    }

    // Login User in MySQL Database
    @PostMapping("/signin")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        String tempPassword = user.getPassword();
        User userObj = null;
        if (tempEmail != null && tempPassword != null) {
            userObj = userService.fetchUserByEmailAndPassword(tempEmail, tempPassword);
        }
        if (userObj == null) {
            throw new Exception(userObj + "Bad Credentials");
        }
        return userObj;
    }

    // get all users
    @GetMapping("/allUsers")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
