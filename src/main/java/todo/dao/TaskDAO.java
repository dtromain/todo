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
            throw new DAOException("Erreur lors de l'ajout d'une tache' " + task + " : " + e.getMessage());
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
            throw new DAOException("Erreur lors de la suppression d'une tache' " + task + " : " + e.getMessage());
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
            throw new DAOException("Erreur lors de la modification d'une tache' " + task + " : " + e.getMessage());
        }
    }

    public List<Task> findAll() {
        String req = "Select Object(l) from Task l";
        return DAOUtil.getEntityManager().createQuery(req, Task.class).getResultList();
    }
}
