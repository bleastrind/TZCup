package net.tiaozhanbei.dao.impl;

import java.util.List;
import net.tiaozhanbei.dao.GenericHibernateDAOCrud;
import net.tiaozhanbei.dao.IVoteDAO;
import net.tiaozhanbei.model.Vote;

import org.springframework.context.ApplicationContext;
/**
 	* A data access object (DAO) providing persistence and search support for Vote entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see net.tiaozhanbei.model.Vote
  * @author MyEclipse Persistence Tools 
 */

public class VoteDAO extends GenericHibernateDAOCrud<Vote> implements IVoteDAO  {
    public VoteDAO() {
		super(Vote.class);
		}

	@SuppressWarnings("unchecked")
	public List<Vote> findEnable(){
		return queryForLists("from Vote where enable =?", new Object[]{true});
	}
	
	public static VoteDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (VoteDAO) ctx.getBean("VoteDAO");
	}

	public Vote findById(int id) {
		return super.query(id);
	}

	public void save(Vote transientInstance) {
		super.create(transientInstance);
		
	}

	@SuppressWarnings("unchecked")
	public List<Vote> findAll() {
		String queryString = "from Vote";
	 	return getHibernateTemplate().find(queryString);
	}
}