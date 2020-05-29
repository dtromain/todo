package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import todo.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService us;

    TaskController ts = new TaskController();

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(path = "/validLogin", method = RequestMethod.POST)
    public ModelAndView validLogin() {

        //Valid login and password

        return ts.listTasks();
    }
}
