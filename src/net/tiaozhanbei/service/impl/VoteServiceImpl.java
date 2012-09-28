package net.tiaozhanbei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tiaozhanbei.dao.IVoteDAO;
import net.tiaozhanbei.dao.IVoteItemDAO;
import net.tiaozhanbei.exception.DAOException;
import net.tiaozhanbei.model.Vote;
import net.tiaozhanbei.model.VoteItem;
import net.tiaozhanbei.service.IVoteService;

@Service("voteService")
public class VoteServiceImpl implements IVoteService{

	@Autowired
	private IVoteDAO voteDAO;
	@Autowired
	private IVoteItemDAO voteItemDAO;
	public void addVote(Vote vote) throws DAOException {
		try{
			voteDAO.save(vote);
		}catch(Exception e){
			System.out.println("VoteService:addVote failed!");
			throw new DAOException(e.getMessage());
		}
	}

	public List<Vote> getEnableVotes() {
		return voteDAO.findEnable();
	}

	public List<Vote> getAll() {
	
		return voteDAO.findAll();
	}

	public void switchEnable(int voteid) throws DAOException {
		try{
			Vote vote =voteDAO.findById(voteid);
			vote.setEnable(!vote.getEnable());
			voteDAO.update(vote);
		}catch (Exception e) {
			System.out.println("VoteService:switchEanble failed!");
			System.out.println("voteid="+voteid);
			throw new DAOException(e.getMessage());
		}
	}

	public void vote(int voteItemId) throws DAOException {
		try{
			VoteItem item = voteItemDAO.findById(voteItemId);
			item.setVotes(item.getVotes()+1);
			voteItemDAO.update(item);
		}catch (Exception e) {
			System.out.println("VoteService:vote failed!");
			System.out.println("voteItemid="+voteItemId);
			throw new DAOException(e.getMessage());
		}
	}

	public Vote getVote(int id) {
		return voteDAO.findById(id);
	}

	public void delVote(int id) {
		Vote vote = new Vote();
		vote.setId(id);
		voteDAO.delete(vote);
		
	}

	

}
