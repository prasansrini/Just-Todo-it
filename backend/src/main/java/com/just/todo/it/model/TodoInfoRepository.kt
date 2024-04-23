package com.just.todo.it.model;

import org.springframework.data.jpa.repository.JpaRepository

interface TodoInfoRepository: JpaRepository<TodoInfo, Int> {
}