package com.just.todo.it.service

import com.just.todo.it.JustTodoItApplication
import com.just.todo.it.model.TodoInfo
import com.just.todo.it.model.UserCredentials
import com.just.todo.it.model.UserInfo
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration

@SpringBootTest(classes = [JustTodoItApplication::class])
internal class TodoAppServiceImplTest {

    @Autowired
    private var mTodoAppService: TodoAppService? = null

    @AfterEach
    fun resetCurrentUser() {
        if (mUserInfo != null) {
            mTodoAppService!!.deleteUser(mUserInfo)

            mUserInfo = null
        }
    }

    @Test
    fun registerUser() {
        val userInfo = UserInfo(
            "testFirstName", "testLastName", false, UserCredentials("test", "testPassword")
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

    companion object {
        @Autowired
        private var mTodoAppService: TodoAppService? = null

        private var todoList: MutableList<TodoInfo>? = null
        private var userList: MutableList<UserInfo>? = null

        private var mUserInfo: UserInfo? = null

        fun setup() {
            userList = mutableListOf()
            todoList = mutableListOf()

            for (i in 0..9) {
                var userInfo = UserInfo(
                    "testFirstName$i", "testLastName$i", false, UserCredentials(
                        "testUserName$i", "testPassword$i"
                    )
                )

                userInfo = mTodoAppService!!.registerUser(userInfo)

                userList!! += userInfo

                todoList!! += mTodoAppService!!.createTodo(
                    TodoInfo(
                        userInfo.userId, "taskTitle $i", "taskDesc $i", "${System.currentTimeMillis()}", false, false
                    )
                )
            }
        }

        fun tearDown() {
            if (todoList != null) {
                todoList!!.forEach {
                    mTodoAppService!!.deleteTodo(it.taskId)
                }
            }

            if (userList != null) {
                userList!!.forEach {
                    mTodoAppService!!.deleteUser(it)
                }
            }
        }
    }
}
