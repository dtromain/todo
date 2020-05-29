package todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.bean.Category;
import todo.dao.CategoryDAO;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDAO dao;

    public List<Category> findAll() {
        return dao.findAll();
    }

    public Category findOneById(int i) {
        return dao.findOne(i);
    }

    public Category create(Category c) {
        Category res = dao.save(c);
        return res;
    }
}
