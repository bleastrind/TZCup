package net.tiaozhanbei.dao;

import java.util.List;

import net.tiaozhanbei.model.User;
import net.tiaozhanbei.util.Page;

public interface IUserDAO {

	public abstract void save(User transientInstance);

	public abstract void delete(User persistentInstance);

	public abstract User findById(java.lang.Integer id);

	public abstract List<User> findByExample(User instance);

	public abstract List<User> findByProperty(String propertyName, Object value);

	public abstract List<User> findByUserPassword(Object userPassword);

	public abstract User findByUserName(Object userName);

	public abstract List<User> findByUserType(Object userType);

	public abstract List<User> findByUserVerify(Object userVerify);

	public abstract List<User> findByUserEmail(Object userEmail);

	public abstract List<User> findByUserPhone(Object userPhone);

	public abstract List<User> findByUserRealname(Object userRealname);

	public abstract List<User> findByUserSex(Object userSex);

	public abstract List<User> findByUserDepartment(Object userDepartment);

	public abstract List<User> findAll();

	public abstract User merge(User detachedInstance);

	public abstract void attachDirty(User instance);

	public abstract void attachClean(User instance);

	public void fillPage(Page<User> page,String hql,Object[] values);
	public void fillPage(Page<User> page,String hql);
	public void fillPage(Page<User> page);
	
	public void update(User user);
}