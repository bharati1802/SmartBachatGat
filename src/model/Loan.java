package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Loan {

    // --- Loan-related information ---
    private String memberId;           // ID of the member who took the loan
    private LocalDate loanDate;        // Date when the loan was taken
    private double loanAmount;         // Total loan amount
    private double interestRate;       // Interest rate on the loan (e.g. 12.5%)
    private int durationMonths;        // Duration of the loan in months

    // Date formatter to convert LocalDate to and from String
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    // --- Constructor ---
    public Loan(String memberId, LocalDate loanDate, double loanAmount, double interestRate, int durationMonths) {
        this.memberId = memberId;
        this.loanDate = loanDate;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.durationMonths = durationMonths;
    }

    // --- Getters ---
    public String getMemberId() {
        return memberId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    // --- Convert object to string to save in file ---
    // Format: memberId|loanDate|loanAmount|interestRate|durationMonths
    public String toFileString() {
        return memberId + "|" + loanDate.format(formatter) + "|" + loanAmount + "|" + interestRate + "|" + durationMonths;
    }

    // --- Create Loan object from file line ---
    public static Loan fromFileString(String line) {
        String[] parts = line.split("\\|");

        String memberId = parts[0];
        LocalDate loanDate = LocalDate.parse(parts[1], formatter);
        double loanAmount = Double.parseDouble(parts[2]);
        double interestRate = Double.parseDouble(parts[3]);
        int durationMonths = Integer.parseInt(parts[4]);

        return new Loan(memberId, loanDate, loanAmount, interestRate, durationMonths);
    }
}