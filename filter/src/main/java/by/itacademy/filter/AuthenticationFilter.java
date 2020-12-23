package by.itacademy.filter;

import by.itacademy.filter.util.Attributes;
import by.itacademy.filter.util.Pages;
import by.itacademy.repository.factory.RepositoryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/login.do")
public class AuthenticationFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("AuthenticationFilter doFilter");
        LOGGER.info("servletRequest.getCharacterEncoding() {}", servletRequest.getCharacterEncoding());
        LOGGER.info("servletResponse.getCharacterEncoding() {}", servletResponse.getCharacterEncoding());
        String login = servletRequest.getParameter("login");
        String password = servletRequest.getParameter("password");
        var user = RepositoryFactory.getFactory().getUserRepository().findByLoginPass(login, password);
        if (user.isPresent()) {
            LOGGER.info("Authentication Success");
            HttpSession session = ((HttpServletRequest) servletRequest).getSession();
            session.setAttribute(Attributes.USER.getName(), user.get());
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            LOGGER.info("Authentication failed");
            servletRequest.setAttribute(Attributes.EXCEPTION_FLAG.getName(), true);
            servletRequest.setAttribute(Attributes.EXCEPTION_MESSAGE.getName(), "Неверный логин или пароль, либо такого пользователя не существует!");
            servletRequest.getRequestDispatcher(Pages.LOGIN.getName()).forward(servletRequest, servletResponse);
        }
    }
}
