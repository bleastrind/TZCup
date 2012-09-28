package net.tiaozhanbei.dao;

import java.util.Date;
import java.util.List;

import net.tiaozhanbei.model.ProjectFile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for ProjectFile entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.ProjectFile
  * @author MyEclipse Persistence Tools 
 */

public class ProjectFileDAO extends HibernateDaoSupport  {
    private static final Log log = LogFactory.getLog(ProjectFileDAO.class);
	//property constants
	public static final String FILE_NAME = "fileName";
	public static final String FILE_PATH = "filePath";
	public static final String FILE_SOURCE = "fileSource";
	public static final String FILE_DESCRIPTION = "fileDescription";
	public static final String FILE_TYPE = "fileType";



	protected void initDao() {
		//do nothing
	}
    
    public void save(ProjectFile transientInstance) {
        log.debug("saving ProjectFile instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ProjectFile persistentInstance) {
        log.debug("deleting ProjectFile instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ProjectFile findById( java.lang.Integer id) {
        log.debug("getting ProjectFile instance with id: " + id);
        try {
            ProjectFile instance = (ProjectFile) getHibernateTemplate()
                    .get("net.tiaozhanbei.ProjectFile", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ProjectFile instance) {
        log.debug("finding ProjectFile instance by example");
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
      log.debug("finding ProjectFile instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ProjectFile as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByFileName(Object fileName
	) {
		return findByProperty(FILE_NAME, fileName
		);
	}
	
	public List findByFilePath(Object filePath
	) {
		return findByProperty(FILE_PATH, filePath
		);
	}
	
	public List findByFileSource(Object fileSource
	) {
		return findByProperty(FILE_SOURCE, fileSource
		);
	}
	
	public List findByFileDescription(Object fileDescription
	) {
		return findByProperty(FILE_DESCRIPTION, fileDescription
		);
	}
	
	public List findByFileType(Object fileType
	) {
		return findByProperty(FILE_TYPE, fileType
		);
	}
	

	public List findAll() {
		log.debug("finding all ProjectFile instances");
		try {
			String queryString = "from ProjectFile";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ProjectFile merge(ProjectFile detachedInstance) {
        log.debug("merging ProjectFile instance");
        try {
            ProjectFile result = (ProjectFile) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ProjectFile instance) {
        log.debug("attaching dirty ProjectFile instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ProjectFile instance) {
        log.debug("attaching clean ProjectFile instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ProjectFileDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ProjectFileDAO) ctx.getBean("ProjectFileDAO");
	}
}