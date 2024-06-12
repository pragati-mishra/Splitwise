package com.dugs.model;

import java.util.List;
import java.util.UUID;

import com.dugs.constant.ExpenseType;

public class Expense {
	
	String expenseId;
	private User paidByUser;
	private Double 	amount;
	private List<Split> splits;
	private ExpenseType expenseType;	
	
	public Expense(User paidByUser, Double amount, List<Split> splits, ExpenseType expenseType) {
		this.expenseId = UUID.randomUUID().toString();
		this.setPaidByUser(paidByUser);
		this.setAmount(amount);
		this.setSplits(splits);
		this.setExpenseType(expenseType);
	}

	public ExpenseType getExpenseType() {
		return this.expenseType;
	}

	public User getPaidByUser() {
		return paidByUser;
	}

	public void setPaidByUser(User paidByUser) {
		this.paidByUser = paidByUser;
	}

	public List<Split> getSplits() {
		return splits;
	}

	public void setSplits(List<Split> splits) {
		this.splits = splits;
	}

	public void setExpenseType(ExpenseType expenseType) {
		this.expenseType = expenseType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}	
