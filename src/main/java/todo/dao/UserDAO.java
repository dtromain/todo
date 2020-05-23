package todo.dao;

import todo.bo.User;
import todo.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class UserDAO {
    public void add(User user) throws DAOException {
        EntityManager em = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(user);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new DAOException("An error occurred during the user creation' " + user + " : " + e.getMessage());
        }
    }

    public void delete(User user) throws DAOException {
        EntityManager em = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        user = em.find(User.class, user.getId());
        try {
            em.remove(user);
            em.clear();
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new DAOException("An error occurred during the user deletion' " + user + " : " + e.getMessage());
        }
    }

    public void update(User user) throws DAOException {
        EntityManager em = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(user);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new DAOException("An error occurred during the user update' " + user + " : " + e.getMessage());
        }
    }

    public List<User> findAll() {
        String req = "Select Object(u) from User u";
        return DAOUtil.getEntityManager().createQuery(req, User.class).getResultList();
    }
}
