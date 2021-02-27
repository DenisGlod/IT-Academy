package by.freebook.view.filter;

import by.freebook.service.bean.UserBean;
import by.freebook.view.util.Constant;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@WebFilter("/page/*")
public class AuthorizationFilter extends HttpUTF8Filter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = req.getSession(false);
        String requestURI = req.getRequestURI();
        log.info("requestURI -> {}", requestURI);
        String pageUser = "/freebook".concat(Constant.PAGE_USER);
        String pageModerator = "/freebook".concat(Constant.PAGE_MODERATOR);
        String pageAdmin = "/freebook".concat(Constant.PAGE_ADMIN);
        Object object;
        if (session != null && (object = session.getAttribute(Constant.AUTHENTICATION)) != null) {
            UserBean userBean = (UserBean) object;
            if (requestURI.equals(pageUser) ||
                    "/freebook/page/user.do".equals(requestURI) ||
                    "/freebook/page/user/account".equals(requestURI) &&
                            userBean.getRole().getId() == 3) {
                log.info("AuthorizationFilter User");
                chain.doFilter(req, res);
            } else if (requestURI.equals(pageModerator) && userBean.getRole().getId() == 2) {
                log.info("AuthorizationFilter Moderator");
                chain.doFilter(req, res);
            } else if (requestURI.equals(pageAdmin) && userBean.getRole().getId() == 1) {
                log.info("AuthorizationFilter admin");
                chain.doFilter(req, res);
            } else {
                log.info("AuthorizationFilter 403");
                res.sendError(403);
            }
        } else {
            res.sendError(403);
        }
    }

}
