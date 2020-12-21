package by.itacademy.app;

import by.itacademy.model.User;
import by.itacademy.repository.factory.RepositoryFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/login.do")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        var userRepository = RepositoryFactory.getFactory().getUserRepository();
        Optional<User> byLogin = userRepository.findByLoginPass(login, password);
    }
}
