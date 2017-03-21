package ru.imataras.servlets;

import org.slf4j.Logger;
import ru.imataras.models.Message;
import ru.imataras.models.User;
import ru.imataras.storages.MessageStorage;
import ru.imataras.storages.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author imataras
 * @since 22.03.2017
 */

public class MessageServlet extends HttpServlet {

    private static final Logger log = getLogger(MessageServlet.class);
    private final MessageStorage messages = MessageStorage.getInstance();
    private final UserStorage users = UserStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = users.findById(Integer.valueOf(req.getParameter("userId"))).get();
        messages.delete(Integer.valueOf(req.getParameter("messageId")));
        resp.sendRedirect(String.format("%s/user.do?id=%s", req.getContextPath(), user.getId()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Message message = new Message();
        message.setAuthor(user);
        message.setOwner(this.users.findById(Integer.valueOf(req.getParameter("owner.id"))).get());
        message.setCreated(new Timestamp(System.currentTimeMillis()));
        message.setText(req.getParameter("text"));
        this.messages.add(message);
        resp.sendRedirect(String.format("%s/user.do?id=%s", req.getContextPath(), message.getOwner().getId()));
    }

}
