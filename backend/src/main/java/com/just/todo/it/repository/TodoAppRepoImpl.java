package com.just.todo.it.repository;

import com.just.todo.it.model.TodoInfo;
import com.just.todo.it.model.UserInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public class TodoAppRepoImpl implements TodoAppRepo {
    private final EntityManager mEntityManager;

    @Autowired
    public TodoAppRepoImpl(EntityManager entityManager) {
        mEntityManager = entityManager;
    }

    @Override
    @Transactional
    public UserInfo registerUser(UserInfo userInfo) {
        mEntityManager.persist(userInfo);

        System.out.println(userInfo);

        return mEntityManager.find(UserInfo.class, userInfo.getUserId());
    }

    @Override
    public TodoInfo createTodo(TodoInfo todoInfo) {
        mEntityManager.persist(todoInfo);

        return mEntityManager.find(TodoInfo.class, todoInfo.getTaskId());
    }

    @Override
    public Map<Integer, List<TodoInfo>> getTodoListByUser(int userId) {
        TypedQuery<TodoInfo> query = mEntityManager.createQuery("FROM TodoInfo", TodoInfo.class);

        return Map.of(userId,
                query.getResultList().stream().filter(t -> t.getUserId() == userId).toList());
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
    public boolean isLoggedIn(int userId) {
        return mEntityManager.find(UserInfo.class, userId).isLoggedIn();
    }

    @Override
    @Transactional
    public boolean verifyLogin(UserInfo userInfo) {
        UserInfo userInfoDb = mEntityManager.find(UserInfo.class, userInfo.getUserId());

        if (userInfoDb == null) {
            return false;
        }

        if (!userInfo.getUserCredentials().getUserName().equals(userInfoDb.getUserCredentials().getUserName())) {
            return false;
        }

        if (userInfo.getUserCredentials().getPassword().equals(userInfoDb.getUserCredentials().getPassword())) {
            userInfoDb.setLoggedIn(true);

            mEntityManager.merge(userInfoDb);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserInfo logout(UserInfo userInfo) {
        userInfo.setLoggedIn(false);

        return mEntityManager.merge(userInfo);
    }

    @Override
    public UserInfo getUserById(int userId) {
        return mEntityManager.find(UserInfo.class, userId);
    }

    @Override
    public void deleteUser(UserInfo userInfo) {
        mEntityManager.remove(mEntityManager.find(UserInfo.class, userInfo.getUserId()));
        System.out.println("Deleted userID: " + userInfo.getUserId());
    }
}
