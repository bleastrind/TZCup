package net.tiaozhanbei.dao.impl;


import java.util.List;

import net.tiaozhanbei.dao.GenericHibernateDAOCrud;
import net.tiaozhanbei.dao.IUserDAO;
import net.tiaozhanbei.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
@SuppressWarnings("unchecked")

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see net.tiaozhanbei.model.User
 * @author MyEclipse Persistence Tools
 */

public class UserDAO extends GenericHibernateDAOCrud<User> implements IUserDAO {
	public UserDAO() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}

	private static final Log log = LogFactory.getLog(UserDAO.class);
	// property constants
	public static final String USER_PASSWORD = "password";
	public static final String USER_NAME = "name";
	public static final String USER_TYPE = "type";
	public static final String USER_VERIFY = "verify";
	public static final String USER_EMAIL = "email";
	public static final String USER_PHONE = "phone";
	public static final String USER_REALNAME = "realname";
	public static final String USER_SEX = "sex";
	public static final String USER_DEPARTMENT = "department";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#save(net.tiaozhanbei.model.User)
	 */
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

	public void update(User perInstance) {

		log.debug("Update User instance");
		try {
			getHibernateTemplate().update(perInstance);
			log.debug("update successful");

		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#delete(net.tiaozhanbei.model.User)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#findById(java.lang.Integer)
	 */
	public User findById(java.lang.Integer id) {

		System.out.println(getSessionFactory());
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getHibernateTemplate().get(
					"net.tiaozhanbei.model.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#findByExample(net.tiaozhanbei.model.User)
	 */
	public List<User> findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	
	public List<User> findByProperty(String propertyName, Object value) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#findByUserPassword(java.lang.Object)
	 */
	public List<User> findByUserPassword(Object userPassword) {
		return findByProperty(USER_PASSWORD, userPassword);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#findByUserName(java.lang.Object)
	 */
	public User findByUserName(Object userName) {
		


		return (User)super.queryForObject(
				"from User as model where model.name=?", new Object[]{userName});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#findByUserType(java.lang.Object)
	 */
	public List<User> findByUserType(Object userType) {
		return findByProperty(USER_TYPE, userType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#findByUserVerify(java.lang.Object)
	 */
	public List<User> findByUserVerify(Object userVerify) {
		return findByProperty(USER_VERIFY, userVerify);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#findByUserEmail(java.lang.Object)
	 */
	public List<User> findByUserEmail(Object userEmail) {
		return findByProperty(USER_EMAIL, userEmail);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#findByUserPhone(java.lang.Object)
	 */
	public List<User> findByUserPhone(Object userPhone) {
		return findByProperty(USER_PHONE, userPhone);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#findByUserRealname(java.lang.Object)
	 */
	public List<User> findByUserRealname(Object userRealname) {
		return findByProperty(USER_REALNAME, userRealname);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#findByUserSex(java.lang.Object)
	 */
	public List<User> findByUserSex(Object userSex) {
		return findByProperty(USER_SEX, userSex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#findByUserDepartment(java.lang.Object)
	 */
	public List<User> findByUserDepartment(Object userDepartment) {
		return findByProperty(USER_DEPARTMENT, userDepartment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#findAll()
	 */
	public List <User>findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#merge(net.tiaozhanbei.model.User)
	 */
	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#attachDirty(net.tiaozhanbei.model.User)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.tiaozhanbei.dao.impl.IUserDAO#attachClean(net.tiaozhanbei.model.User)
	 */
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

	public static IUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IUserDAO) ctx.getBean("UserDAO");
	}

	
}