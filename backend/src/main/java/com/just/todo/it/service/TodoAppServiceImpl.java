package com.just.todo.it.service;

import com.just.todo.it.model.TodoInfo;
import com.just.todo.it.model.UserInfo;
import com.just.todo.it.repository.TodoAppRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class TodoAppServiceImpl implements TodoAppService {
    private final TodoAppRepo mTodoAppRepo;

    @Autowired
    public TodoAppServiceImpl(TodoAppRepo todoAppRepo) {
        this.mTodoAppRepo = todoAppRepo;
    }

    @Override
    public UserInfo registerUser(UserInfo userInfo) {
        return mTodoAppRepo.registerUser(userInfo);
    }

    @Override
    public Map<UserInfo, List<TodoInfo>> getTodoListByUser(UserInfo userInfo) {
        return mTodoAppRepo.getTodoListByUser(userInfo);
    }

    @Override
    public TodoInfo createTodo(TodoInfo todoInfo) {
        return mTodoAppRepo.createTodo(todoInfo);
    }

    @Override
    public Map<UserInfo, List<TodoInfo>> getClosedTodoListByUser(UserInfo userInfo) {
        return mTodoAppRepo.getClosedTodoListByUser(userInfo);
    }

    @Override
    public Map<UserInfo, List<TodoInfo>> getOpenTodoListByUser(UserInfo userInfo) {
        return mTodoAppRepo.getOpenTodoListByUser(userInfo);
    }

    @Override
    public Map<UserInfo, List<TodoInfo>> getDeletedTodoListByUser(UserInfo userInfo) {
        return mTodoAppRepo.getDeletedTodoListByUser(userInfo);
    }

    @Override
    public void deleteTodo(int todoId) {
        mTodoAppRepo.deleteTodo(todoId);
    }

    @Override
    public void updateTodo(TodoInfo todoInfo) {
        mTodoAppRepo.updateTodo(todoInfo);
    }

    @Override
    public boolean verifyLogin(UserInfo userInfo) {
        return mTodoAppRepo.verifyLogin(userInfo);
    }

    @Override
    public boolean isLoggedIn(UserInfo userInfo) {
        return mTodoAppRepo.isLoggedIn(userInfo);
    }

    @Override
    public UserInfo logout(UserInfo userInfo) {
        return mTodoAppRepo.logout(userInfo);
    }
}
