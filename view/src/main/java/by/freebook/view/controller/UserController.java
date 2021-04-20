package by.freebook.view.controller;

import by.freebook.service.bean.UserBean;
import by.freebook.service.bean.UserDataBean;
import by.freebook.service.factory.ServiceFactory;
import by.freebook.view.util.Constant;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Slf4j
@WebServlet("/page/user.do")
public class UserController extends HttpServlet {

/*    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter(Constant.ACTION);
        switch (parameter) {
            case "logOut":
                log.info("Session invalidate");
                req.getSession().invalidate();
                resp.sendRedirect(req.getContextPath().concat(Constant.PAGE_INDEX));
                break;
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserBean userBeanAuthentication = (UserBean) session.getAttribute(Constant.AUTHENTICATION);
        String action = req.getParameter(Constant.ACTION);
        log.info("action -> {}", action);
        switch (action) {
            case Constant.SAVE_ACCOUNT_SETTINGS:
                String firstName = req.getParameter(Constant.FIRST_NAME);
                String lastName = req.getParameter(Constant.LAST_NAME);
                String middleName = req.getParameter(Constant.MIDDLE_NAME);
                String age = req.getParameter(Constant.AGE);
                String email = req.getParameter(Constant.EMAIL);
                String password = req.getParameter(Constant.PASSWORD);
                UserDataBean userDataBean = UserDataBean.builder()
                        .id(userBeanAuthentication.getUserData().getId())
                        .age(new SimpleDateFormat("yyyy-MM-dd").parse(age))
                        .firstName(firstName)
                        .lastName(lastName)
                        .middleName(middleName)
                        .build();
                Optional<UserDataBean> saveUserDataBean = ServiceFactory.getFactory().getUserDataService().save(userDataBean);
                if (saveUserDataBean.isPresent()) {
                    log.info("UserData saved successfully.");
                }
                UserBean userBean = UserBean.builder()
                        .id(userBeanAuthentication.getId())
                        .email(email)
                        .password(password)
                        .role(userBeanAuthentication.getRole())
                        .userData(userBeanAuthentication.getUserData())
                        .build();
                Optional<UserBean> save = ServiceFactory.getFactory().getUserService().save(userBean);
                if (save.isPresent()) {
                    save.get().setUserData(saveUserDataBean.orElse(null));
                    session.setAttribute(Constant.AUTHENTICATION, save.get());
                    resp.sendRedirect(req.getContextPath().concat(Constant.PAGE_USER.concat("/account")));
                    log.info("User saved successfully.");
                }
                break;
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doDelete(req, resp);
    }*/

}
