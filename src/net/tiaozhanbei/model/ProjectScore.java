package net.tiaozhanbei.model;

/**
 * 评委给项目打的分
 * 
 * @author Administrator
 * 
 */
public class ProjectScore {
	private int id;
	private User judger;
	private int score;
	private int weight;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getJudger() {
		return judger;
	}

	public void setJudger(User judger) {
		this.judger = judger;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
