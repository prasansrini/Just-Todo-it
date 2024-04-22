package com.just.todo.it.util;

import com.just.todo.it.model.BackendModel;
import com.just.todo.it.model.UserInfo;

import java.util.List;

public class ResponseTranslatorUtil<V, U> {

    public BackendModel.ResponseUserModel getTranslatedResponse(UserInfo userInfo) {
        return new BackendModel.ResponseUserModel(userInfo.getUserId(), userInfo.getFirstName(), userInfo.getLastName(),
                userInfo.isLoggedIn());
    }

    public List<BackendModel.ResponseUserModel> getTranslatedResponseList(List<UserInfo> userInfoList) {
        return userInfoList.stream()
                .map(this::getTranslatedResponse)
                .toList();
    }
}
