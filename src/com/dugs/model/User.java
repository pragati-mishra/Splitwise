package com.dugs.model;

import java.util.HashMap;
import java.util.Map;

public class User {
	
	private Integer userId;
	private String name;
	private Map<User, Double> balanceSheet;
	private Double balance;

	
	public User( Integer userId, String name) {
		this.setName(name);
		this.setUserId(userId);
		this.setBalanceSheet(new HashMap());
		this.setBalance(0.0);
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void showBalanceSheet() {
		System.out.println("Showing Balancesheet for User: "+ this.name);
		for(User user: getBalanceSheet().keySet())
		{
			String balanceName = user.getName();
			Double userBalance = getBalanceSheet().get(user);
			String formatNumber = String.format("%.2f",userBalance);
			userBalance = Double.parseDouble(formatNumber);
			if(userBalance < 0)
			System.out.println(balanceName+ " owes you "+Math.abs(userBalance));
			else
			System.out.println(this.name+ " owes "+balanceName+ " " +Math.abs(userBalance));
		}
		System.out.println("====================");
		
	}

	public Double getBalance() {
		String formatNumber = String.format("%.2f",balance);
		Double trimmedBalance = Double.parseDouble(formatNumber);
		return trimmedBalance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Map<User, Double> getBalanceSheet() {
		return balanceSheet;
	}

	public void setBalanceSheet(Map<User, Double> balanceSheet) {
		this.balanceSheet = balanceSheet;
	}

	public void updateUserBalanceSheet(User user, double splitAmount) {
		
		if(!this.balanceSheet.containsKey(user))
		{
			this.balanceSheet.put(user, splitAmount);
			this.setBalance(this.getBalance()+splitAmount);
		}
		else
		{
			Double currentSplit = balanceSheet.get(user);
			this.balanceSheet.put(user, currentSplit+splitAmount);
			this.setBalance(this.getBalance()+splitAmount);
		}
		
	}

	
	}

	


