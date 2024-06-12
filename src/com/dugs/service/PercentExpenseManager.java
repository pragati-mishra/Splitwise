package com.dugs.service;

import com.dugs.model.Expense;
import com.dugs.model.PercentSplit;
import com.dugs.model.Split;

public class PercentExpenseManager implements ExpenseManager{

	@Override
	public boolean validate(Expense expense) {		
		Double totalPercent = 0.0;
		for(Split split : expense.getSplits())
		{
			PercentSplit pSplit = (PercentSplit) split;
			totalPercent+=pSplit.getPercent();
		}
		
		if(totalPercent.compareTo(100.00) == 0)
			return true;
		return false;
	}

	@Override
	public void setSplitAmount(Expense expense) {
		
		for(Split split : expense.getSplits())
		{
			PercentSplit pSplit = (PercentSplit) split;
			Double splitAmount = (pSplit.getPercent() * expense.getAmount())/100;
			pSplit.setsplitAmount(splitAmount);
		}

		
	}

}
