package com.just.todo.it.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "is_logged_in", columnDefinition = "boolean default false")
    private boolean isLoggedIn;

    @Column(name = "credentials")
    @Embedded
    private UserCredentials userCredentials;

    public UserInfo() {
    }

    public UserInfo(String firstName, String lastName, boolean isLoggedIn, UserCredentials userCredentials) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userCredentials = userCredentials;
        this.isLoggedIn = isLoggedIn;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isLoggedIn=" + isLoggedIn +
                ", userCredentials=" + userCredentials +
                '}';
    }
}
