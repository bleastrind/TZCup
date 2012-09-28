package net.tiaozhanbei.dao;

import java.util.List;

import net.tiaozhanbei.model.Project;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for Project entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.Project
  * @author MyEclipse Persistence Tools 
 */

public class ProjectDAO extends HibernateDaoSupport  {
    private static final Log log = LogFactory.getLog(ProjectDAO.class);
	//property constants
	public static final String PROJECT_NAME = "projectName";
	public static final String PROJECT_CLASS = "projectClass";
	public static final String PROJECT_AUTHOR = "projectAuthor";
	public static final String PROJECT_INTRODUCTION = "projectIntroduction";
	public static final String PROJECT_DESCRIPTION = "projectDescription";
	public static final String PROJECT_INDEX_PIC = "projectIndexPic";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Project transientInstance) {
        log.debug("saving Project instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Project persistentInstance) {
        log.debug("deleting Project instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Project findById( java.lang.Integer id) {
        log.debug("getting Project instance with id: " + id);
        try {
            Project instance = (Project) getHibernateTemplate()
                    .get("net.tiaozhanbei.Project", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Project instance) {
        log.debug("finding Project instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Project instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Project as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByProjectName(Object projectName
	) {
		return findByProperty(PROJECT_NAME, projectName
		);
	}
	
	public List findByProjectClass(Object projectClass
	) {
		return findByProperty(PROJECT_CLASS, projectClass
		);
	}
	
	public List findByProjectAuthor(Object projectAuthor
	) {
		return findByProperty(PROJECT_AUTHOR, projectAuthor
		);
	}
	
	public List findByProjectIntroduction(Object projectIntroduction
	) {
		return findByProperty(PROJECT_INTRODUCTION, projectIntroduction
		);
	}
	
	public List findByProjectDescription(Object projectDescription
	) {
		return findByProperty(PROJECT_DESCRIPTION, projectDescription
		);
	}
	
	public List findByProjectIndexPic(Object projectIndexPic
	) {
		return findByProperty(PROJECT_INDEX_PIC, projectIndexPic
		);
	}
	

	public List findAll() {
		log.debug("finding all Project instances");
		try {
			String queryString = "from Project";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Project merge(Project detachedInstance) {
        log.debug("merging Project instance");
        try {
            Project result = (Project) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Project instance) {
        log.debug("attaching dirty Project instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Project instance) {
        log.debug("attaching clean Project instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ProjectDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ProjectDAO) ctx.getBean("ProjectDAO");
	}
}