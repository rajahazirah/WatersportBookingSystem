package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Activity;
import faq.connection.FAQConnectionManager;

public class ActivityDAO {

    public void addActivity(Activity activity) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = FAQConnectionManager.getConnection();
            ps = con.prepareStatement("INSERT INTO act (actname, actdesc, actprice, actpax) VALUES (?, ?, ?, ?)");
            ps.setString(1, activity.getActname());
            ps.setString(2, activity.getActdesc());
            ps.setDouble(3, activity.getActprice());
            ps.setString(4, activity.getActpax());
            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
    }

    public void updateActivity(Activity activity) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = FAQConnectionManager.getConnection();
            ps = con.prepareStatement("UPDATE act SET actname = ?, actdesc = ?, actprice = ?, actpax = ? WHERE actid = ?");
            ps.setString(1, activity.getActname());
            ps.setString(2, activity.getActdesc());
            ps.setDouble(3, activity.getActprice());
            ps.setString(4, activity.getActpax());
            ps.setInt(5, activity.getActid());
            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
    }

    public List<Activity> getAllActivities() throws SQLException {
        List<Activity> activities = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = FAQConnectionManager.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM act");

            while (rs.next()) {
                Activity activity = new Activity();
                activity.setActid(rs.getInt("actid"));
                activity.setActname(rs.getString("actname"));
                activity.setActdesc(rs.getString("actdesc"));
                activity.setActprice(rs.getDouble("actprice"));
                activity.setActpax(rs.getString("actpax"));
                activities.add(activity);
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        }
        return activities;
    }

    public Activity getActivityById(int actId) throws SQLException {
        Activity activity = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = FAQConnectionManager.getConnection();
            ps = con.prepareStatement("SELECT * FROM act WHERE actid = ?");
            ps.setInt(1, actId);
            rs = ps.executeQuery();

            if (rs.next()) {
                activity = new Activity();
                activity.setActid(rs.getInt("actid"));
                activity.setActname(rs.getString("actname"));
                activity.setActdesc(rs.getString("actdesc"));
                activity.setActprice(rs.getDouble("actprice"));
                activity.setActpax(rs.getString("actpax"));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
        return activity;
    }

    public void deleteActivity(int actId) throws SQLException {
        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            con = FAQConnectionManager.getConnection();

            // First, delete related rows in the watersport table
            ps1 = con.prepareStatement("DELETE FROM watersport WHERE actid = ?");
            ps1.setInt(1, actId);
            ps1.executeUpdate();

            // Then, delete the activity
            ps2 = con.prepareStatement("DELETE FROM act WHERE actid = ?");
            ps2.setInt(1, actId);
            ps2.executeUpdate();
        } finally {
            if (ps1 != null) ps1.close();
            if (ps2 != null) ps2.close();
            if (con != null) con.close();
        }
    }

}
