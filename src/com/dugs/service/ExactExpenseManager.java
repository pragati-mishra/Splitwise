package com.dugs.service;

import com.dugs.model.Expense;
import com.dugs.model.Split;

public class ExactExpenseManager implements ExpenseManager {

	@Override
	public boolean validate(Expense expense) {
		
		Double totalAmount = 0.0;
		for(Split split : expense.getSplits())
		{
			totalAmount+=split.getsplitAmount();
		}
		int compare = totalAmount.compareTo(expense.getAmount());
		if(compare==0)
			return true;
		return false;
		
	}

	@Override
	public void setSplitAmount(Expense expense) {
	
	}

}
