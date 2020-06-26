package com.Model.Entity;

/**
 * Created by Edgar Liu
 */
public class StaffProject {
    String StaffId;
    String ProjectId;

    public StaffProject() {
    }

    public StaffProject(String staffId, String projectId) {
        StaffId = staffId;
        ProjectId = projectId;
    }

    public String getStaffId() {
        return StaffId;
    }

    public void setStaffId(String staffId) {
        StaffId = staffId;
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
                "StaffId='" + StaffId + '\'' +
                ", ProjectId='" + ProjectId + '\'' +
                '}';
    }
}
