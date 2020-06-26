package com.Model.Entity;

public class StaffProject {
	String staffId = null;
	String projectId = null;

	public StaffProject() {
	}

	public StaffProject(String staffId, String projectId) {
		this.staffId = staffId;
		this.projectId = projectId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "StaffProject{" +
		       "staffId='" + staffId + '\'' +
		       ", ProjectId='" + projectId + '\'' +
		       '}';
	}
}
