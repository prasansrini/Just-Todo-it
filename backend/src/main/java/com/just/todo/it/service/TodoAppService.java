package com.just.todo.it.service;

import com.just.todo.it.model.TodoInfo;
import com.just.todo.it.model.UserInfo;

import java.util.List;
import java.util.Map;

public interface TodoAppService {
    UserInfo registerUser(UserInfo userInfo);

    Map<UserInfo, List<TodoInfo>> getTodoListByUser(UserInfo userInfo);

    TodoInfo createTodo(TodoInfo todoInfo);

    Map<UserInfo, List<TodoInfo>> getClosedTodoListByUser(UserInfo userInfo);

    Map<UserInfo, List<TodoInfo>> getOpenTodoListByUser(UserInfo userInfo);

    Map<UserInfo, List<TodoInfo>> getDeletedTodoListByUser(UserInfo userInfo);

    void deleteTodo(int todoId);

    void updateTodo(TodoInfo todoInfo);

    String verifyLogin(UserInfo userInfo);

    boolean isLoggedIn(UserInfo userInfo);

    UserInfo logout(UserInfo userInfo);

    UserInfo getUserById(int userId);
}
