package by.itacademy.filter;

import by.itacademy.filter.util.Attributes;
import by.itacademy.filter.util.Pages;
import by.itacademy.model.Role;
import by.itacademy.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/page/*", filterName = "AuthorizationFilter")
public class AuthorizationFilter extends HttpFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationFilter.class);

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute(Attributes.USER.getName()) != null) {
            String requestURI = req.getRequestURI();
            LOGGER.info(requestURI);
            var user = (User) session.getAttribute(Attributes.USER.getName());
            LOGGER.info(user.toString());
            if (requestURI.equals(Pages.USER.getName()) && user.getRole() == Role.STUDENT ||
                    requestURI.equals(Pages.TEACHER.getName()) && user.getRole() == Role.TEACHER ||
                    requestURI.equals(Pages.ADMIN.getName()) && user.getRole() == Role.ADMIN) {
                chain.doFilter(req, res);
            } else {
                res.sendError(403, "Недостаточно прав для доступа к этой странице!");
                LOGGER.info("Authorization 403 Forbidden");
            }
        } else {
            res.sendError(401, "Для доступа к запрашиваемому ресурсу требуется аутентификация!");
            LOGGER.info("Authorization 401 Unauthorized");
        }
    }
}
