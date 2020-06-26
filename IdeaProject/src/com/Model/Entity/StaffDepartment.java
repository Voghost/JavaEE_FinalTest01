package com.Model.Entity;

/**
 * Created by Edgar Liu
 */
public class StaffDepartment {
    String StaffId;
    String DepartmentId;

    public StaffDepartment() {
    }

    public StaffDepartment(String staffId, String departmentId) {
        StaffId = staffId;
        DepartmentId = departmentId;
    }

    public String getStaffId() {
        return StaffId;
    }

    public void setStaffId(String staffId) {
        StaffId = staffId;
    }

    public String getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(String departmentId) {
        DepartmentId = departmentId;
    }

    @Override
    public String toString() {
        return "StaffDepartment{" +
                "StaffId='" + StaffId + '\'' +
                ", DepartmentId='" + DepartmentId + '\'' +
                '}';
    }
}
