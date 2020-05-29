package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import todo.bean.Category;
import todo.bean.User;
import todo.service.CategoryService;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private User user;

    @Autowired
    CategoryService cs;

    TaskController tc = new TaskController();

    @PostConstruct
    private void init() {
    }

    @RequestMapping(value = "/createCategory", method = RequestMethod.GET)
    public ModelAndView createCategory() {
        Category c = new Category();
        ModelAndView mav = new ModelAndView("createCategory", "category", c);
        List<Category> listeStyles = cs.findAll();
        mav.getModelMap().addAttribute("listeStyles", listeStyles);
        return mav;
    }

    @RequestMapping(value = "/validCreateCategory", method = RequestMethod.POST)
    public ModelAndView validCreateCategory(Category category, ModelMap model) {
        Category c = cs.create(category);
        user.addCategory(c);
        return tc.listTasks();
    }
}
