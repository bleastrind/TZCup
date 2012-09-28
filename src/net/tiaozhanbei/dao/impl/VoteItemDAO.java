package net.tiaozhanbei.dao.impl;

import net.tiaozhanbei.dao.GenericHibernateDAOCrud;
import net.tiaozhanbei.dao.IVoteItemDAO;
import net.tiaozhanbei.model.VoteItem;

public class VoteItemDAO extends GenericHibernateDAOCrud<VoteItem> implements IVoteItemDAO{

	public VoteItemDAO() {
		super(VoteItem.class);
		}
	public VoteItem findById(int id){
		return super.query(id);
	}
	
}
