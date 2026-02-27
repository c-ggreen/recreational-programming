package service;

import java.time.Instant;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.IntStream;

import model.Expense;
import model.Category;

public class UserInputService {
    private static final int[] promptChoices = { 1, 2, 3, 0 };

    public static void selectOption() {
        Scanner scanner = new Scanner(System.in);
        try {
            boolean isLooping = true;
            while (isLooping) {
                String prompt = "\nSelect an option:" + "\n" +
                        "[1]: Add an expense." + "\n" +
                        "[2]: Show all expenses." + "\n" +
                        "[3]: Show total of expenses." + "\n" +
                        "[0]: Exit";
                System.out.println(prompt);
                // Using .nextLine() instead of .nextInt() to avoid "Scanner Trap" bug
                // where if a .nextLine() is invoked after .nextInt() it skips the accompanying
                // .println() altogether
                int choice = Integer.parseInt(scanner.nextLine());

                if (IntStream.of(promptChoices).anyMatch(x -> x == choice)) {
                    switch (choice) {
                        case 1:
                            Expense expense = getExpenseInput(scanner);
                            ExpenseService.addExpense(expense);
                            break;
                        case 2:
                            ExpenseService.showAllExpenses();
                            break;
                        case 3:
                            ExpenseService.showTotalExpense();
                            break;
                        case 0:
                            isLooping = false;
                            break;
                        default:
                            break;
                    }
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

    public static Expense getExpenseInput(Scanner scanner) {
        try {
            System.out.println("Name of the expense?");
            String name = scanner.nextLine();

            System.out.println("Category of the expense? (RETAIL, GROCERY, TRANSPORTATION, OTHER)");
            String category_string = scanner.nextLine();
            Category category = Category.valueOf(category_string.toUpperCase());

            System.out.println("Amount of the expense?");
            String amount_string = scanner.nextLine();
            float amount = Float.parseFloat(amount_string);

            return new Expense(UUID.randomUUID(), name, category, amount, Instant.now());
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
