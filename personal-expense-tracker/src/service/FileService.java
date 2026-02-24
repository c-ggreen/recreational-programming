package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    private static final String PATH = "src/expenses.txt";

    public static void readExpensesFile(){
                // Use try-with-resources to automatically close the reader
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToExpensesFile(String text){
                // true in the FileWriter constructor enables append mode
        try (FileWriter writer = new FileWriter(PATH, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            bufferedWriter.write(text);
            bufferedWriter.newLine(); // Writes a line separator
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
