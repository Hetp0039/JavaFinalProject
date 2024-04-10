package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataaccesslayer.RetailerDao;
import dataaccesslayer.RetailerDaoImpl;
import model.Retailer;

@WebServlet("/RetailerServlet")
public class RetailerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    RetailerDao retailerDao;

    public RetailerServlet() {
        super();
        retailerDao = new RetailerDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Retailer retailer = new Retailer(name, email, password, "Retailer");

        boolean isRetailerAdded = RetailerDao.addRetailer(retailer);
        if (isRetailerAdded) {
            response.sendRedirect("registrationSuccess.jsp");
        } else {
            request.setAttribute("error", "Failed to register retailer");
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        }
    }
}
