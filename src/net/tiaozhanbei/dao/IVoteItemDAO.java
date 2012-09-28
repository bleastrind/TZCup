package net.tiaozhanbei.dao;

import net.tiaozhanbei.model.VoteItem;

public interface IVoteItemDAO {
	public abstract VoteItem findById(int id);
	
	public void update(VoteItem vote);
}
