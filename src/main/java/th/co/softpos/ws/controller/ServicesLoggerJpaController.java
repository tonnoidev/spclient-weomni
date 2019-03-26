package th.co.softpos.ws.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import th.co.softpos.ws.controller.exceptions.NonexistentEntityException;
import th.co.softpos.ws.controller.exceptions.PreexistingEntityException;
import th.co.softpos.ws.entity.ServicesLogger;

public class ServicesLoggerJpaController implements Serializable {
    
    public ServicesLoggerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ServicesLogger servicesLogger) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(servicesLogger);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findServicesLogger(servicesLogger.getId()) != null) {
                throw new PreexistingEntityException("ServicesLogger " + servicesLogger + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ServicesLogger servicesLogger) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            servicesLogger = em.merge(servicesLogger);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = servicesLogger.getId();
                if (findServicesLogger(id) == null) {
                    throw new NonexistentEntityException("The servicesLogger with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ServicesLogger servicesLogger;
            try {
                servicesLogger = em.getReference(ServicesLogger.class, id);
                servicesLogger.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicesLogger with id " + id + " no longer exists.", enfe);
            }
            em.remove(servicesLogger);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ServicesLogger> findServicesLoggerEntities() {
        return findServicesLoggerEntities(true, -1, -1);
    }

    public List<ServicesLogger> findServicesLoggerEntities(int maxResults, int firstResult) {
        return findServicesLoggerEntities(false, maxResults, firstResult);
    }

    private List<ServicesLogger> findServicesLoggerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ServicesLogger.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ServicesLogger findServicesLogger(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ServicesLogger.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicesLoggerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ServicesLogger> rt = cq.from(ServicesLogger.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
