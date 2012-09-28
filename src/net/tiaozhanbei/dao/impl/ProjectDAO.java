package net.tiaozhanbei.dao.impl;

import java.util.List;

import net.tiaozhanbei.dao.GenericHibernateDAOCrud;
import net.tiaozhanbei.dao.IProjectDAO;
import net.tiaozhanbei.model.Project;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

/**
 	* A data access object (DAO) providing persistence and search support for Project entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.Project
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("unchecked")
public class ProjectDAO extends GenericHibernateDAOCrud<Project> implements IProjectDAO  {
    private static final Log log = LogFactory.getLog(ProjectDAO.class);
	//property constants
	public static final String PROJECT_NAME = "name";
	public static final String PROJECT_TYPE = "type";
	public static final String PROJECT_BRIEF = "brief";
	public static final String PROJECT_DETAL = "detal";
	public static final String PROJECT_PICPATH = "picpath";
	public static final String SCORE = "score";
	public static final String PROJECTCLASSNAME = "Project";

	public ProjectDAO(){
		super(Project.class);
	}

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#save(net.tiaozhanbei.model.Project)
	 */
	
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
    public void update(Project persistentInstance){
    	log.debug("update Project instance");
    	super.update(persistentInstance);
    	
    	
    	
    }
    
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#delete(net.tiaozhanbei.model.Project)
	 */
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
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#findById(java.lang.Integer)
	 */
    public Project findById( java.lang.Integer id) {
        log.debug("getting Project instance with id: " + id);
        try {
            Project instance = (Project) getHibernateTemplate()
                    .get("net.tiaozhanbei.model.Project", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#findByExample(net.tiaozhanbei.model.Project)
	 */
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
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#findByProjectName(java.lang.Object)
	 */
	public List findByProjectName(Object projectName
	) {
		return findByProperty(PROJECT_NAME, projectName
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#findByProjectType(java.lang.Object)
	 */
	public List findByProjectType(Object projectType
	) {
		return findByProperty(PROJECT_TYPE, projectType
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#findByProjectBrief(java.lang.Object)
	 */
	public List findByProjectBrief(Object projectBrief
	) {
		return findByProperty(PROJECT_BRIEF, projectBrief
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#findByProjectDetal(java.lang.Object)
	 */
	public List findByProjectDetal(Object projectDetal
	) {
		return findByProperty(PROJECT_DETAL, projectDetal
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#findByProjectPicpath(java.lang.Object)
	 */
	public List findByProjectPicpath(Object projectPicpath
	) {
		return findByProperty(PROJECT_PICPATH, projectPicpath
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#findByScore(java.lang.Object)
	 */
	public List findByScore(Object score
	) {
		return findByProperty(SCORE, score
		);
	}
	

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#findAll()
	 */
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
	
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#merge(net.tiaozhanbei.model.Project)
	 */
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

    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#attachDirty(net.tiaozhanbei.model.Project)
	 */
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
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IProjectDAO#attachClean(net.tiaozhanbei.model.Project)
	 */
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

	public static IProjectDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IProjectDAO) ctx.getBean("ProjectDAO");
	}

}