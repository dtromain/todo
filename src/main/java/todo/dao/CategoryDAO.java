package todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.bean.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
