package com.just.todo.it.controller;

import com.just.todo.it.model.TodoInfo;
import com.just.todo.it.model.UserInfo;
import com.just.todo.it.service.TodoAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TodoAppController {
    private final TodoAppService todoAppService;

    @Autowired
    public TodoAppController(TodoAppService todoAppService) {
        this.todoAppService = todoAppService;
    }

    @PostMapping("/todo/create")
    public String createTodo(@RequestBody TodoInfo todoInfo) {
        TodoInfo todoInfoResult = todoAppService.createTodo(todoInfo);
        if (todoInfoResult != null) {
            return todoInfoResult.toString();
        } else {
            return "User has to be logged in to create a Todo!";
        }
    }

    @GetMapping("/todo/user")
    public String getTodoByUser(@RequestBody int userId) {
        return todoAppService.getTodoListByUser(userId).toString();
    }

    @PostMapping("/register")
    public UserInfo registerUser(@RequestBody UserInfo userInfo) {
        if (userInfo != null && userInfo.getFirstName() == null && userInfo.getLastName() == null) {
            return null;
        } else {
            return todoAppService.registerUser(userInfo);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserInfo userInfo) {
        return new ResponseEntity<>(todoAppService.verifyLogin(userInfo), HttpStatus.OK);
    }
}
