package com.just.todo.it.controller;

import com.just.todo.it.model.TodoInfo;
import com.just.todo.it.model.UserInfo;
import com.just.todo.it.service.TodoAppService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public TodoInfo createTodo(@RequestBody TodoInfo todoInfo) {
        return todoAppService.createTodo(todoInfo);
    }

    @GetMapping("/user")
    public String getUser() {
        return todoAppService.getTodoListByUser(new UserInfo()).toString();
    }

    @PostMapping("/register")
    public UserInfo registerUser(@RequestBody UserInfo userInfo) {
        if (userInfo != null && userInfo.getFirstName() == null && userInfo.getLastName() == null) {
            return null;
        } else {
            return todoAppService.registerUser(userInfo);
        }
    }
}
