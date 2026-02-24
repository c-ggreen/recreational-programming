package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String PATH = "src/expenses.txt";

    public static List<String> readExpensesFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            List<String> output = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                output.add(line);
            }
            return output;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
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
