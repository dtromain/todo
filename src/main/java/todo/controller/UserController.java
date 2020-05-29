package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import todo.bean.Task;
import todo.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService us;

    @RequestMapping(path="/login", method= RequestMethod.GET)
    public ModelAndView listTasks(){
        //List<Task> tasks = ts.findAll();
        return "path/login";
    }

    @RequestMapping(path="/login", method= RequestMethod.POST)
    public ModelAndView listTasks(){
        //return new ModelAndView("listTasks", "tasks", tasks);
        return new ModelAndView();
    }
}
