package by.itacademy.filter;

import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/admin.do", "/teacher.do", "/user.do"})
public class AuthorizationFilter {
}
