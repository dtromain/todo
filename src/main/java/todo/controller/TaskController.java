package todo.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import todo.bean.Category;
import todo.bean.Task;
import todo.service.CategoryService;
import todo.service.TaskService;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    TaskService ts;

    @Autowired
    CategoryService cs;

    @PostConstruct
    private void init(){
    }

    @RequestMapping(path="/listTasks", method= RequestMethod.GET)
    public ModelAndView listTasks(){
        List<Task> tasks = ts.findAll();
        return new ModelAndView("tasksList", "tasks", tasks);
    }

    @RequestMapping(value="/sortTasks", method=RequestMethod.GET)
    public ModelAndView sortTasks(String type){
        List<Task> tasks = ts.sort(type);
        return new ModelAndView("tasksList", "tasks", tasks);
    }

    @RequestMapping(value="/createTask", method=RequestMethod.GET)
    public ModelAndView createTask(){
        Task t = new Task();
        ModelAndView mav = new ModelAndView("createTask", "task", t);
        List<Category> listeStyles = cs.findAll();
        mav.getModelMap().addAttribute("listeStyles", listeStyles);
        return mav;
    }

    @RequestMapping(value="/createValidTask", method=RequestMethod.POST)
    public ModelAndView validCreateTask(Task task, ModelMap model){
        ts.create(task);
        return listTasks();
    }

    @RequestMapping(value="/deleteTask", method=RequestMethod.GET)
    public ModelAndView deleteTask(String index){
        int i = Integer.parseInt(index.substring(1));
        Task task = ts.findOneById(i);
        ts.delete(task);

        return listTasks();
    }

    @RequestMapping(value="/detailsTask", method=RequestMethod.GET)
    public ModelAndView detailsTask(Integer index) {
        Task task = null;
        if (index != null){
            task = ts.findOneById(index);
            return new ModelAndView("detailsTask", "task", task);
        }
        else
            return listTasks();
    }

    @RequestMapping(value="/updateTask", method=RequestMethod.GET)
    public ModelAndView updateTask(String index){
        Task task = null;
        int i = Integer.parseInt(index.substring(1));
        task = ts.findOneById(i);
        ModelAndView mav = new ModelAndView("updateTask", "task", task);
        List<Category> categories = cs.findAll();
        mav.getModelMap().addAttribute("categories", categories);
        return mav;
    }


    @RequestMapping(value="/validUpdateTask", method=RequestMethod.POST)
    public ModelAndView validUpdateTask(Task t){
        ts.update(t);
        return listTasks();
    }
=======
public class TaskController {
>>>>>>> 7d2562199c06d4ef89c38d65173da08f9855d855
}
