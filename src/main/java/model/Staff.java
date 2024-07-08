package model;

public class Staff {
    private int staffID;
    private String staffName;
    private String staffUsername;
    private String staffPassword;
    private String staffEmail;
    private String staffRole;
    private int adminID;

    // Constructors
    public Staff() { }

    public Staff(String staffName, String staffUsername, String staffPassword, String staffEmail) {
        this.staffName = staffName;
        this.staffUsername = staffUsername;
        this.staffPassword = staffPassword;
        this.staffEmail = staffEmail;
    }

    public Staff(int staffID, String staffName, String staffUsername, String staffPassword, String staffEmail) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffUsername = staffUsername;
        this.staffPassword = staffPassword;
        this.staffEmail = staffEmail;
    }

    // Getters and Setters
    public int getStaffID() { return staffID; }
    public void setStaffID(int staffID) { this.staffID = staffID; }

    public String getStaffName() { return staffName; }
    public void setStaffName(String staffName) { this.staffName = staffName; }

    public String getStaffUsername() { return staffUsername; }
    public void setStaffUsername(String staffUsername) { this.staffUsername = staffUsername; }

    public String getStaffPassword() { return staffPassword; }
    public void setStaffPassword(String staffPassword) { this.staffPassword = staffPassword; }

    public String getStaffEmail() { return staffEmail; }
    public void setStaffEmail(String staffEmail) { this.staffEmail = staffEmail; }

    public String getStaffRole() { return staffRole; }
    public void setStaffRole(String staffRole) { this.staffRole = staffRole; }

    public int getAdminID() { return adminID; }
    public void setAdminID(int adminID) { this.adminID = adminID; }
}
