package com.Model.Entity;

/**
 * Created by Edgar Liu
 */
public class Task {

    String taskId=null;
    String taskName=null;
    String taskRemark=null;
    String taskStartDate=null;
    String taskEndDate=null;

    public Task() {
    }

    public Task(String taskId, String taskName, String taskRemark, String taskStartDate, String taskEndDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskRemark = taskRemark;
        this.taskStartDate = taskStartDate;
        this.taskEndDate = taskEndDate;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskRemark() {
        return taskRemark;
    }

    public void setTaskRemark(String taskRemark) {
        this.taskRemark = taskRemark;
    }

    public String getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(String taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public String getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(String taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskRemark='" + taskRemark + '\'' +
                ", taskStartDate='" + taskStartDate + '\'' +
                ", taskEndDate='" + taskEndDate + '\'' +
                '}';
    }
}
