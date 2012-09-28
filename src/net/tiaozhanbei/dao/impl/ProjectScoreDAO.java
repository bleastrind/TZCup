package net.tiaozhanbei.dao.impl;

import java.util.List;

import net.tiaozhanbei.dao.GenericHibernateDAOCrud;
import net.tiaozhanbei.dao.IProjectScoreDAO;
import net.tiaozhanbei.model.ProjectScore;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
/**
 	* A data access object (DAO) providing persistence and search support for ProjectScore entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.ProjectScore
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("unchecked")
public class ProjectScoreDAO extends GenericHibernateDAOCrud<ProjectScore> implements IProjectScoreDAO  {
    public ProjectScoreDAO() {
		super(ProjectScore.class);
		// TODO Auto-generated constructor stub
	}

	private static final Log log = LogFactory.getLog(ProjectScoreDAO.class);
	//property constants
	public static final String SCORE = "score";
	public static final String WEIGHT = "weight";



	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectScoreDAO#save(net.tiaozhanbei.model.ProjectScore)
	 */
    public void save(ProjectScore transientInstance) {
        log.debug("saving ProjectScore instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectScoreDAO#delete(net.tiaozhanbei.model.ProjectScore)
	 */
	public void delete(ProjectScore persistentInstance) {
        log.debug("deleting ProjectScore instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectScoreDAO#findById(java.lang.Integer)
	 */
    public ProjectScore findById( java.lang.Integer id) {
        log.debug("getting ProjectScore instance with id: " + id);
        try {
            ProjectScore instance = (ProjectScore) getHibernateTemplate()
                    .get("net.tiaozhanbei.model.ProjectScore", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectScoreDAO#findByExample(net.tiaozhanbei.model.ProjectScore)
	 */
    public List findByExample(ProjectScore instance) {
        log.debug("finding ProjectScore instance by example");
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
	 * @see net.tiaozhanbei.dao.impl.IProjectScoreDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding ProjectScore instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ProjectScore as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectScoreDAO#findByScore(java.lang.Object)
	 */
	public List findByScore(Object score
	) {
		return findByProperty(SCORE, score
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectScoreDAO#findByWeight(java.lang.Object)
	 */
	public List findByWeight(Object weight
	) {
		return findByProperty(WEIGHT, weight
		);
	}
	

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectScoreDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all ProjectScore instances");
		try {
			String queryString = "from ProjectScore";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectScoreDAO#merge(net.tiaozhanbei.model.ProjectScore)
	 */
    public ProjectScore merge(ProjectScore detachedInstance) {
        log.debug("merging ProjectScore instance");
        try {
            ProjectScore result = (ProjectScore) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectScoreDAO#attachDirty(net.tiaozhanbei.model.ProjectScore)
	 */
    public void attachDirty(ProjectScore instance) {
        log.debug("attaching dirty ProjectScore instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectScoreDAO#attachClean(net.tiaozhanbei.model.ProjectScore)
	 */
    public void attachClean(ProjectScore instance) {
        log.debug("attaching clean ProjectScore instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IProjectScoreDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IProjectScoreDAO) ctx.getBean("ProjectScoreDAO");
	}
}