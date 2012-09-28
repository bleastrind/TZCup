package net.tiaozhanbei.dao;


import java.util.List;

import net.tiaozhanbei.model.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for User entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.User
  * @author MyEclipse Persistence Tools 
 */

public class UserDAO extends HibernateDaoSupport implements IUserDAO {
    private static final Log log = LogFactory.getLog(UserDAO.class);
	//property constants
	public static final String USER_NAME = "userName";
	public static final String USER_PASSWD = "userPasswd";
	public static final String USER_PART = "userPart";
	public static final String USER_SCHOOL = "userSchool";
	public static final String USER_EMAIL = "userEmail";
	public static final String USER_PHONE = "userPhone";
	public static final String USER_REALNAME = "userRealname";
	public static final String USER_SEX = "userSex";
	public static final String USER_COMPANY = "userCompany";
	public static final String USER_VERIFY = "userVerify";



	protected void initDao() {
		//do nothing
	}
    
    public void save(User transientInstance) {
        log.debug("saving User instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(User persistentInstance) {
        log.debug("deleting User instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(User instance) {
        log.debug("finding User instance by example");
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
      log.debug("finding User instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from User as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object userName
	) {
		return findByProperty(USER_NAME, userName
		);
	}
	
	public List findByPasswd(Object userPasswd
	) {
		return findByProperty(USER_PASSWD, userPasswd
		);
	}
	
	public List findByAuthority(Object userAuthority
	) {
		return findByProperty(USER_PART, userAuthority
		);
	}
	
	public List findBySchool(Object userSchool
	) {
		return findByProperty(USER_SCHOOL, userSchool
		);
	}
	
	public List findByEmail(Object userEmail
	) {
		return findByProperty(USER_EMAIL, userEmail
		);
	}
	
	public List findByPhone(Object userPhone
	) {
		return findByProperty(USER_PHONE, userPhone
		);
	}
	
	public List findByRealname(Object userRealname
	) {
		return findByProperty(USER_REALNAME, userRealname
		);
	}
	
	public List findBySex(Object userSex
	) {
		return findByProperty(USER_SEX, userSex
		);
	}
	
	public List findByCompany(Object userCompany
	) {
		return findByProperty(USER_COMPANY, userCompany
		);
	}
	
	public List findByVerify(Object userVerify
	) {
		return findByProperty(USER_VERIFY, userVerify
		);
	}
	

	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public User merge(User detachedInstance) {
        log.debug("merging User instance");
        try {
            User result = (User) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(User instance) {
        log.debug("attaching dirty User instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(User instance) {
        log.debug("attaching clean User instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static UserDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (UserDAO) ctx.getBean("UserDAO");
	}

    
    public User findById( java.lang.Integer id) {
        log.debug("getting User instance with id: " + id);
        try {

            User instance = (User) getHibernateTemplate()
                    .get("net.tiaozhanbei.model.User", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}