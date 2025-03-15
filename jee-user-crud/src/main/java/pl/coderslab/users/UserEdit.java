package pl.coderslab.users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.io.IOException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.read(id);
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/users/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("userName");
        String email = req.getParameter("userEmail");
        String password = req.getParameter("userPassword");
        UserDao userDao = new UserDao();
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(password);
        userDao.update(user);
        resp.sendRedirect("/user/list");
    }
}
