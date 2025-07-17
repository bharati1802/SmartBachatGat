package service;

import model.Member;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.time.LocalDate;

/**
 * This class manages loan related operations for members.
 */
public class LoanService {

    /**
     * Member takes a loan of given amount and record is saved to loans.txt.
     */
    public void applyLoan(Member member, double amount) {
        member.takeLoan(amount); // in-memory update

        try {
            File file = new File("data/loans.txt");
            file.getParentFile().mkdirs();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            String record = member.getMemberId() + "," + amount + "," + LocalDate.now();
            writer.write(record);
            writer.newLine();
            writer.close();

            System.out.println("✅ Loan applied and saved to loans.txt");
        } catch (IOException e) {
            System.out.println("❌ Error saving loan: " + e.getMessage());
        }
    }

    /**
     * Member repays a loan of given amount and record is saved to repayments.txt.
     */
    public void repayLoan(Member member, double amount) {
        member.repayLoan(amount); // in-memory update

        try {
            File file = new File("data/repayments.txt");
            file.getParentFile().mkdirs();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            String record = member.getMemberId() + "," + amount + "," + LocalDate.now();
            writer.write(record);
            writer.newLine();
            writer.close();

            System.out.println("✅ Repayment saved to repayments.txt");
        } catch (IOException e) {
            System.out.println("❌ Error saving repayment: " + e.getMessage());
        }
    }

    /**
     * Calculate outstanding loan for member.
     */
    public double getOutstandingLoan(Member member) {
        return member.getOutstandingLoan();
    }
}
