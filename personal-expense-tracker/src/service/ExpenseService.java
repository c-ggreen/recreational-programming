package service;

import model.Expense;

public class ExpenseService {
    public static void addExpense(Expense expense){
        String text = expense.getId() + "," + expense.getName() + "," + expense.getDescription() + "," + expense.getAmount() + "," + expense.getTimestamp();
        FileService.writeToExpensesFile(text);
    }

    public static void showAllExpenses(){
        FileService.readExpensesFile();
    }
}
