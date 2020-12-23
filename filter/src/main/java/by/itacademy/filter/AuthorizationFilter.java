package by.itacademy.filter;

import by.itacademy.filter.util.Attributes;
import by.itacademy.filter.util.Pages;
import by.itacademy.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter(urlPatterns = {"/admin.html", "/teacher.html", "/user.html"})
public class AuthorizationFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("AuthorizationFilter doFilter");
        HttpSession session = ((HttpServletRequest) request).getSession();
        var user = (User) session.getAttribute(Attributes.USER.getName());
        if (Objects.isNull(user)) {
            LOGGER.info("isNull(user)");
            ((HttpServletResponse) response).sendRedirect(Pages.PAGE401.getName());
            return;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(Pages.PAGE401.getName());
        LOGGER.info("RequestURL {}", ((HttpServletRequest) request).getRequestURI());
        switch (user.getRole()) {
            case STUDENT:
                dispatcher = request.getRequestDispatcher(Pages.USER.getName());
                break;
            case TEACHER:
                dispatcher = request.getRequestDispatcher(Pages.TEACHER.getName());
                break;
            case ADMINISTRATOR:
                dispatcher = request.getRequestDispatcher(Pages.ADMIN.getName());
                break;
        }
        dispatcher.forward(request, response);
    }
}
