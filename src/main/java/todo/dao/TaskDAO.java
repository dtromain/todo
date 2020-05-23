package todo.dao;

import todo.bo.Task;
import todo.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TaskDAO {
    public void add(Task task) throws DAOException {
        EntityManager em = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(task);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new DAOException("An error occurred during the task creation' " + task + " : " + e.getMessage());
        }
    }

    public void delete(Task task) throws DAOException {
        EntityManager em = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        task = em.find(Task.class, task.getId());
        try {
            em.remove(task);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new DAOException("An error occurred during the task deletion' " + task + " : " + e.getMessage());
        }
    }

    public void update(Task task) throws DAOException {
        EntityManager em = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(task);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new DAOException("An error occurred during the task update' " + task + " : " + e.getMessage());
        }
    }

    public List<Task> findAll() {
        String req = "Select Object(t) from Task t";
        return DAOUtil.getEntityManager().createQuery(req, Task.class).getResultList();
    }

    public List<Task> findAllByCategory(int categoryId) {
        return DAOUtil.getEntityManager()
                .createQuery("Select Object(t) from Task t inner join t.categories c where c.id = :categoryId")
                .setParameter("categoryId", categoryId)
                .getResultList();
    }
}
