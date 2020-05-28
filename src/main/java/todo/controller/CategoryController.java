package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import todo.bean.Category;
import todo.bean.Task;
import todo.service.CategoryService;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryService cs;

    @Autowired
    TaskController tc;

    @PostConstruct
    private void init(){
    }

    @RequestMapping(path="/listCategories", method= RequestMethod.GET)
    public ModelAndView listCategories(){
        List<Category> categories = cs.findAll();
        return new ModelAndView("listCategories", "categories", categories);
    }

    @RequestMapping(value="/createCategory", method=RequestMethod.GET)
    public ModelAndView createCategory(){
        Category c = new Category();
        ModelAndView mav = new ModelAndView("createCategory", "category", c);
        List<Category> listeStyles = cs.findAll();
        mav.getModelMap().addAttribute("listeStyles", listeStyles);
        return mav;
    }

    @RequestMapping(value="/validCreateCategory", method=RequestMethod.POST)
    public ModelAndView createValidCategory(Category category, ModelMap model){
        cs.create(category);
        return tc.listTasks();
    }
}
