package com.dugs.constant;

public enum ExpenseType {
	EXACT, EQUAL, PERCENT;

	public static ExpenseType of(String string) {
		if(string.equals("EXACT"))
			return EXACT;
		else if(string.equals("EQUAL"))
			return EQUAL;
		else if(string.equals("PERCENT"))
			return PERCENT;
		return null;
	}
}
