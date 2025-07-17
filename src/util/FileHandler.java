package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
                                      
import model.Deposit;
import model.Loan;
import model.Member;
import model.Repayment;

public class FileHandler {

    // --- File Paths ---
    private static final String MEMBER_FILE = "data/members.txt";
    private static final String DEPOSIT_FILE = "data/deposits.txt";
    private static final String LOAN_FILE = "data/loans.txt";
    private static final String REPAYMENT_FILE = "data/repayments.txt";

    // --- Save a single line to a file (append mode) ---
    private static void saveLine(String filePath, String line) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        writer.write(line);
        writer.newLine();
        writer.close();
    }

    // --- Save Member to file ---
    public static void saveMember(Member member) throws IOException {
        saveLine(MEMBER_FILE, member.toFileString());
    }

    // --- Save Deposit to file ---
    public static void saveDeposit(Deposit deposit) throws IOException {
        saveLine(DEPOSIT_FILE, deposit.toFileString());
    }

    // --- Save Loan to file ---
    public static void saveLoan(Loan loan) throws IOException {
        saveLine(LOAN_FILE, loan.toFileString());
    }

    // --- Save Repayment to file ---
    public static void saveRepayment(Repayment repayment) throws IOException {
        saveLine(REPAYMENT_FILE, repayment.toFileString());
    }

    // --- Read all Members from file ---
    public static List<Member> readMembers() throws IOException {
        List<Member> members = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(MEMBER_FILE));
        String line;
        while ((line = reader.readLine()) != null) {
            members.add(Member.fromFileString(line));
        }
        reader.close();
        return members;
    }

    // --- Read all Deposits from file ---
    public static List<Deposit> readDeposits() throws IOException {
        List<Deposit> deposits = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(DEPOSIT_FILE));
        String line;
        while ((line = reader.readLine()) != null) {
            deposits.add(Deposit.fromFileString(line));
        }
        reader.close();
        return deposits;
    }

    // --- Read all Loans from file ---
    public static List<Loan> readLoans() throws IOException {
        List<Loan> loans = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(LOAN_FILE));
        String line;
        while ((line = reader.readLine()) != null) {
            loans.add(Loan.fromFileString(line));
        }
        reader.close();
        return loans;
    }

    // --- Read all Repayments from file ---
    public static List<Repayment> readRepayments() throws IOException {
        List<Repayment> repayments = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(REPAYMENT_FILE));
        String line;
        while ((line = reader.readLine()) != null) {
            repayments.add(Repayment.fromFileString(line));
        }
        reader.close();
        return repayments;
    }
}