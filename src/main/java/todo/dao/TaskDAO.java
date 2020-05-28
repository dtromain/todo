package todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.bean.Task;

import java.util.List;

public interface TaskDAO extends JpaRepository<Task, Integer> {
    List<Task> findByOrderByDateAsc();
    List<Task> findByOrderByDateDesc();
    List<Task> findByOrderByCategoryAsc();
    List<Task> findByOrderByCategoryDesc();
}
