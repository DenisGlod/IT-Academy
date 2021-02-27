package by.freebook.view.filter;

import by.freebook.service.UserDataService;
import by.freebook.service.UserService;
import by.freebook.service.bean.UserBean;
import by.freebook.service.bean.UserDataBean;
import by.freebook.service.factory.ServiceFactory;
import by.freebook.view.util.Constant;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;
import java.util.Optional;

@Slf4j
@WebFilter("/login.do")
public class AuthenticationFilter extends HttpUTF8Filter {
    @Serial
    private static final long serialVersionUID = 6230439079516161271L;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        log.info("doFilter");
        String email = req.getParameter(Constant.EMAIL);
        String password = req.getParameter(Constant.PASSWORD);
        var userBean = UserBean.builder()
                .email(email)
                .password(password)
                .build();
        UserService userService = ServiceFactory.getFactory().getUserService();
        UserDataService userDataService = ServiceFactory.getFactory().getUserDataService();
        Optional<UserBean> chLogin = userService.login(userBean);

        if (chLogin.isPresent()) {
            UserBean userBeanLogin = chLogin.get();
            log.info("chLogin.isPresent() -> true");
            log.info("UserBean id -> {}", userBeanLogin.getId());
            log.info("UserBean.get().getUserData().getId() -> {}", userBeanLogin.getUserData().getId());

            Optional<UserDataBean> findById = userDataService.findById(userBeanLogin.getUserData().getId());
            if (findById.isPresent()) {
                userBeanLogin.setUserData(findById.get());
                log.info("UserDataBean.getId() -> {}", findById.get().getId());
            }

            HttpSession session = req.getSession(true);
            session.setAttribute(Constant.AUTHENTICATION, userBeanLogin);
            log.info(userBeanLogin.toString());
            chain.doFilter(req, res);
        } else {
            log.info("chLogin.isPresent() -> false");
            req.setAttribute(Constant.ERROR_AUTH, Constant.ERROR_AUTH_MESSAGE);
            RequestDispatcher dispatcher = req.getRequestDispatcher(Constant.PAGE_INDEX);
            dispatcher.forward(req, res);
        }
    }

}
