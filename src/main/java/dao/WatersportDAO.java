package dao;

import java.sql.*;
import model.Watersport;
import faq.connection.FAQConnectionManager;

public class WatersportDAO {

    public Watersport getWatersportById(int actId) throws SQLException {
        Watersport watersport = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = FAQConnectionManager.getConnection();
            ps = con.prepareStatement("SELECT * FROM watersport WHERE actid = ?");
            ps.setInt(1, actId);
            rs = ps.executeQuery();

            if (rs.next()) {
                watersport = new Watersport();
                watersport.setActid(actId);
                watersport.setRound(rs.getInt("round"));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
        return watersport;
    }

    public void updateWatersport(Watersport watersport) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = FAQConnectionManager.getConnection();
            ps = con.prepareStatement("UPDATE watersport SET round = ? WHERE actid = ?");

            ps.setInt(1, watersport.getRound());
            ps.setInt(2, watersport.getActid());

            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
    }
}
