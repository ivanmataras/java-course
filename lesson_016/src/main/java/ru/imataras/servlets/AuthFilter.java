package ru.imataras.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.imataras.models.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * TODO: comment
 *
 * @author imataras
 * @since 11.02.2017
 */

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(true);
        Object user = session.getAttribute("user");
        if (req.getRequestURI().contains("/login.do")) {
            chain.doFilter(request, response);
        } else if (session == null || user == null) {
            ((HttpServletResponse) response).sendRedirect(String.format("%s/login.do", req.getContextPath()));
        } else if ("ROLE_USER".equals(((User) user).getRole().getName())) {
            if (req.getRequestURI().contains("/client")) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
            if ("ROLE_ADMIN".equals(((User) user).getRole().getName())) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        }

    }

    @Override
    public void destroy() {

    }

}
