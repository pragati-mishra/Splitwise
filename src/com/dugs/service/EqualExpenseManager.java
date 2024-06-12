package com.dugs.service;

import com.dugs.model.Expense;
import com.dugs.model.Split;

public class EqualExpenseManager implements ExpenseManager{

	@Override
	public boolean validate(Expense expense) {
		return true;
		
	}

	@Override
	public void setSplitAmount(Expense expense) {
		Double splitAmount = expense.getAmount()/expense.getSplits().size();
		for(Split split : expense.getSplits())
		{
			split.setsplitAmount(splitAmount);
		}

	}

}
