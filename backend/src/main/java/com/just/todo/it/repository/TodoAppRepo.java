package com.just.todo.it.repository;

import com.just.todo.it.model.TodoInfo;
import com.just.todo.it.model.UserInfo;

import java.util.List;
import java.util.Map;

public interface TodoAppRepo {
    UserInfo registerUser(UserInfo userInfo);

    Map<Integer, List<TodoInfo>> getTodoListByUser(int userId);

    TodoInfo createTodo(TodoInfo todoInfo);

    Map<UserInfo, List<TodoInfo>> getClosedTodoListByUser(UserInfo userInfo);

    Map<UserInfo, List<TodoInfo>> getOpenTodoListByUser(UserInfo userInfo);

    Map<UserInfo, List<TodoInfo>> getDeletedTodoListByUser(UserInfo userInfo);

    void deleteTodo(int todoId);

    void updateTodo(TodoInfo todoInfo);

    boolean verifyLogin(UserInfo userInfo);

    boolean isLoggedIn(int userId);

    UserInfo logout(UserInfo userInfo);

    UserInfo getUserById(int userId);
}
