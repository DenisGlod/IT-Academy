package by.freebook.view.controller;

import by.freebook.service.bean.UserBean;
import by.freebook.service.factory.ServiceFactory;
import by.freebook.view.util.Constant;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@WebServlet("/login.do")
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        log.info("Start LoginController");
        HttpSession session = request.getSession(false);
        UserBean userBean = (UserBean) session.getAttribute(Constant.AUTHENTICATION);
        switch (userBean.getRole().getRole()) {
            case ADMIN -> {
                session.setAttribute(Constant.TITLE_NAME, Constant.TITLE_VALUE_ADMIN_PAGE);
                response.sendRedirect(request.getContextPath().concat(Constant.PAGE_ADMIN));
            }
            case MODERATOR -> {
                session.setAttribute(Constant.TITLE_NAME, Constant.TITLE_VALUE_MODERATOR_PAGE);
                response.sendRedirect(request.getContextPath().concat(Constant.PAGE_MODERATOR));
            }
            case USER -> {
                var bookService = ServiceFactory.getFactory().getBookService();
                var listBook = bookService.getAllBook();
                session.setAttribute(Constant.TITLE_NAME, Constant.TITLE_VALUE_USER_PAGE);
                session.setAttribute(Constant.LIST_BOOK, listBook);
                listBook.forEach(i -> log.info("book.id -> {}", i.getId()));
                log.info("listBook.size() -> {}", listBook.size());
                response.sendRedirect(request.getContextPath().concat(Constant.PAGE_USER));
            }
        }
    }

}
