package com.just.todo.it.repository

import com.just.todo.it.JustTodoItApplication
import com.just.todo.it.model.UserInfo
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.testng.annotations.Test

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [JustTodoItApplication::class])
@DataJpaTest
public class TodoAppRepoImplTest {
    @Autowired
    private var repository: TodoAppRepoImpl? = null

    @Test
    public fun registerUser() {
        repository!!.registerUser(UserInfo("Prasanna", "Srinivasan", true, null));
    }

    @Test
    fun createTodo() {
    }

    @Test
    fun todoListByUser() {

    }

    @Test
    fun closedTodoListByUser() {
    }

    @Test
    fun deletedTodoListByUser() {
    }

    @Test
    fun openTodoListByUser() {
    }

    @Test
    fun deleteTodo() {
    }

    @Test
    fun updateTodo() {
    }

    @Test
    fun isLoggedIn() {
    }

    @Test
    fun verifyLogin() {
    }

    @Test
    fun logout() {
    }
}