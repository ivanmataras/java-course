package ru.imataras.servlets;

import org.slf4j.Logger;
import ru.imataras.models.Pet;
import ru.imataras.storages.PetTypeStorage;
import ru.imataras.storages.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author imataras
 * @since 22.03.2017
 */

public class PetAddServlet extends HttpServlet {

    private static final Logger log = getLogger(PetAddServlet.class);
    private final PetTypeStorage types = PetTypeStorage.getInstance();
    private final UserStorage users = UserStorage.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pet pet = new Pet();
        pet.setNick(req.getParameter("nick"));
        pet.setType(this.types.findById(Integer.valueOf(req.getParameter("type.id"))).get());
        this.users.findById(Integer.valueOf(req.getParameter("owner.id"))).get().getPets().add(pet);
        resp.sendRedirect(String.format("%s/users.do", req.getContextPath()));
    }

}
