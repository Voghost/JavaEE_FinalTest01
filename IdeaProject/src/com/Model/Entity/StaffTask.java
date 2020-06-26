package com.Model.Entity;

public class StaffTask {

    String staffId=null;
    String taskId=null;

    public StaffTask() {
    }

    public StaffTask(String staffId, String taskId) {
        this.staffId = staffId;
        this.taskId = taskId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "StaffTask{" +
                "staffId='" + staffId + '\'' +
                ", taskId='" + taskId + '\'' +
                '}';
    }
}
