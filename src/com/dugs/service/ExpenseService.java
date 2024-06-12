package com.dugs.service;

import java.util.ArrayList;
import java.util.List;

import com.dugs.factory.ExpenseManagerFactory;
import com.dugs.model.Expense;
import com.dugs.model.User;

public class ExpenseService {
	private BalanceSheetService balancesheetService;
	private List<Expense> expenseList;
	
	public ExpenseService() {
		this.balancesheetService = new BalanceSheetService();
		this.expenseList = new ArrayList<>();
	}
	
	public void createExpense(Expense expense) {
		ExpenseManagerFactory emFactory = new ExpenseManagerFactory();
		
		ExpenseManager expenseManager = emFactory.getExpenseManager(expense.getExpenseType());
		
		if(!expenseManager.validate(expense)) {
			System.out.println("Error : Invalid Expense");
		}
		else
		{
			expenseManager.setSplitAmount(expense);
			balancesheetService.updateBalanceSheet(expense);
		}	
		
		
	}

}
