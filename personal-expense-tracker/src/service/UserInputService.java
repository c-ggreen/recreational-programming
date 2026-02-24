package service;

import java.time.Instant;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.IntStream;

import model.Expense;
import model.Category;

public class UserInputService {
    private static final int[] promptChoices = { 1, 2 };

    public static void selectOption() {
        Scanner scanner = new Scanner(System.in);
        try {

            String prompt = "Select an option:" + "\n" +
                    "[1]: Add an expense." + "\n" +
                    "[2]: Show all expenses.";
            System.out.println(prompt);
            int choice = scanner.nextByte();

            if (IntStream.of(promptChoices).anyMatch(x -> x == choice)) {
                switch (choice) {
                    case 1:
                        Expense expense = getExpenseInput();
                        ExpenseService.addExpense(expense);
                        break;
                    case 2:
                        ExpenseService.showAllExpenses();
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    }

    public static Expense getExpenseInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            Expense expense = new Expense();

            System.out.println("Name of the expense?");
            String name = scanner.nextLine();

            System.out.println("Category of the expense? (RETAIL, GROCERY, TRANSPORTATION, OTHER");
            String category_string = scanner.nextLine();
            Category category = Category.valueOf(category_string.toUpperCase());

            System.out.println("Amount of the expense?");
            String amount_string = scanner.nextLine();
            float amount = Float.parseFloat(amount_string);

            expense.setId(UUID.randomUUID());
            expense.setName(name);
            expense.setCategory(category);
            expense.setAmount(amount);
            expense.setTimestamp(Instant.now());

            return expense;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
