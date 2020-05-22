package todo.dao;

import todo.bo.Category;
import todo.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CategoryDAO {
    public void add(Category category) throws DAOException {
        EntityManager em = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(category);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new DAOException("Erreur lors de l'ajout d'une categorie' " + category + " : " + e.getMessage());
        }
    }

    public void delete(Category category) throws DAOException {
        EntityManager em = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        category = em.find(Category.class, category.getId());
        try {
            em.remove(category);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new DAOException("Erreur lors de la suppression d'une categorie' " + category + " : " + e.getMessage());
        }
    }

    public void update(Category category) throws DAOException {
        EntityManager em = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(category);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new DAOException("Erreur lors de la modification d'une categorie' " + category + " : " + e.getMessage());
        }
    }

    public List<Category> findAll() {
        String req = "Select Object(l) from Category l";
        return DAOUtil.getEntityManager().createQuery(req, Category.class).getResultList();
    }
}
