package net.tiaozhanbei.dao;

import java.util.List;

import net.tiaozhanbei.model.Vote;

public interface IVoteDAO {
	public List<Vote> findEnable();
	public abstract void save(Vote transientInstance);

	public abstract void delete(Vote persistentInstance);

	public abstract Vote findById(int id);
	
	public void update(Vote vote);
	
	public List<Vote> findAll();
}