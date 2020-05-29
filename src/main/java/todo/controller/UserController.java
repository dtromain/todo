package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import todo.bean.User;
import todo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private User user;

    @Autowired
    UserService us;

    TaskController ts = new TaskController();

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login", "user", new User());
        return mav;
    }

    @RequestMapping(path = "/validLogin", method = RequestMethod.POST)
    public ModelAndView validLogin(User logUser, ModelMap model, HttpServletRequest request, HttpSession session) {

        User registerUser = us.findOneByLogin(logUser.getLogin());

        if (registerUser != null || logUser.getPassword().equals(registerUser.getPassword())) {
            request.getSession().setAttribute("user", registerUser);
            return ts.listTasks(session);
        } else {
            return new ModelAndView("login");
        }
    }
}
