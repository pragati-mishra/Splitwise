package com.dugs.constant;

public enum ActionType {
		EXPENSE, SHOW, QUIT;

	public static ActionType of(String string) {
		
		if(string.equals("EXPENSE"))
			return ActionType.EXPENSE;
		else if(string.equals("SHOW"))
			return ActionType.SHOW;
		else
			return ActionType.QUIT;
	}
}
