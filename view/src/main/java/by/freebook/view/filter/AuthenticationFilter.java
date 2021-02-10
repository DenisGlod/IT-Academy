package by.freebook.view.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.freebook.service.UserDataService;
import by.freebook.service.UserService;
import by.freebook.service.bean.UserBean;
import by.freebook.service.bean.UserDataBean;
import by.freebook.service.factory.ServiceFactory;
import by.freebook.view.util.Constant;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter("/login.do")
public class AuthenticationFilter extends HttpUTF8Filter {
    private static final long serialVersionUID = 6230439079516161271L;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
	    throws IOException, ServletException {
	log.info("doFilter");
	String email = req.getParameter(Constant.EMAIL);
	String password = req.getParameter(Constant.PASSWORD);
	UserService userService = ServiceFactory.getFactory().getUserService();
	UserDataService userDataService = ServiceFactory.getFactory().getUserDataService();
	Optional<UserBean> chLogin = userService.login(new UserBean().withEmail(email).withPassword(password));

	if (chLogin.isPresent()) {
	    UserBean userBean = chLogin.get();
	    log.info("chLogin.isPresent() -> true");
	    log.info("UserBean id -> {}", userBean.getId());
	    log.info("UserBean.get().getUserData().getId() -> {}", userBean.getUserData().getId());

	    Optional<UserDataBean> findById = userDataService.findById(userBean.getUserData().getId());
	    if (findById.isPresent()) {
		userBean.setUserData(findById.get());
		log.info("UserDataBean.getId() -> {}", findById.get().getId());
	    }

	    HttpSession session = req.getSession(true);
	    session.setAttribute(Constant.AUTHENTICATION, userBean);
	    log.info(userBean.toString());
	    chain.doFilter(req, res);
	} else {
	    log.info("chLogin.isPresent() -> false");
	    req.setAttribute(Constant.ERROR_AUTH, Constant.ERROR_AUTH_MESSAGE);
	    RequestDispatcher dispatcher = req.getRequestDispatcher(Constant.PAGE_INDEX);
	    dispatcher.forward(req, res);
	}
    }

}
