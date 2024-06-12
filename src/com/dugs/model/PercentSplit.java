package com.dugs.model;

public class PercentSplit extends Split{
	private Double percent;
	public 	PercentSplit(User user, Double percent) {
		super(user);
		this.setPercent(percent);
	}
	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		this.percent = percent;
	}
}
