package com.Model.Entity;

public class StaffProject {
    String staffId=null;
    String ProjectId=null;

    public StaffProject() {
    }

    public StaffProject(String staffId, String projectId) {
        this.staffId = staffId;
        ProjectId = projectId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getProjectId() {
        return ProjectId;
    }

    public void setProjectId(String projectId) {
        ProjectId = projectId;
    }

    @Override
    public String toString() {
        return "StaffProject{" +
                "staffId='" + staffId + '\'' +
                ", ProjectId='" + ProjectId + '\'' +
                '}';
    }
}
