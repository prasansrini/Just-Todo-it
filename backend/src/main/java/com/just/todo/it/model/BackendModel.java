package com.just.todo.it.model;

public class BackendModel {
    public record ResponseUserModel(int userId, String FirstName, String lastName, boolean isLoggedIn) {
        @Override
        public String toString() {
            return "ResponseUserModel{" +
                    "userId=" + userId +
                    ", FirstName='" + FirstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", isLoggedIn=" + isLoggedIn +
                    '}';
        }
    }
}
