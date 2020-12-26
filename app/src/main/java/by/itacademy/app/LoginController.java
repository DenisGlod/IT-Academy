package by.itacademy.app;

import by.itacademy.filter.util.Attributes;
import by.itacademy.filter.util.Pages;
import by.itacademy.model.Topic;
import by.itacademy.model.User;
import by.itacademy.repository.factory.RepositoryFactory;
import by.itacademy.service.UserService;
import by.itacademy.service.bean.GroupBean;
import by.itacademy.service.factory.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/login.do", name = "LoginController")
public class LoginController extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute(Attributes.USER.getName());
        if (Objects.isNull(user)) {
            resp.sendError(401, "Для доступа к запрашиваемому ресурсу требуется аутентификация!");
            LOGGER.info("Authorization 401 Unauthorized");
        }
        switch (user.getRole()) {
            case STUDENT:
                LOGGER.info("Go STUDENT Pages");
                var userService = ServiceFactory.getFactory().getUserService();
                var ratingByUserId = userService.findRatingByUserId(user);
                session.setAttribute(Attributes.GROUPS.getName(), ratingByUserId);
                resp.sendRedirect(Pages.USER.getName());
                break;
            case TEACHER:
                LOGGER.info("Go TEACHER Pages");
                resp.sendRedirect(Pages.TEACHER.getName());
                break;
            case ADMIN:
                LOGGER.info("Go ADMIN Pages");
                resp.sendRedirect(Pages.ADMIN.getName());
                break;
        }
    }
}
