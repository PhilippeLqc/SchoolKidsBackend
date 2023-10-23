package com.MySchoolsKids.SchoolsKidsbackend.response;

public class UserResponse {
    private String message;
    private String userName;
    private String userEmail;

    public UserResponse() {
    }
        
    public UserResponse(String message, String userName, String userEmail) {
        this.message = message;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    // Getters and Setters

    public String getMessage() {
        return message;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


}