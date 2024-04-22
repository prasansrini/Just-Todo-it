package com.just.todo.it.service;

import com.just.todo.it.model.TodoInfo;
import com.just.todo.it.model.UserInfo;
import com.just.todo.it.repository.TodoAppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
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
    public Map<Integer, List<TodoInfo>> getTodoListByUser(int userInfo) {
        return mTodoAppRepo.getTodoListByUser(userInfo);
    }

    @Override
    @Transactional
    public TodoInfo createTodo(TodoInfo todoInfo) {
        if (mTodoAppRepo.isLoggedIn(todoInfo.getUserId())) {
            return mTodoAppRepo.createTodo(todoInfo);
        } else {
            return null;
        }
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
    @Transactional
    public void deleteTodo(int todoId) {
        mTodoAppRepo.deleteTodo(todoId);
    }

    @Override
    @Transactional
    public void updateTodo(TodoInfo todoInfo) {
        mTodoAppRepo.updateTodo(todoInfo);
    }

    @Override
    public String verifyLogin(UserInfo userInfo) {
        if (mTodoAppRepo.verifyLogin(userInfo)) {
            return mTodoAppRepo.getUserById(userInfo.getUserId()).toString();
        } else {
            return "User not found or wrong credentials!";
        }
    }

    @Override
    public boolean isLoggedIn(int userId) {
        return mTodoAppRepo.isLoggedIn(userId);
    }

    @Override
    @Transactional
    public UserInfo logout(UserInfo userInfo) {
        return mTodoAppRepo.logout(userInfo);
    }

    @Override
    public UserInfo getUserById(int userId) {
        return mTodoAppRepo.getUserById(userId);
    }
}
