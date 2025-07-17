package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deposit {

    // --- Deposit related info ---
    private String memberId;           // कोणत्या member ने deposit केला
    private LocalDate depositDate;     // deposit ची तारीख
    private double amount;             // deposit ची रक्कम

    // Date format for saving/loading dates as string
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    // --- Constructor ---
    public Deposit(String memberId, LocalDate depositDate, double amount) {
        this.memberId = memberId;
        this.depositDate = depositDate;
        this.amount = amount;
    }

    // --- Getters ---
    public String getMemberId() {
        return memberId;
    }

    public LocalDate getDepositDate() {
        return depositDate;
    }

    public double getAmount() {
        return amount;
    }

    // --- Convert object to a string to save in file ---
    // Format: memberId|depositDate|amount
    public String toFileString() {
        return memberId + "|" + depositDate.format(formatter) + "|" + amount;
    }

    // --- Create Deposit object from a file line string ---
    public static Deposit fromFileString(String line) {
        String[] parts = line.split("\\|");

        String memberId = parts[0];
        LocalDate depositDate = LocalDate.parse(parts[1], formatter);
        double amount = Double.parseDouble(parts[2]);

        return new Deposit(memberId, depositDate, amount);
    }
}