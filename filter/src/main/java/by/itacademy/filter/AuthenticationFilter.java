package by.itacademy.filter;

import by.itacademy.repository.factory.RepositoryFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/login.do")
public class AuthenticationFilter extends AbstractFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        super.doFilter(servletRequest, servletResponse, filterChain);
        servletRequest.getCharacterEncoding();
        String login = servletRequest.getParameter("login");
        String password = servletRequest.getParameter("password");
        var userRepository = RepositoryFactory.getFactory().getUserRepository();
        var user = userRepository.findByLoginPass(login, password);
        if (user.isPresent()) {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession();
            session.setAttribute("Authentication", user);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
