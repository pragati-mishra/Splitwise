package com.dugs.service;

import java.util.ArrayList;
import java.util.List;

import com.dugs.model.Expense;
import com.dugs.model.User;

public class UserService {
	
	private List<User> userList;
	
	public UserService() {
		this.userList = new ArrayList<>();
	}
	
	public void addUser(User a) {
		userList.add(a);
	}

	public void showBalanceSheet(User a) {
		a.showBalanceSheet();
	}

	public void showBalanceSheet() {
		System.out.println("Showing Splitwise Balancesheet : ");
		for(User u: userList)
		{
			String balanceName = u.getName();
			Double userBalance =u.getBalance();
			if(userBalance < 0.0)
				System.out.println(balanceName+ " is owed "+Math.abs(userBalance));
				else
				System.out.println(balanceName+ " owes  "+Math.abs(userBalance));
		}
		
		System.out.println("====================");
		
	}

	public User getUserByName(String name) {
		for(User u:userList)
			if(u.getName().equals(name))
				return u;
		return null;
	}


		
		
		


}
