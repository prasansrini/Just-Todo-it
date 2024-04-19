package com.just.todo.it.repository;

import com.just.todo.it.model.TodoInfo;
import com.just.todo.it.model.UserInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class TodoAppRepoImpl implements TodoAppRepo {
    private final EntityManager mEntityManager;

    @Autowired
    public TodoAppRepoImpl(EntityManager entityManager) {
        mEntityManager = entityManager;
    }

    @Override
    public UserInfo registerUser(UserInfo userInfo) {
        mEntityManager.persist(userInfo);

        return mEntityManager.find(UserInfo.class, userInfo.getUserId());
    }

    @Override
    public TodoInfo createTodo(TodoInfo todoInfo) {
        mEntityManager.persist(todoInfo);

        return mEntityManager.find(TodoInfo.class, todoInfo.getTaskId());
    }

    @Override
    public Map<UserInfo, List<TodoInfo>> getTodoListByUser(UserInfo userInfo) {
        TypedQuery<TodoInfo> query = mEntityManager.createQuery("FROM TodoInfo", TodoInfo.class);

        return Map.of(userInfo,
                query.getResultList().stream().filter(t -> t.getUserId() == userInfo.getUserId()).toList());
    }

    @Override
    public Map<UserInfo, List<TodoInfo>> getClosedTodoListByUser(UserInfo userInfo) {
        TypedQuery<TodoInfo> query = mEntityManager.createQuery("FROM TodoInfo", TodoInfo.class);

        return Map.of(userInfo, query.getResultList().stream().filter(TodoInfo::isDone).toList());
    }

    @Override
    public Map<UserInfo, List<TodoInfo>> getDeletedTodoListByUser(UserInfo userInfo) {
        TypedQuery<TodoInfo> query = mEntityManager.createQuery("FROM TodoInfo", TodoInfo.class);

        return Map.of(userInfo, query.getResultList().stream().filter(TodoInfo::isIsDeleted).toList());
    }

    @Override
    public Map<UserInfo, List<TodoInfo>> getOpenTodoListByUser(UserInfo userInfo) {
        TypedQuery<TodoInfo> query = mEntityManager.createQuery("FROM TodoInfo", TodoInfo.class);

        return Map.of(userInfo, query.getResultList().stream().filter(todoInfo -> !todoInfo.isDone()).toList());
    }

    @Override
    public void deleteTodo(int todoInfoId) {
        TodoInfo todoInfoFromDb = mEntityManager.find(TodoInfo.class, todoInfoId);
        todoInfoFromDb.setIsDeleted(true);

        mEntityManager.merge(todoInfoFromDb);
    }

    @Override
    public void updateTodo(TodoInfo todoInfo) {
        mEntityManager.merge(todoInfo);
    }

    @Override
    public boolean isLoggedIn(UserInfo userInfo) {
        return mEntityManager.find(UserInfo.class, userInfo.getUserId()).isLoggedIn();
    }

    @Override
    public boolean verifyLogin(UserInfo userInfo) {
        UserInfo userInfoDb = mEntityManager.find(UserInfo.class, userInfo.getUserId());

        return userInfo.getUserCredentials().getPassword().equals(userInfoDb.getUserCredentials().getPassword());
    }

    @Override
    public UserInfo logout(UserInfo userInfo) {
        userInfo.setLoggedIn(false);

        return mEntityManager.merge(userInfo);
    }
}
