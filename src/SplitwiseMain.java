import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dugs.constant.ActionType;
import com.dugs.constant.ExpenseType;
import com.dugs.model.EqualSplit;
import com.dugs.model.ExactSplit;
import com.dugs.model.Expense;
import com.dugs.model.PercentSplit;
import com.dugs.model.Split;
import com.dugs.model.User;
import com.dugs.service.SplitwiseService;
import com.dugs.service.UserService;

public class SplitwiseMain {

	public static void main(String[] args) {
		
		User u1 = new User(1,"u1");
		User u2 = new User(2,"u2"); 
		User u3 = new User(3,"u3");
		User u4 = new User(4,"u4");
		SplitwiseService splitwiseService = new SplitwiseService();
		
		//Adding USERS to splitwise
		splitwiseService.addUser(u1);
		splitwiseService.addUser(u2);
		splitwiseService.addUser(u3);
		splitwiseService.addUser(u4);
		
		while(true)
		{
			Scanner s = new Scanner(System.in);
		
			String[] commands = s.nextLine().split(" ");
	            
			ActionType type = ActionType.of(commands[0]);
			//System.out.println(commands[0]);
			switch(type)
			{
			case EXPENSE:
				String paidByUser = commands[1];
				Double amount = Double.parseDouble(commands[2]);
				int nUsers = Integer.parseInt(commands[3]);
				int expenseTypeIndex = 3+nUsers+1;
				ExpenseType expenseType = ExpenseType.of(commands[expenseTypeIndex]);
				List<Split> splits = new ArrayList<>();
				Expense expense;
				
				switch(expenseType)
				{
				case EQUAL:
					for (int i = 0; i < nUsers; i++) {
                        splits.add(new EqualSplit(splitwiseService.getUserByName(commands[4+i])));
                    }
					expense = new Expense(splitwiseService.getUserByName(paidByUser), amount, splits, expenseType);
					splitwiseService.createExpense(expense);
				break;
				case EXACT:
					for (int i = 0; i < nUsers; i++) {
                        splits.add(new ExactSplit(splitwiseService.getUserByName(commands[4+i]), Double.parseDouble(commands[expenseTypeIndex+i+1])));
                    }
					expense = new Expense(splitwiseService.getUserByName(paidByUser), amount, splits, expenseType);
					splitwiseService.createExpense(expense);
				break;
				case PERCENT:
					for (int i = 0; i < nUsers; i++) {
                        splits.add(new 	PercentSplit(splitwiseService.getUserByName(commands[4+i]), Double.parseDouble(commands[expenseTypeIndex+i+1])));
                    }
					expense = new Expense(splitwiseService.getUserByName(paidByUser), amount, splits, expenseType);
					splitwiseService.createExpense(expense);
				break;
				}		
			break;
			case SHOW:
				 if(commands.length == 1)
                     splitwiseService.showBalanceSheet();
                 else
                     splitwiseService.showBalanceSheet(splitwiseService.getUserByName(commands[1]));
                 break;
			
			case QUIT:
				return;
				
			default:
				System.out.println(commands);
			return;
			
			}
			
			
		}
		
		
		//Adding an EQUAL expense added by a on b,c of 1000.00
		/*Split s1 = new EqualSplit(b);
		Split s2 = new EqualSplit(c);
		Split s3 = new EqualSplit(a);
		List<Split> splitList = new ArrayList<>();
		splitList.add(s1);
		splitList.add(s2);
		splitList.add(s3);
		Expense e1 = new Expense(a,1000.00, splitList, ExpenseType.EQUAL);
		*/
		
		//Adding an EXACT expense added by a on b,c of 1000.00
		/*Split s1 = new ExactSplit(b,300.00);
		Split s2 = new ExactSplit(c,600.00);
		Split s3 = new ExactSplit(a,100.00);
		List<Split> splitList = new ArrayList<>();
		splitList.add(s1);
		splitList.add(s2);
		splitList.add(s3);
		Expense e1 = new Expense(a,1000.00, splitList, ExpenseType.EXACT);
		splitwiseService.createExpense(e1);
		
		splitwiseService.showBalanceSheet();
		
		splitwiseService.showBalanceSheet(a);
		*/
		
		////Adding a PERCENT expense added by a on b,c of 1000.00
		/*Split s1 = new PercentSplit(b,30.00);
		Split s2 = new PercentSplit(c,60.00);
		Split s3 = new PercentSplit(a,10.00);
		List<Split> splitList = new ArrayList<>();
		splitList.add(s1);
		splitList.add(s2);
		splitList.add(s3);
		Expense e1 = new Expense(a,1000.00, splitList, ExpenseType.PERCENT);
		splitwiseService.createExpense(e1);
		
		splitwiseService.showBalanceSheet();
		
		splitwiseService.showBalanceSheet(a);
		*/
		
		
	}

}
