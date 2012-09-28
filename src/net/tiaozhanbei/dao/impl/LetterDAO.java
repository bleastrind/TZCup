package net.tiaozhanbei.dao.impl;

import java.util.List;

import net.tiaozhanbei.dao.GenericHibernateDAOCrud;
import net.tiaozhanbei.dao.ILetterDAO;
import net.tiaozhanbei.model.Letter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

/**
 	* A data access object (DAO) providing persistence and search support for Letter entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.Letter
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("unchecked")
public class LetterDAO extends GenericHibernateDAOCrud<Letter> implements ILetterDAO  {
    public LetterDAO() {
		super(Letter.class);
		// TODO Auto-generated constructor stub
	}

	private static final Log log = LogFactory.getLog(LetterDAO.class);
	//property constants
	public static final String LETTER_TITLE = "title";
	public static final String LETTER_CONTENT = "content";
	public static final String LETTER_CHECKED = "checked";
	public static final String LETTER_STATE = "state";



	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.ILetterDAO#save(net.tiaozhanbei.model.Letter)
	 */
    public void save(Letter transientInstance) {
        log.debug("saving Letter instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.ILetterDAO#delete(net.tiaozhanbei.model.Letter)
	 */
	public void delete(Letter persistentInstance) {
        log.debug("deleting Letter instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.ILetterDAO#findById(java.lang.Integer)
	 */
    public Letter findById( java.lang.Integer id) {
        log.debug("getting Letter instance with id: " + id);
        try {
            Letter instance = (Letter) getHibernateTemplate()
                    .get("net.tiaozhanbei.model.Letter", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.ILetterDAO#findByExample(net.tiaozhanbei.model.Letter)
	 */
    public List findByExample(Letter instance) {
        log.debug("finding Letter instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.ILetterDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Letter instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Letter as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.ILetterDAO#findByLetterTitle(java.lang.Object)
	 */
	public List findByLetterTitle(Object letterTitle
	) {
		return findByProperty(LETTER_TITLE, letterTitle
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.ILetterDAO#findByLetterContent(java.lang.Object)
	 */
	public List findByLetterContent(Object letterContent
	) {
		return findByProperty(LETTER_CONTENT, letterContent
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.ILetterDAO#findByLetterChecked(java.lang.Object)
	 */
	public List findByLetterChecked(Object letterChecked
	) {
		return findByProperty(LETTER_CHECKED, letterChecked
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.ILetterDAO#findByLetterState(java.lang.Object)
	 */
	public List findByLetterState(Object letterState
	) {
		return findByProperty(LETTER_STATE, letterState
		);
	}
	

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.ILetterDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Letter instances");
		try {
			String queryString = "from Letter";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.ILetterDAO#merge(net.tiaozhanbei.model.Letter)
	 */
    public Letter merge(Letter detachedInstance) {
        log.debug("merging Letter instance");
        try {
            Letter result = (Letter) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.ILetterDAO#attachDirty(net.tiaozhanbei.model.Letter)
	 */
    public void attachDirty(Letter instance) {
        log.debug("attaching dirty Letter instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.ILetterDAO#attachClean(net.tiaozhanbei.model.Letter)
	 */
    public void attachClean(Letter instance) {
        log.debug("attaching clean Letter instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ILetterDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ILetterDAO) ctx.getBean("LetterDAO");
	}
}