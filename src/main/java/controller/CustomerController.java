package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import faq.connection.FAQConnectionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import dao.CustomerDAO;
import model.Customer;
import model.Staff;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;

    public CustomerController() {
        super();
        customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Action: " + action);

        if ("register".equalsIgnoreCase(action)) {
            registerCustomer(request, response);
        } else if ("login".equalsIgnoreCase(action)) {
            loginCustomer(request, response);
        } else if ("loginAdmin".equalsIgnoreCase(action)) {
            loginAdmin(request, response);
        } else if ("loginStaff".equalsIgnoreCase(action)) {
            loginStaff(request, response);
        } else if ("addStaff".equalsIgnoreCase(action)) {
            addStaff(request, response);
        } else if ("updateStaff".equalsIgnoreCase(action)) {
            updateStaff(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("GET Action: " + action);

        if ("listStaff".equalsIgnoreCase(action)) {
            listStaff(request, response);
        } else if ("viewStaff".equalsIgnoreCase(action)) {
            viewStaff(request, response);
        } else if ("deleteStaff".equalsIgnoreCase(action)) {
            deleteStaff(request, response);
        }
    }

    private void registerCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String custname = request.getParameter("custname");
        String accusername = request.getParameter("accusername");
        String accpassword = request.getParameter("accpassword");
        String custemail = request.getParameter("custemail");

        Customer customer = new Customer();
        customer.setCustName(custname);
        customer.setAccUsername(accusername);
        customer.setAccPassword(accpassword);
        customer.setCustEmail(custemail);

        customerDAO.addCustomer(customer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("register.html");
        dispatcher.forward(request, response);
    }

    private void loginCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("accusername");
        String password = request.getParameter("accpassword");

        Customer customer = customerDAO.login(username, password);

        if (customer != null) {
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("login.html?error=true");
        }
    }

    private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("accusername");
        String password = request.getParameter("accpassword");

        Staff staff = customerDAO.loginAdmin(username, password);
        System.out.println("Admin Login: " + (staff != null));

        if (staff != null) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", staff);
            response.sendRedirect("indexadmin.html");
        } else {
            response.sendRedirect("login.html?error=true");
        }
    }

    private void loginStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("accusername");
        String password = request.getParameter("accpassword");

        Staff staff = customerDAO.loginStaff(username, password);

        if (staff != null) {
            HttpSession session = request.getSession();
            session.setAttribute("staff", staff);
            response.sendRedirect("indexstaff.html");
        } else {
            response.sendRedirect("login.html?error=true");
        }
    }

    private void addStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accname = request.getParameter("accname");
        String accusername = request.getParameter("accusername");
        String accpassword = request.getParameter("accpassword");
        String accemail = request.getParameter("accemail");

        Staff staff = new Staff(accname, accusername, accpassword, accemail);
        customerDAO.addStaff(staff);

        RequestDispatcher req = request.getRequestDispatcher("addstaff.html");
        req.forward(request, response);
    }

    private void deleteStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int staffID = Integer.parseInt(request.getParameter("staffID"));
        customerDAO.deleteStaff(staffID);

        RequestDispatcher req = request.getRequestDispatcher("CustomerController?action=listStaff");
        req.forward(request, response);
    }

    private void listStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("staffs", customerDAO.getAllStaffs());

        RequestDispatcher req = request.getRequestDispatcher("listStaff.jsp");
        req.forward(request, response);
    }

    private void viewStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int staffID = Integer.parseInt(request.getParameter("staffID"));
        Staff staff = customerDAO.getStaffById(staffID);

        request.setAttribute("staff", staff);

        RequestDispatcher req = request.getRequestDispatcher("updateStaff.jsp");
        req.forward(request, response);
    }


    private void updateStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int staffID = Integer.parseInt(request.getParameter("staffID"));
            String staffName = request.getParameter("staffName");
            String staffUsername = request.getParameter("staffUsername");
            String staffPassword = request.getParameter("staffPassword");
            String staffEmail = request.getParameter("staffEmail");

            System.out.println("Updating Staff ID: " + staffID);
            System.out.println("Name: " + staffName);
            System.out.println("Username: " + staffUsername);
            System.out.println("Password: " + staffPassword);
            System.out.println("Email: " + staffEmail);

            Staff staff = new Staff(staffID, staffName, staffUsername, staffPassword, staffEmail);
            customerDAO.updateStaff(staff);
            System.out.println("Update successful");

            response.sendRedirect("CustomerController?action=listStaff");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Update failed: " + e.getMessage());
            response.sendRedirect("errorPage.jsp");
        }
    }




}
