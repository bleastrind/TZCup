package net.tiaozhanbei.dao.impl;

import java.util.List;

import net.tiaozhanbei.dao.GenericHibernateDAOCrud;
import net.tiaozhanbei.dao.IFileInfoDAO;
import net.tiaozhanbei.model.FileInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
/**
 	* A data access object (DAO) providing persistence and search support for FileInfo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.FileInfo
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("unchecked")
public class FileInfoDAO extends GenericHibernateDAOCrud<FileInfo> implements IFileInfoDAO  {
    public FileInfoDAO() {
		super(FileInfo.class);
	}

	private static final Log log = LogFactory.getLog(FileInfoDAO.class);
	//property constants
	public static final String FILE_NAME = "name";
	public static final String FILE_PATH = "path";
	public static final String FILE_PROJECT = "project";
	public static final String FILE_TYPE = "type";
	public static final String FILE_OWNER = "owner";



	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IFileInfoDAO#save(net.tiaozhanbei.model.FileInfo)
	 */
    public void save(FileInfo transientInstance) {
        log.debug("saving FileInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IFileInfoDAO#delete(net.tiaozhanbei.model.FileInfo)
	 */
	public void delete(FileInfo persistentInstance) {
        log.debug("deleting FileInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IFileInfoDAO#findById(java.lang.Integer)
	 */
    public FileInfo findById( java.lang.Integer id) {
        log.debug("getting FileInfo instance with id: " + id);
        try {
            FileInfo instance = (FileInfo) getHibernateTemplate()
                    .get("net.tiaozhanbei.model.FileInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IFileInfoDAO#findByExample(net.tiaozhanbei.model.FileInfo)
	 */
    public List findByExample(FileInfo instance) {
        log.debug("finding FileInfo instance by example");
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
	 * @see net.tiaozhanbei.dao.impl.IFileInfoDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding FileInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from FileInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IFileInfoDAO#findByFileName(java.lang.Object)
	 */
	public List findByFileName(Object fileName
	) {
		return findByProperty(FILE_NAME, fileName
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IFileInfoDAO#findByFilePath(java.lang.Object)
	 */
	public List findByFilePath(Object filePath
	) {
		return findByProperty(FILE_PATH, filePath
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IFileInfoDAO#findByFileProject(java.lang.Object)
	 */
	public List findByFileProject(Object fileProject
	) {
		return findByProperty(FILE_PROJECT, fileProject
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IFileInfoDAO#findByFileType(java.lang.Object)
	 */
	public List findByFileType(Object fileType
	) {
		return findByProperty(FILE_TYPE, fileType
		);
	}
	
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IFileInfoDAO#findByFileOwner(java.lang.Object)
	 */
	public List findByFileOwner(Object fileOwner
	) {
		return findByProperty(FILE_OWNER, fileOwner
		);
	}
	

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IFileInfoDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all FileInfo instances");
		try {
			String queryString = "from FileInfo";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<FileInfo> queryForList(String select,Object[] values) {
		return super.queryForLists(select, values);
	}
	
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IFileInfoDAO#merge(net.tiaozhanbei.model.FileInfo)
	 */
    public FileInfo merge(FileInfo detachedInstance) {
        log.debug("merging FileInfo instance");
        try {
            FileInfo result = (FileInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IFileInfoDAO#attachDirty(net.tiaozhanbei.model.FileInfo)
	 */
    public void attachDirty(FileInfo instance) {
        log.debug("attaching dirty FileInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IFileInfoDAO#attachClean(net.tiaozhanbei.model.FileInfo)
	 */
    public void attachClean(FileInfo instance) {
        log.debug("attaching clean FileInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IFileInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IFileInfoDAO) ctx.getBean("FileInfoDAO");
	}
}