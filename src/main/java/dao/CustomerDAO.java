package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import faq.connection.FAQConnectionManager;
import model.Customer;
import model.Staff;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public Customer login(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer customer = null;

        try {
            con = FAQConnectionManager.getConnection();
            String sql = "SELECT * FROM cust WHERE accusername = ? AND accpassword = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                customer = new Customer();
                customer.setCustId(rs.getInt("custid"));
                customer.setCustName(rs.getString("custname"));
                customer.setAccUsername(rs.getString("accusername"));
                customer.setAccPassword(rs.getString("accpassword"));
                customer.setCustEmail(rs.getString("custemail"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return customer;
    }

    public Staff loginAdmin(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Staff staff = null;

        try {
            con = FAQConnectionManager.getConnection();
            String sql = "SELECT * FROM staff WHERE staffUsername = ? AND staffPassword = ? AND staffRole = 'admin'";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                staff = new Staff();
                staff.setStaffID(rs.getInt("staffID"));
                staff.setStaffName(rs.getString("staffName"));
                staff.setStaffUsername(rs.getString("staffUsername"));
                staff.setStaffPassword(rs.getString("staffPassword"));
                staff.setStaffEmail(rs.getString("staffEmail"));
                staff.setStaffRole(rs.getString("staffRole"));
                staff.setAdminID(rs.getInt("adminID"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return staff;
    }

    public Staff loginStaff(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Staff staff = null;

        try {
            con = FAQConnectionManager.getConnection();
            String sql = "SELECT * FROM staff WHERE staffUsername = ? AND staffPassword = ? AND staffRole = 'staff'";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                staff = new Staff();
                staff.setStaffID(rs.getInt("staffID"));
                staff.setStaffName(rs.getString("staffName"));
                staff.setStaffUsername(rs.getString("staffUsername"));
                staff.setStaffPassword(rs.getString("staffPassword"));
                staff.setStaffEmail(rs.getString("staffEmail"));
                staff.setStaffRole(rs.getString("staffRole"));
                staff.setAdminID(rs.getInt("adminID"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return staff;
    }

    public void addCustomer(Customer customer) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = FAQConnectionManager.getConnection();
            String sql = "INSERT INTO cust(custname, accusername, accpassword, custemail) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, customer.getCustName());
            ps.setString(2, customer.getAccUsername());
            ps.setString(3, customer.getAccPassword());
            ps.setString(4, customer.getCustEmail());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addStaff(Staff staff) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = FAQConnectionManager.getConnection();
            String sql = "INSERT INTO staff(staffName, staffUsername, staffPassword, staffEmail, staffRole) VALUES (?, ?, ?, ?, 'staff')";
            ps = con.prepareStatement(sql);
            ps.setString(1, staff.getStaffName());
            ps.setString(2, staff.getStaffUsername());
            ps.setString(3, staff.getStaffPassword());
            ps.setString(4, staff.getStaffEmail());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteStaff(int staffID) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = FAQConnectionManager.getConnection();
            String sql = "DELETE FROM staff WHERE staffID=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, staffID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Staff> getAllStaffs() {
        List<Staff> staffs = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = FAQConnectionManager.getConnection();
            String sql = "SELECT * FROM staff";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Staff staff = new Staff();
                staff.setStaffID(rs.getInt("staffID"));
                staff.setStaffName(rs.getString("staffName"));
                staff.setStaffUsername(rs.getString("staffUsername"));
                staff.setStaffPassword(rs.getString("staffPassword"));
                staff.setStaffEmail(rs.getString("staffEmail"));
                staffs.add(staff);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return staffs;
    }

    public Staff getStaffById(int staffID) {
        Staff staff = new Staff();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = FAQConnectionManager.getConnection();
            String sql = "SELECT * FROM staff WHERE staffID=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, staffID);
            rs = ps.executeQuery();

            if (rs.next()) {
                staff.setStaffID(rs.getInt("staffID"));
                staff.setStaffName(rs.getString("staffName"));
                staff.setStaffUsername(rs.getString("staffUsername"));
                staff.setStaffPassword(rs.getString("staffPassword"));
                staff.setStaffEmail(rs.getString("staffEmail"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return staff;
    }

    public void updateStaff(Staff staff) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = FAQConnectionManager.getConnection();
            String sql = "UPDATE staff SET staffName=?, staffUsername=?, staffPassword=?, staffEmail=? WHERE staffID=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, staff.getStaffName());
            ps.setString(2, staff.getStaffUsername());
            ps.setString(3, staff.getStaffPassword());
            ps.setString(4, staff.getStaffEmail());
            ps.setInt(5, staff.getStaffID());

            int rowsUpdated = ps.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
