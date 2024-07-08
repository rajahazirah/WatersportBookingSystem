package dao;

import java.sql.*;
import model.TourBoat;
import faq.connection.FAQConnectionManager;

public class TourBoatDAO {

    public TourBoat getTourBoatById(int actId) throws SQLException {
        TourBoat tourBoat = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = FAQConnectionManager.getConnection();
            ps = con.prepareStatement("SELECT * FROM tour_boat WHERE actid = ?");
            ps.setInt(1, actId);
            rs = ps.executeQuery();

            if (rs.next()) {
                tourBoat = new TourBoat();
                tourBoat.setActid(actId);
                tourBoat.setDuration(rs.getString("duration"));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
        return tourBoat;
    }

    public void updateTourBoat(TourBoat tourBoat) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = FAQConnectionManager.getConnection();
            ps = con.prepareStatement("UPDATE tour_boat SET duration = ? WHERE actid = ?");

            ps.setString(1, tourBoat.getDuration());
            ps.setInt(2, tourBoat.getActid());

            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
    }
}
