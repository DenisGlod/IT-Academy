package by.itacademy.filter;

import by.itacademy.filter.util.Attributes;
import by.itacademy.filter.util.Pages;
import by.itacademy.repository.factory.RepositoryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebFilter(urlPatterns = "/login.do", filterName = "AuthenticationFilter")
public class AuthenticationFilter extends HttpFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Authentication Filter");
        var login = req.getParameter("login");
        var password = req.getParameter("password");
        LOGGER.info("login {}", login);
        LOGGER.info("password {}", password);
        boolean flag = true;
        if (Objects.nonNull(login) && Objects.nonNull(password) && !login.isEmpty() && !password.isEmpty()) {
            var byLoginPass = RepositoryFactory.getFactory().getUserRepository().findByLoginPass(login, password);
            if (byLoginPass.isPresent()) {
                flag = false;
                var session = req.getSession();
                session.setAttribute(Attributes.USER.getName(), byLoginPass.get());
                chain.doFilter(req, res);
            }
        }
        if (flag) {
            req.setAttribute(Attributes.EXCEPTION_FLAG.getName(), true);
            req.setAttribute(Attributes.EXCEPTION_MESSAGE.getName(), "Неверный логин или пароль, либо такого пользователя не существует!");
            req.getRequestDispatcher(Pages.INDEX.getName()).forward(req, res);
        }
    }
}
