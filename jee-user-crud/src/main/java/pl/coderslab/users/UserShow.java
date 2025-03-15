package pl.coderslab.users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.io.IOException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.read(id);
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/users/show.jsp").forward(req, resp);
    }
}
