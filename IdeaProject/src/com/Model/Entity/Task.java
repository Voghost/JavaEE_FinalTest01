package com.Model.Entity;

/**
 * Created by Edgar Liu
 */
public class Task {
    String TaskId;
    String TaskName;
    String TaskRemark;
    String TaskStartDate;
    String TaskEndDate;

    public Task() {
    }

    public Task(String taskId, String taskName, String taskRemark, String taskStartDate, String taskEndDate) {
        TaskId = taskId;
        TaskName = taskName;
        TaskRemark = taskRemark;
        TaskStartDate = taskStartDate;
        TaskEndDate = taskEndDate;
    }

    public String getTaskId() {
        return TaskId;
    }

    public void setTaskId(String taskId) {
        TaskId = taskId;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public String getTaskRemark() {
        return TaskRemark;
    }

    public void setTaskRemark(String taskRemark) {
        TaskRemark = taskRemark;
    }

    public String getTaskStartDate() {
        return TaskStartDate;
    }

    public void setTaskStartDate(String taskStartDate) {
        TaskStartDate = taskStartDate;
    }

    public String getTaskEndDate() {
        return TaskEndDate;
    }

    public void setTaskEndDate(String taskEndDate) {
        TaskEndDate = taskEndDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "TaskId='" + TaskId + '\'' +
                ", TaskName='" + TaskName + '\'' +
                ", TaskRemark='" + TaskRemark + '\'' +
                ", TaskStartDate='" + TaskStartDate + '\'' +
                ", TaskEndDate='" + TaskEndDate + '\'' +
                '}';
    }
}
