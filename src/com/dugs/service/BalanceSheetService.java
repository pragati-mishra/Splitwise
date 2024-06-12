package com.dugs.service;

import com.dugs.model.Expense;
import com.dugs.model.Split;
import com.dugs.model.User;

public class BalanceSheetService {


	public void updateBalanceSheet(Expense expense) {
		User paidByUser = expense.getPaidByUser();
		
		for(Split split : expense.getSplits())
		{
			if(!split.getUser().equals(paidByUser))
			{paidByUser.updateUserBalanceSheet(split.getUser(),-1 * split.getsplitAmount());
			split.getUser().updateUserBalanceSheet(paidByUser, split.getsplitAmount());				
			}
		}
		
	}


}
