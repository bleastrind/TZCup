package net.tiaozhanbei.model;

import java.util.HashSet;
import java.util.Set;
@SuppressWarnings("unchecked")
public class Vote {

    private int id;
    private String title;
    private String description;
    private int type;
	private Set voteItems=new HashSet();
    private boolean enable=false;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<VoteItem> getVoteItems() {
		return voteItems;
	}
	public void setVoteItems(Set voteItems) {
		this.voteItems = voteItems;
	}
	public boolean getEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

}