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

<<<<<<< HEAD
    public List<Task> sort(String type){
        List<Task> tasks = null;
        switch (type){
            case "dA" : tasks = dao.findByOrderByDateAsc(); break;
            case "dD" : tasks = dao.findByOrderByDateDesc(); break;
            case "cA" : tasks = dao.findByOrderByCategoryAsc(); break;
            case "cD" : tasks = dao.findByOrderByCategoryDesc(); break;
            default : tasks = dao.findAll();
        }
        return tasks;
=======
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
>>>>>>> 7d2562199c06d4ef89c38d65173da08f9855d855
    }
}
