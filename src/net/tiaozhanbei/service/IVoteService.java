package net.tiaozhanbei.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.tiaozhanbei.exception.DAOException;
import net.tiaozhanbei.model.Vote;

public interface IVoteService {

	public List<Vote> getEnableVotes();
	@Transactional
	public void addVote(Vote vote) throws DAOException;
	
	@Transactional
	public void switchEnable(int voteId) throws DAOException;
	
	public List<Vote> getAll();
	
	@Transactional
	public void vote(int voteItemId) throws DAOException;

	public Vote getVote(int id);
	
	@Transactional
	public void delVote(int id);
}
