package by.freebook.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.freebook.service.bean.UserBean;
import by.freebook.service.factory.ServiceFactory;
import by.freebook.view.util.Constant;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/login.do")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 6077576602026047190L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	log.info("Start LoginController");
	HttpSession session = request.getSession(false);
	UserBean userBean = (UserBean) session.getAttribute(Constant.AUTHENTICATION);
	switch (userBean.getRole().getId()) {
	case 1:
	    session.setAttribute(Constant.TITLE_NAME, Constant.TITLE_VALUE_ADMIN_PAGE);
	    response.sendRedirect(request.getContextPath().concat(Constant.PAGE_ADMIN));
	    break;
	case 2:
	    session.setAttribute(Constant.TITLE_NAME, Constant.TITLE_VALUE_MODERATOR_PAGE);
	    response.sendRedirect(request.getContextPath().concat(Constant.PAGE_MODERATOR));
	    break;
	case 3:
	    var bookService = ServiceFactory.getFactory().getBookService();
	    var listBook = bookService.getAllBook();
	    session.setAttribute(Constant.TITLE_NAME, Constant.TITLE_VALUE_USER_PAGE);
	    session.setAttribute(Constant.LIST_BOOK, listBook);
	    listBook.forEach(i -> {
		log.info("book.id -> {}", i.getId());
	    });
	    log.info("listBook.size() -> {}", listBook.size());
	    response.sendRedirect(request.getContextPath().concat(Constant.PAGE_USER));
	    break;
	}
    }

}
