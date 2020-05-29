package todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.bean.User;
import todo.dao.UserDAO;

@Service
public class UserService {

    @Autowired
    UserDAO dao;

    public User findOneByLogin(String login) {
        return dao.findOneByLogin(login);
    }

}
