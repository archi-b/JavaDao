package br.com.archib.javadao.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class DaoBase<T> extends HibernateDaoSupport implements IDaoBase<T> {

    private static final Log log = LogFactory.getLog(DaoBase.class);
    private final Class<T> typeClass;

    public DaoBase(Class<T> typeClass) {
        super();
        this.typeClass = typeClass;
    }

    /* (non-Javadoc)
     * @see com.navita.model.repository.GenericRepository#save(null)
     */
    public void save(T instance) {
        log.debug("saving " + instance.getClass().getName() + " instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    /* (non-Javadoc)
     * @see com.navita.model.repository.GenericRepository#findById(java.lang.Long)
     */
    public T findById(Integer id) {
        log.debug("getting " + typeClass + " instance with id: " + id);
        try {
            T instance = (T) getHibernateTemplate().get(typeClass, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    /* (non-Javadoc)
     * @see com.navita.model.repository.GenericRepository#findAll()
     */
    public List<T> findAll() {
        log.debug("finding all " + typeClass.getName() + " instances");
        try {
            List<T> results = (List<T>) getHibernateTemplate().loadAll(typeClass);
            log.debug("findAll successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("findAll failed", re);
            throw re;
        }
    }
    /* (non-Javadoc)
     * @see com.navita.model.repository.GenericRepository#findAll(java.lang.Integer, java.lang.Integer)
     */
    public List<T> findAll(Integer begin, Integer end) {
        log.debug("finding all " + typeClass.getName() + " instances from: " + begin + " to: " + end);
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(typeClass);
            List<T> results = (List<T>) getHibernateTemplate().findByCriteria(criteria, begin, end);
            log.debug("findAll successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("findAll failed", re);
            throw re;
        }
    }
    /* (non-Javadoc)
     * @see com.navita.model.repository.GenericRepository#findByExample(null)
     */
    public List<T> findByExample(T example) {
        return findByExample(example, -1, -1);
    }
    /* (non-Javadoc)
     * @see com.navita.model.repository.GenericRepository#findByExample(T, java.lang.Integer, java.lang.Integer)
     */
    public List<T> findByExample(T example, Integer begin, Integer end) {
        log.debug("finding " + example.getClass().getName() + " instance by example from: " + begin + " to: " + end);
        try {
            List<T> results = (List<T>) getHibernateTemplate().findByExample(example, begin, end);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
    /* (non-Javadoc)
     * @see com.navita.model.repository.GenericRepository#remove(null)
     */
    public void remove(T instance) {
        log.debug("deleting " + instance.getClass().getName() + " instance");
        try {
            getHibernateTemplate().delete(instance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
}
