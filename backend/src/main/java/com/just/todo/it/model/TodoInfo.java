package com.just.todo.it.model;

import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class TodoInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int taskId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "title")
    private String taskTitle;

    @Column(name = "description")
    private String taskDescription;

    @Column(name = "due_date")
    private String dueDate;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;

    @Column(name = "is_done", columnDefinition = "boolean default false")
    private boolean isDone;

    public TodoInfo() {
    }

    public TodoInfo(int userId, String taskTitle, String taskDescription, String dueDate, boolean isDeleted,
                    boolean isDone) {
        this.userId = userId;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
        this.isDeleted = isDeleted;
        this.isDone = isDone;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int mTaskId) {
        this.taskId = mTaskId;
    }

    public int getUser() {
        return userId;
    }

    public void setUser(int mUser) {
        this.userId = mUser;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String mTaskTitle) {
        this.taskTitle = mTaskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String mTaskDescription) {
        this.taskDescription = mTaskDescription;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String mDueDate) {
        this.dueDate = mDueDate;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean mIsDeleted) {
        this.isDeleted = mIsDeleted;
    }

    public boolean isIsDone() {
        return isDone;
    }

    public void setIsDone(boolean mIsDone) {
        this.isDone = mIsDone;
    }

    @Override
    public String toString() {
        return "TodoInfo{" +
                "mTaskId=" + taskId +
                ", mUser=" + userId +
                ", mTaskTitle='" + taskTitle + '\'' +
                ", mTaskDescription='" + taskDescription + '\'' +
                ", mDueDate='" + dueDate + '\'' +
                ", mIsDeleted=" + isDeleted +
                ", mIsDone=" + isDone +
                '}';
    }
}
