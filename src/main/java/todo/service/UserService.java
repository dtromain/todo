package todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.dao.UserDAO;

@Service
public class UserService {

    @Autowired
    UserDAO dao;
}
