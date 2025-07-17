package service;

import model.Deposit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles deposit-related operations such as adding and reading deposits.
 */
public class DepositService {

    private static final String FILE_PATH = "data/deposits.txt";

    /**
     * Adds a deposit and saves it to the deposits.txt file.
     */
    public void addDeposit(Deposit deposit) {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs(); // Ensure "data" folder exists

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); // append mode
            writer.write(deposit.toFileString());
            writer.newLine();
            writer.close();

            System.out.println("✅ Deposit saved to deposits.txt");
        } catch (IOException e) {
            System.out.println("❌ Error saving deposit: " + e.getMessage());
        }
    }

    /**
     * Reads all deposits from the file and returns as a list.
     */
    public List<Deposit> getAllDeposits() {
        List<Deposit> deposits = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                deposits.add(Deposit.fromFileString(line));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("❌ Error reading deposits: " + e.getMessage());
        }

        return deposits;
    }
}
