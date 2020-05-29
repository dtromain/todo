package todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.bean.User;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findOneByLogin(String login);
}
