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

    public List<Task> trier(String type){
        List<Task> liste = null;
        switch (type){
            case "dA" : liste = dao.findByOrderByDateAsc(); break;
            case "dD" : liste = dao.findByOrderByDateDesc(); break;
            case "cA" : liste = dao.findByOrderByCategoryAsc(); break;
            case "cD" : liste = dao.findByOrderByCategoryDesc(); break;
            default : liste = dao.findAll();
        }
        return liste;
    }
}
