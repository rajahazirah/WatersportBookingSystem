package dao;

import model.Payment;
import faq.connection.FAQConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAO {

    public void addPayment(Payment payment) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = FAQConnectionManager.getConnection();
            ps = con.prepareStatement("INSERT INTO payment (custId, paymentType) VALUES (?, ?)", new String[] { "paymentid" });
            ps.setInt(1, payment.getCustId());
            ps.setString(2, payment.getPaymentType());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    payment.setPaymentId(rs.getInt(1)); // Get the generated paymentId
                }
            }
        } finally {
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
    }
}
