package com.Model.Entity;

public class StaffDepartment {
	String staffId = null;
	String departmentId = null;

	public StaffDepartment() {
	}

	public StaffDepartment(String staffId, String departmentId) {
		this.staffId = staffId;
		this.departmentId = departmentId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "StaffDepartment{" +
		       "staffId='" + staffId + '\'' +
		       ", departmentId='" + departmentId + '\'' +
		       '}';
	}
}
