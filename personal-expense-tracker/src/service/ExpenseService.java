package service;

import java.util.List;

import model.Expense;

public class ExpenseService {
    public static void addExpense(Expense expense){
        System.out.println("\nAdding expense...");
        String text = expense.id() + "," + expense.name() + "," + expense.category() + "," + expense.amount() + "," + expense.timestamp();
        FileService.writeToExpensesFile(text);
        System.out.println("Expense added!");
    }

    public static void showAllExpenses(){
        List<String> expenses = FileService.readExpensesFile();
        expenses.forEach(element -> System.out.println(element));
    }

    public static void showTotalExpense(){
        List<String> expenses = FileService.readExpensesFile();
        float totalAmount = 0.0f;
        for(String element : expenses){
             totalAmount += Float.parseFloat(element.split(",")[3]);
        }
        System.out.printf("Total expense: $%.2f%n", totalAmount);
    }
}
