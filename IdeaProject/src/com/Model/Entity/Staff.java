package com.Model.Entity;

/**
 * Created by Edgar Liu
 */
public class Staff {
    String staffId;
    String staffName;
    String staffPhone;
    String staffFileID;
    String staffPassword;

    public Staff() {
    }

    public Staff(String staffId, String staffName, String staffPhone, String staffFileID, String staffPassword) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffPhone = staffPhone;
        this.staffFileID = staffFileID;
        this.staffPassword = staffPassword;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffFileID() {
        return staffFileID;
    }

    public void setStaffFileID(String staffFileID) {
        this.staffFileID = staffFileID;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId='" + staffId + '\'' +
                ", staffName='" + staffName + '\'' +
                ", staffPhone='" + staffPhone + '\'' +
                ", staffFileID='" + staffFileID + '\'' +
                ", staffPassword='" + staffPassword + '\'' +
                '}';
    }
}
