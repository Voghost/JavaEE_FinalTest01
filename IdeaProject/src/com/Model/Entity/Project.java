package com.Model.Entity;

/**
 * Created by Edgar Liu
 */
public class Project {
    String projectId;
    String projectName;
    String projectPathId;
    String projectRemark;

    public Project() {
    }

    public Project(String projectId, String projectName, String projectPathId, String projectRemark) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectPathId = projectPathId;
        this.projectRemark = projectRemark;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectPathId() {
        return projectPathId;
    }

    public void setProjectPathId(String projectPathId) {
        this.projectPathId = projectPathId;
    }

    public String getProjectRemark() {
        return projectRemark;
    }

    public void setProjectRemark(String projectRemark) {
        this.projectRemark = projectRemark;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectPathId='" + projectPathId + '\'' +
                ", projectRemark='" + projectRemark + '\'' +
                '}';
    }
}
