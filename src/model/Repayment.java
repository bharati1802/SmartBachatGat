package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Repayment {

    // --- Repayment-related information ---
    private String memberId;             // ID of the member who is making the repayment
    private LocalDate repaymentDate;     // Date of repayment
    private double principalAmount;      // Principal portion of the repayment
    private double interestAmount;       // Interest portion of the repayment

    // Formatter to convert LocalDate to String and back
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    // --- Constructor ---
    public Repayment(String memberId, LocalDate repaymentDate, double principalAmount, double interestAmount) {
        this.memberId = memberId;
        this.repaymentDate = repaymentDate;
        this.principalAmount = principalAmount;
        this.interestAmount = interestAmount;
    }

    // --- Getters ---
    public String getMemberId() {
        return memberId;
    }

    public LocalDate getRepaymentDate() {
        return repaymentDate;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    // --- Convert this object to a line to save in a file ---
    // Format: memberId|repaymentDate|principalAmount|interestAmount
    public String toFileString() {
        return memberId + "|" + repaymentDate.format(formatter) + "|" + principalAmount + "|" + interestAmount;
    }

    // --- Create Repayment object from a line read from a file ---
    public static Repayment fromFileString(String line) {
        String[] parts = line.split("\\|");

        String memberId = parts[0];
        LocalDate repaymentDate = LocalDate.parse(parts[1], formatter);
        double principalAmount = Double.parseDouble(parts[2]);
        double interestAmount = Double.parseDouble(parts[3]);

        return new Repayment(memberId, repaymentDate, principalAmount, interestAmount);
    }
}