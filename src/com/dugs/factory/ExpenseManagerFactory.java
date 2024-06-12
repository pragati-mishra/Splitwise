package com.dugs.factory;

import com.dugs.constant.ExpenseType;
import com.dugs.service.EqualExpenseManager;
import com.dugs.service.ExactExpenseManager;
import com.dugs.service.ExpenseManager;
import com.dugs.service.PercentExpenseManager;

public class ExpenseManagerFactory {

	public ExpenseManager getExpenseManager(ExpenseType expenseType) {
		
		switch(expenseType) {
			case EQUAL:
				return new EqualExpenseManager();
			case EXACT:
				return new ExactExpenseManager();
			case PERCENT:
				return (ExpenseManager) new PercentExpenseManager();
			default:
				return null;			
				
		}
		
	}

}
