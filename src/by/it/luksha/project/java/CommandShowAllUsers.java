package by.it.luksha.project.java;

import by.it.luksha.project.java.beans.User;
import by.it.luksha.project.java.dao.DAO;
import by.it.luksha.project.java.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by MMauz on 17.07.2016.
 */
public class CommandShowAllUsers implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String resultPage = Action.SHOWALLUSERS.inPage;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        /**
         * Если пользователь залогинился и он администратор,
         * то показать ему список всех пользователей
         */
        if (user != null && user.getFk_role() == 1) {
            UserDAO userDAO = DAO.getDAO().getUserDAO();
            List<User> users = userDAO.getAll("");
            request.setAttribute("ListUsers", users.toString());
        } else {
            request.setAttribute(Action.msgMessage, "Данная операция доступна только администратору");
        }

        return resultPage;
    }

}
