package by.it.sergeev.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandError implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.ERROR.inPage;
    }
}