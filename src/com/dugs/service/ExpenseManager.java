package com.dugs.service;

import com.dugs.model.Expense;

public interface ExpenseManager {
		public boolean validate(Expense expense);
		public void setSplitAmount(Expense expense);
		
}
