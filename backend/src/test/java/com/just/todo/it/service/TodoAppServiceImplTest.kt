package com.just.todo.it.service

import com.just.todo.it.model.UserCredentials
import com.just.todo.it.model.UserInfo
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class TodoAppServiceImplTest {
    @Autowired
    private val mTodoAppService: TodoAppService? = null

    private var mUserInfo: UserInfo? = null

    @AfterEach
    fun resetCurrent() {
        if (mUserInfo != null) {
            mTodoAppService!!.deleteUser(mUserInfo)
        }
    }

    @Test
    fun registerUser() {
        val userInfo = UserInfo(
            "testFirstName", "testLastName", false,
            UserCredentials("test", "testPassword")
        )

        val result = mTodoAppService!!.registerUser(userInfo)

        Assertions.assertEquals(userInfo.userId, result.userId)
        Assertions.assertNotEquals(userInfo.userId, 0)

        mUserInfo = userInfo
    }

    @Test
    fun todoListByUserTest() {
    }

    @Test
    fun createTodo() {
    }

    @Test
    fun closedTodoListByUser() {
    }

    @Test
    fun openTodoListByUser() {
    }

    @Test
    fun deletedTodoListByUser() {
    }

    @Test
    fun deleteTodo() {
    }

    @Test
    fun updateTodo() {
    }

    @Test
    fun verifyLogin() {
    }

    @Test
    fun isLoggedIn() {
    }

    @Test
    fun logout() {
    }

    @Test
    fun userById() {
    }
}