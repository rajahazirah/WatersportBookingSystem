package controller;

import dao.BookingDAO;
import model.Booking;
import model.Customer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/BookingController")
public class BookingController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private BookingDAO bookingDao;

    public BookingController() {
        super();
        bookingDao = new BookingDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selectedActivities = request.getParameterValues("selectedActivities");

        if (selectedActivities != null) {
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            int custId = customer.getCustId();

            List<Booking> bookings = new ArrayList<>();
            for (String actIdStr : selectedActivities) {
                int actId = Integer.parseInt(actIdStr);
                String dateTimeStr = request.getParameter(actId + "_date");
                Date bookingDate = java.sql.Date.valueOf(dateTimeStr.split("T")[0]);
                Date bookingTime = java.sql.Timestamp.valueOf(dateTimeStr.replace("T", " ") + ":00");

                Booking booking = new Booking();
                booking.setBookingTime(bookingTime);
                booking.setBookingDate(bookingDate);
                booking.setCustId(custId);
                booking.setActId(actId);

                bookings.add(booking);
                try {
                    bookingDao.addBooking(booking);
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new ServletException(e);
                }
            }

            session.setAttribute("bookings", bookings);
        }
        response.sendRedirect("payment.jsp");
    }
}
