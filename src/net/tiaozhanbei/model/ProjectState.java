package net.tiaozhanbei.model;

import java.util.Set;



/**
 * ÏîÄ¿µÄ×´Ì¬
 * @author Administrator
 *
 */
@SuppressWarnings("unchecked")
public class ProjectState {
	private int id;
	private int votes;
	private int process;
	private int rank;
	private Set scores;
	private int avgStars;
	private Project project;
	private int starnum;
	private int visit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public int getProcess() {
		return process;
	}
	public void setProcess(int process) {
		this.process = process;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public Set<ProjectScore> getScores() {
		return scores;
	}
	public void setScores(Set scores) {
		this.scores = scores;
	}
	public int getTotalStars() {
		return avgStars;
	}
	public void setTotalStars(int avgstars) {
		this.avgStars = avgstars;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public int getStarnum() {
		return starnum;
	}
	public void setStarnum(int starnum) {
		this.starnum = starnum;
	}
	public int getVisit() {
		return visit;
	}
	public void setVisit(int visit) {
		this.visit = visit;
	}
}
