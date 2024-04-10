package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataaccesslayer.UserDao;
import dataaccesslayer.UserDaoImpl;
import model.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDao userDao;

    public UserServlet() {
        super();
        userDao = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        User user = new User(name, email, password, userType);

        boolean isUserAdded = UserDao.addUser(user);
        if (isUserAdded) {
            response.sendRedirect("registrationSuccess.jsp");
        } else {
            request.setAttribute("error", "Failed to register user");
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        }
    }
}
