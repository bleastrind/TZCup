package net.tiaozhanbei.dao;

import java.util.Date;
import java.util.List;

import net.tiaozhanbei.model.ProjectComment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for ProjectComment entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.ProjectComment
  * @author MyEclipse Persistence Tools 
 */

public class ProjectCommentDAO extends HibernateDaoSupport  {
    private static final Log log = LogFactory.getLog(ProjectCommentDAO.class);
	//property constants
	public static final String COMMENT_CONTENT = "commentContent";
	public static final String COMMENT_AUTHOR = "commentAuthor";
	public static final String COMMENT_PROJECT = "commentProject";



	protected void initDao() {
		//do nothing
	}
    
    public void save(ProjectComment transientInstance) {
        log.debug("saving ProjectComment instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ProjectComment persistentInstance) {
        log.debug("deleting ProjectComment instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ProjectComment findById( java.lang.Integer id) {
        log.debug("getting ProjectComment instance with id: " + id);
        try {
            ProjectComment instance = (ProjectComment) getHibernateTemplate()
                    .get("net.tiaozhanbei.ProjectComment", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ProjectComment instance) {
        log.debug("finding ProjectComment instance by example");
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
      log.debug("finding ProjectComment instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ProjectComment as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCommentContent(Object commentContent
	) {
		return findByProperty(COMMENT_CONTENT, commentContent
		);
	}
	
	public List findByCommentAuthor(Object commentAuthor
	) {
		return findByProperty(COMMENT_AUTHOR, commentAuthor
		);
	}
	
	public List findByCommentProject(Object commentProject
	) {
		return findByProperty(COMMENT_PROJECT, commentProject
		);
	}
	

	public List findAll() {
		log.debug("finding all ProjectComment instances");
		try {
			String queryString = "from ProjectComment";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ProjectComment merge(ProjectComment detachedInstance) {
        log.debug("merging ProjectComment instance");
        try {
            ProjectComment result = (ProjectComment) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ProjectComment instance) {
        log.debug("attaching dirty ProjectComment instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ProjectComment instance) {
        log.debug("attaching clean ProjectComment instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ProjectCommentDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ProjectCommentDAO) ctx.getBean("ProjectCommentDAO");
	}
}