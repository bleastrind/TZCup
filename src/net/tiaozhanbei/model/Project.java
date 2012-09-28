package net.tiaozhanbei.model;

import java.util.HashSet;
import java.util.Set;
@SuppressWarnings("unchecked")
public class Project {

    private int id;
    private String name;
    private String type;
    private User owner;
    private String brief;
    private String detal="";
    private String picPath;
    private ProjectState state=new ProjectState();
    private Set interestCompany=new HashSet();
    private int score;
    private FileInfo showFile;
    public FileInfo getShowFile() {
		return showFile;
	}

	public void setShowFile(FileInfo showFile) {
		this.showFile = showFile;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }


    public String getDetal() {
        return detal;
    }

    public void setDetal(String detal) {
        this.detal = detal;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


	public ProjectState getState() {
		return state;
	}

	public void setState(ProjectState state) {
		this.state = state;
	}

	public Set<User> getInterestCompany() {
		return interestCompany;
	}

	public void setInterestCompany(Set intrestCompanys) {
		this.interestCompany = intrestCompanys;
	}
}