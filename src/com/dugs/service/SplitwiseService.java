package com.dugs.service;

import com.dugs.model.Expense;
import com.dugs.model.User;

public class SplitwiseService {
	private ExpenseService expenseService;
	private UserService userService;
	
	public SplitwiseService() {
		this.expenseService = new ExpenseService();
		this.userService = new UserService();
	}
	public void createExpense(Expense e1) {
		expenseService.createExpense(e1);
		
	}

	public void showBalanceSheet() {
		userService.showBalanceSheet();
		
	}

	public void showBalanceSheet(User a) {
		 userService.showBalanceSheet(a);
		
	}

	public void addUser(User a) {
		userService.addUser(a);
		
	}
	public User getUserByName(String name) {
		return userService.getUserByName(name);
	}

}
