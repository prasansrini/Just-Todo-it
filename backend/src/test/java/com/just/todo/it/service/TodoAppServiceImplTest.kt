package com.just.todo.it.service;

import com.just.todo.it.model.UserInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoAppServiceImplTest {
    @Autowired
    private TodoAppService mTodoAppService;

    @Test
    void registerUser() {
        mTodoAppService.registerUser(new UserInfo());
    }

    @Test
    void getTodoListByUser() {
    }

    @Test
    void createTodo() {
    }

    @Test
    void getClosedTodoListByUser() {
    }

    @Test
    void getOpenTodoListByUser() {
    }

    @Test
    void getDeletedTodoListByUser() {
    }

    @Test
    void deleteTodo() {
    }

    @Test
    void updateTodo() {
    }

    @Test
    void verifyLogin() {
    }

    @Test
    void isLoggedIn() {
    }

    @Test
    void logout() {
    }

    @Test
    void getUserById() {
    }
}