package controller;

import dao.PaymentDAO;
import model.Payment;
import model.Customer;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private PaymentDAO paymentDao;

    public PaymentController() {
        super();
        paymentDao = new PaymentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        int custId = customer.getCustId();

        String paymentType = request.getParameter("payment");

        if (paymentType == null || paymentType.isEmpty()) {
            request.setAttribute("errorMessage", "Payment type is required.");
            request.getRequestDispatcher("payment.jsp").forward(request, response);
            return;
        }

        Payment payment = new Payment();
        payment.setCustId(custId);
        payment.setPaymentType(paymentType);

        try {
            paymentDao.addPayment(payment);
            int paymentId = payment.getPaymentId(); // Get the paymentId from the payment object
            System.out.println("Payment ID: " + paymentId); // Debugging log
            session.setAttribute("payment", payment);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

        response.sendRedirect("confirmation.jsp");
    }
}
