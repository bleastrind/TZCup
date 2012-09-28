package net.tiaozhanbei.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import net.tiaozhanbei.dao.IUserDAO;
import net.tiaozhanbei.model.Project;
import net.tiaozhanbei.model.User;
import net.tiaozhanbei.util.Page;
public interface IUserService {

	@Transactional
	public void addUser(User user);
	
	public IUserDAO getUserDAO();
	public void setUserDAO(IUserDAO userDAO);
	public User getUserById(int userId);
	
	@Transactional
	public boolean register(User user);
	
	public User login(User user);
	@Transactional
	public boolean registerMoreUserInfo(User user);
	public User checkUserInfo(int id);
	
	public List<User>  noVerifyUserlist();
	@Transactional
	public boolean registerAuthor(User user,Project project);
	@Transactional
	public boolean updateUser(User user);
	
	@Transactional
	public void verifyUser(User user,boolean pass);
	
	@Transactional
	public void removeFavourate(User user,int projectId);
	public void fillPageByNoVerify(Page<User> page);
	public boolean addmark(int commentAuthorId,int project);

	@Transactional
	public boolean regProject(User user,Project project);

	
	public User getUserByName(String Name);

}
