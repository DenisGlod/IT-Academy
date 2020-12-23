package by.itacademy.app;

import by.itacademy.filter.util.Attributes;
import by.itacademy.filter.util.Pages;
import by.itacademy.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login.do")
public class LoginController extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("LoginController doPost");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(Attributes.USER.getName());
        LOGGER.info(user.toString());
        switch (user.getRole()) {
            case STUDENT:
                req.getRequestDispatcher(Pages.USER.getName()).forward(req, resp);
                break;
            case TEACHER:
                req.getRequestDispatcher(Pages.TEACHER.getName()).forward(req, resp);
                break;
            case ADMINISTRATOR:
                req.getRequestDispatcher(Pages.ADMIN.getName()).forward(req, resp);
                break;
        }
        LOGGER.info("LoginController doPost End");
    }
}
