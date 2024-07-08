package dao;

import model.Booking;
import faq.connection.FAQConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingDAO {

    public void addBooking(Booking booking) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = FAQConnectionManager.getConnection();
            String sql = "INSERT INTO Booking (bookingTime, bookingDate, custId, actId) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setTimestamp(1, new java.sql.Timestamp(booking.getBookingTime().getTime()));
            ps.setDate(2, new java.sql.Date(booking.getBookingDate().getTime()));
            ps.setInt(3, booking.getCustId());
            ps.setInt(4, booking.getActId());
            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
    }
}
