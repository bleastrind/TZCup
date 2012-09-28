package net.tiaozhanbei.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import net.tiaozhanbei.dao.IUserDAO;
import net.tiaozhanbei.model.Project;
import net.tiaozhanbei.model.User;
import net.tiaozhanbei.service.IUserService;
import net.tiaozhanbei.util.Page;
import net.tiaozhanbei.util.ProjectConst;
import net.tiaozhanbei.util.UserConst;
import net.tiaozhanbei.dao.*;

/**
 * �û�����ģ��
 * @author Administrator
 *
 */
public class UserServiceImpl implements IUserService{

	
	private IUserDAO userDAO;
	private  IProjectDAO projectDAO;

	public IProjectDAO getProjectDAO() {
		return projectDAO;
	}
	public void setProjectDAO(IProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
public void fillPageByNoVerify(Page<User> page) {
	
	userDAO.fillPage(page, "from User where verify=false");	

		
	}
	
	public boolean register(User user) {//�û�ע��ĳ־û�����

		if(user.getType()!=UserConst.Type.COMMONUSER)
			user.setVerify(false);
		else {
			user.setVerify(true);
		}
		//�Ȳ�ѯ��ݿ����Ƿ��Ѵ��ڸ��û���
		if(userDAO.findByUserName(user.getName())!=null)//����У��򲻱��棬����false
		{
			System.out.println("�û��Ѵ��ڣ�");
			return false;
		}else {//�����ڣ���form����ת��Ϊuser����*/
			userDAO.save(user);	//����hibernate��DAO�е�save�������г־û�����	
			System.out.println("�û�ע��ɹ���");
			return true;
		}
		
		 
	}
	@Transactional
	public boolean addmark(int commentAuthorId,int projectId) {

		Project project;
		project=projectDAO.findById(projectId);//�����Ŀ
		
		int score;
		int projectScore;
		if(project.getOwner().getId()==commentAuthorId)
			return false;
		User user=userDAO.findById(commentAuthorId);//���������
		if(user!=null){
		 score=user.getScore();
		score+=UserConst.SubScores.AddScore;
		projectScore=project.getScore();
		projectScore-=ProjectConst.subScore;
		System.out.println(""+projectScore);
		project.setScore(projectScore);
		user.setScore(score);
		projectDAO.update(project);
		userDAO.update(user);
		return true;
		}
		return false;
	}
	public boolean updateUser(User user){
		User user2=userDAO.findById(user.getId());
		BeanUtils.copyProperties(user, user2);
			userDAO.update(user2);		
			return true;				
	}
	public User login(User user){
			if(user.getName()==null)
				return null;
			User user2=userDAO.findByUserName(user.getName());
			String name=user.getName();
			String name2=user2.getName();
			String password=user.getPassword();
			String password2=user2.getPassword();
			System.out.println("::"+user.getName()+user.getPassword());
			System.out.println(""+name2+password2);
			if(name.equals(name2)&&password.equals(password2)){
				return user2;
			}			
			return null;
			}
	public boolean registerMoreUserInfo(User user){
		User user2=userDAO.findByUserName(user.getName());//����ݿ����ȡ�û���Ϣ
		String name=user2.getName();//����û���
		if(user.getType()!=UserConst.Type.COMMONUSER)
			user.setVerify(false);
		if(name!=null){//����û�����ݿ��д���
			user2.setDepartment(user.getDepartment());
			user2.setPhone(user.getPhone());
			user2.setRealName(user.getRealName());
			userDAO.update(user2);		
			return true;
		}
		else
		 return false;
		
	}
	public User getUserById(int userId){
		
		User user=userDAO.findById(userId);
		if(user!=null)
		return user;
		else {
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<User> noVerifyUserlist(){

		
		return userDAO.findByUserVerify(false);
	}
	
	public void addUser(User user) {

			userDAO.save(user);

	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
		
	}
	
	public boolean registerAuthor(User user,Project project){
		
		User user2;
		user2=userDAO.findById(user.getId());		
		user2.setDepartment(user.getDepartment());
		user2.setRealName(user.getRealName());
		user2.setPhone(user.getPhone());
		user2.setVerify(false);
		user2.setType(UserConst.Type.AUTHOR);
		System.out.println("注册作者"+user2.getType());
		project.setOwner(user2);
		user2.getMyProjects().add(project);//将项目添加到用户的项目里面
		userDAO.update(user2);//更新用户
	
		return true;
		//}
		//else return false;
		
	}
	public User checkUserInfo(int id){
		
		User user;
		user=userDAO.findById(id);
		return user;
		
		
	}
	public void verifyUser(User user, boolean pass) {
		
		
			user.setVerify(true);//无论是否审核通过
			if(!pass)
			{
				user.setType(UserConst.Type.COMMONUSER);
			}
			userDAO.update(user);
			if(!pass){
				for (Project project : user.getMyProjects()) {
					user.getMyProjects().remove(project);
					project.setOwner(null);
					projectDAO.delete(project);
					
				}
			}
			
		
	}
	public void removeFavourate(User user, int projectId) {
		Project project = projectDAO.findById(projectId);
		user = userDAO.findById(user.getId());
		user.getFavourateProjects().remove(project);
		userDAO.update(user);
		
	}

	public boolean regProject(User user, Project project) {

		User user2=userDAO.findById(user.getId());//找到用户
		if(user2!=null)
		{
			project.setOwner(user2);//设置项目作者
			user2.getMyProjects().add(project);
			userDAO.update(user2);
			return true;
		}
		
		
		return false;
	}

	public User getUserByName(String Name) {
		
		return userDAO.findByUserName(Name);
	}


}
