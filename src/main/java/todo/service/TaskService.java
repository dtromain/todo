package todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.bean.Task;
import todo.dao.TaskDAO;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskDAO dao;

    public List<Task> findAll(){
        return dao.findAll();
    }

    public Task findOneById(int i){
        return dao.findOne(i);
    }

    public void create(Task s){
        dao.save(s);
    }

    public void update(Task t){
        dao.save(t);
    }

    public void delete(Task t){
        dao.delete(t);
    }

    public List<Task> sort(String type) {
        List<Task> tasks = null;
        switch (type) {
            case "dA":
                tasks = dao.findByOrderByDateAsc();
                break;
            case "dD":
                tasks = dao.findByOrderByDateDesc();
                break;
            case "cA":
                tasks = dao.findByOrderByCategoriesAsc();
                break;
            case "cD":
                tasks = dao.findByOrderByCategoriesDesc();
                break;
            default:
                tasks = dao.findAll();
        }
        return tasks;
    }
}
