package net.tiaozhanbei.dao.impl;

import java.util.List;

import net.tiaozhanbei.dao.GenericHibernateDAOCrud;
import net.tiaozhanbei.dao.IProjectCommentDAO;
import net.tiaozhanbei.model.Project;
import net.tiaozhanbei.model.ProjectComment;
import net.tiaozhanbei.util.Page;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

/**
 	* A data access object (DAO) providing persistence and search support for ProjectComment entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.ProjectComment
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("unchecked")
public class ProjectCommentDAO extends GenericHibernateDAOCrud<ProjectComment> implements IProjectCommentDAO  {
    public ProjectCommentDAO() {
		super(ProjectComment.class);
	}

	private static final Log log = LogFactory.getLog(ProjectCommentDAO.class);
	//property constants
	public static final String COMMENT_CONTENT = "commentContent";
	public static final String COMMENT_TIME = "commentTime";

    public void fillPage(Page<ProjectComment> page,Project project) {
    	super.fillPage("select count(*) from ProjectComment where project=?"
    			, "select * from ProjectComment where project=?",

    			new Object[]{project}, 
    			page);
	}
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectCommentDAO#save(net.tiaozhanbei.model.ProjectComment)
	 */
    public void save(ProjectComment transientInstance) {
        log.debug("saving ProjectComment instance");
        try {
            super.create(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectCommentDAO#delete(net.tiaozhanbei.model.ProjectComment)
	 */
	public void delete(ProjectComment persistentInstance) {
        log.debug("deleting ProjectComment instance");
        try {
            super.delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectCommentDAO#findById(java.lang.Integer)
	 */
    public ProjectComment findById( java.lang.Integer id) {
        log.debug("getting ProjectComment instance with id: " + id);
        try {
            ProjectComment instance = super.query(id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectCommentDAO#findByExample(net.tiaozhanbei.model.ProjectComment)
	 */
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
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectCommentDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectCommentDAO#findByCommentContent(java.lang.Object)
	 */
	public List findByCommentContent(Object commentContent
	) {
		return findByProperty(COMMENT_CONTENT, commentContent
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectCommentDAO#findByCommentTime(java.lang.Object)
	 */
	public List findByCommentTime(Object commentTime
	) {
		return findByProperty(COMMENT_TIME, commentTime
		);
	}
	

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectCommentDAO#findAll()
	 */
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
	
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectCommentDAO#merge(net.tiaozhanbei.model.ProjectComment)
	 */
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

    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectCommentDAO#attachDirty(net.tiaozhanbei.model.ProjectComment)
	 */
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
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectCommentDAO#attachClean(net.tiaozhanbei.model.ProjectComment)
	 */
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

	public static IProjectCommentDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IProjectCommentDAO) ctx.getBean("ProjectCommentDAO");
	}

	public List<ProjectComment> findByProject(int projectId, int type) {
		return queryForLists("from ProjectComment as p where p.projectId=? and p.type=?", new Object[]{projectId,type});
	}


	public ProjectComment query(String hql, Object[] values) {

		return (ProjectComment)super.queryForObject(hql, values);
	}
}