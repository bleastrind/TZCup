package net.tiaozhanbei.model;

import java.util.Date;

/**
 * visitHistory entity. @author MyEclipse Persistence Tools
 */
public class visitHistory {


    // Fields    
	private int id;
    private Date modifytime;
    private Integer activenum;
    private Integer totalnum;


    // Constructors
    /** default constructor */
    public visitHistory() {
    }

    /** minimal constructor */
    public visitHistory(Date modifytime) {
        this.modifytime = modifytime;
    }

    /** full constructor */
    public visitHistory(Date modifytime, Integer activenum, Integer totalnum) {
        this.modifytime = modifytime;
        this.activenum = activenum;
        this.totalnum = totalnum;
    }

    // Property accessors
    public Date getModifytime() {
        return this.modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Integer getActivenum() {
        return this.activenum;
    }

    public void setActivenum(Integer activenum) {
        this.activenum = activenum;
    }

    public Integer getTotalnum() {
        return this.totalnum;
    }

    public void setTotalnum(Integer totalnum) {
        this.totalnum = totalnum;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}