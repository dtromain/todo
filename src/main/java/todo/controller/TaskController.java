package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import todo.bean.Category;
import todo.bean.Task;
import todo.bean.User;
import todo.service.CategoryService;
import todo.service.TaskService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("session")
public class TaskController {

    @Autowired
    private User user;

    @Autowired
    TaskService ts;

    @Autowired
    CategoryService cs;

    @Autowired
    private User user;

    @PostConstruct
    private void init() {
    }

    @RequestMapping(path = "/listTasks", method = RequestMethod.GET)
    public ModelAndView listTasks(HttpSession session) {
        List<Task> tasks = new ArrayList<>();
        try {
            tasks = ts.findAll();
        } catch (NullPointerException e) {

        }
        return new ModelAndView("listTasks", "tasks", tasks);
    }

    @RequestMapping(value = "/sortTasks", method = RequestMethod.GET)
    public ModelAndView sortTasks(String type) {
        List<Task> tasks = ts.sort(type);
        return new ModelAndView("listTasks", "tasks", tasks);
    }

    @RequestMapping(value = "/createTask", method = RequestMethod.GET)
    public ModelAndView createTask() {
        Task t = new Task();
        ModelAndView mav = new ModelAndView("createTask", "task", t);
        List<Category> categories = cs.findAll();
        mav.getModelMap().addAttribute("categories", categories);
        return mav;
    }

    @RequestMapping(value = "/validCreateTask", method = RequestMethod.POST)
    public ModelAndView validCreateTask(Task task, ModelMap model, HttpSession session) {
        Task t = ts.create(task);
        user.addTask(t);
        return this.listTasks(session);
    }

    @RequestMapping(value = "/deleteTask", method = RequestMethod.GET)
    public ModelAndView deleteTask(String index, HttpSession session) {
        int i = Integer.parseInt(index.substring(1));
        Task task = ts.findOneById(i);
        ts.delete(task);
        return listTasks(session);
    }

    @RequestMapping(value = "/detailsTask", method = RequestMethod.GET)
    public ModelAndView detailsTask(Integer index, HttpSession session) {
        Task task = null;
        if (index != null) {
            task = ts.findOneById(index);
            return new ModelAndView("detailsTask", "task", task);
        } else {
            return listTasks(session);
        }
    }

    @RequestMapping(value = "/updateTask", method = RequestMethod.GET)
    public ModelAndView updateTask(String index) {
        Task task = null;
        int i = Integer.parseInt(index.substring(1));
        task = ts.findOneById(i);
        ModelAndView mav = new ModelAndView("updateTask", "task", task);
        List<Category> categories = cs.findAll();
        mav.getModelMap().addAttribute("categories", categories);
        return mav;
    }

    @RequestMapping(value = "/validUpdateTask", method = RequestMethod.POST)
    public ModelAndView validUpdateTask(Task t, HttpSession session) {
        ts.update(t);
        return listTasks(session);
    }
}
