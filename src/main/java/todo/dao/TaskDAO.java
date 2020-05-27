package todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.bean.Task;

public interface TaskDAO extends JpaRepository<Task, Integer> {
}
