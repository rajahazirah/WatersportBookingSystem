package controller;

import dao.ActivityDAO;
import model.Activity;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/ActivityController")
public class ActivityController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ActivityDAO activityDao;

    public ActivityController() {
        super();
        activityDao = new ActivityDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    addActivity(request, response);
                    break;
                case "update":
                    updateActivity(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    break;
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "list":
                    listActivities(request, response);
                    break;
                case "view":
                    viewActivity(request, response);
                    break;
                case "edit":
                    editActivity(request, response);
                    break;
                case "delete":
                    deleteActivity(request, response);
                    break;
                case "book":  // Add this case for booking page
                    bookActivity(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    break;
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void bookActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Activity> activities = activityDao.getAllActivities();
            request.setAttribute("activities", activities);
            RequestDispatcher req = request.getRequestDispatcher("book.jsp");
            req.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }


    private void addActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actName = request.getParameter("actname");
        String actDesc = request.getParameter("actdesc");
        double actPrice = Double.parseDouble(request.getParameter("actprice"));
        String actPax = request.getParameter("actpax");

        Activity activity = new Activity();
        activity.setActname(actName);
        activity.setActdesc(actDesc);
        activity.setActprice(actPrice);
        activity.setActpax(actPax);

        try {
            activityDao.addActivity(activity);
            response.sendRedirect("ActivityController?action=list&view=admin");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    private void updateActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int actId = Integer.parseInt(request.getParameter("actid"));
        String actName = request.getParameter("actname");
        String actDesc = request.getParameter("actdesc");
        double actPrice = Double.parseDouble(request.getParameter("actprice"));
        String actPax = request.getParameter("actpax");

        Activity activity = new Activity();
        activity.setActid(actId);
        activity.setActname(actName);
        activity.setActdesc(actDesc);
        activity.setActprice(actPrice);
        activity.setActpax(actPax);

        try {
            activityDao.updateActivity(activity);
            response.sendRedirect("ActivityController?action=list&view=admin");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    private void listActivities(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Activity> activities = activityDao.getAllActivities();
            request.setAttribute("acts", activities);

            // Determine which page to forward to
            String view = request.getParameter("view");
            if ("admin".equals(view)) {
                RequestDispatcher req = request.getRequestDispatcher("listAct.jsp");
                req.forward(request, response);
            } else {
                RequestDispatcher req = request.getRequestDispatcher("activities.jsp");
                req.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    private void viewActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int actId = Integer.parseInt(request.getParameter("actid"));
        try {
            Activity activity = activityDao.getActivityById(actId);
            request.setAttribute("activity", activity);
            RequestDispatcher req = request.getRequestDispatcher("viewAct.jsp");
            req.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    private void editActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int actId = Integer.parseInt(request.getParameter("actid"));
        try {
            Activity activity = activityDao.getActivityById(actId);
            request.setAttribute("activity", activity);
            RequestDispatcher req = request.getRequestDispatcher("updateactivities.jsp");
            req.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    private void deleteActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int actId = Integer.parseInt(request.getParameter("actid"));
        try {
            activityDao.deleteActivity(actId);
            response.sendRedirect("ActivityController?action=list&view=admin");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

}
