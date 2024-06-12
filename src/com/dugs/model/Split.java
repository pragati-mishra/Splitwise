package com.dugs.model;

public abstract class Split {
	private User user;
	
	Double splitAmount;
	
	public Split(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getsplitAmount() {
		return splitAmount;
	}
	public void setsplitAmount(Double splitAmount) {
		this.splitAmount = splitAmount;
	}
}
