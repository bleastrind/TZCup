package net.tiaozhanbei.model;

import java.util.Date;



public class Letter {
	private int id;
	private String title;
	private User sender;
	private User receiver;
	private String content;
	private Date Time;
	private int checked;
	private int state;
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
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return Time;
	}

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }
	public void setTime(Date time) {
		Time = time;
	}

	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

}
