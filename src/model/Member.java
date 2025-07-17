package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a member of the Bachat Gat group.
 * Stores personal details, financial status, and activity status.
 */
public class Member {

    // --- Personal Info ---
    private String memberName;
    private String memberId;
    private String mobileNumber;
    private String address;
    private LocalDate dateOfJoining;
    private String aadharNumber;

    // --- Financial Info ---
    private double monthlyContribution;
    private double totalDeposit;
    private double loanTaken;
    private double loanRepaid;
    private double interestPaid;
    private boolean isActive;

    // Formatter to convert date to String and back
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    // --- Constructor ---
    public Member(String memberName, String memberId, String mobileNumber, String address,
                  LocalDate dateOfJoining, String aadharNumber, double monthlyContribution) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.dateOfJoining = dateOfJoining;
        this.aadharNumber = aadharNumber;
        this.monthlyContribution = monthlyContribution;

        // Default financial values
        this.totalDeposit = 0.0;
        this.loanTaken = 0.0;
        this.loanRepaid = 0.0;
        this.interestPaid = 0.0;
        this.isActive = true;
    }

    // --- Getters ---
    public String getMemberName() { return memberName; }
    public String getMemberId() { return memberId; }
    public String getMobileNumber() { return mobileNumber; }
    public String getAddress() { return address; }
    public LocalDate getDateOfJoining() { return dateOfJoining; }
    public String getAadharNumber() { return aadharNumber; }
    public double getMonthlyContribution() { return monthlyContribution; }
    public double getTotalDeposit() { return totalDeposit; }
    public double getLoanTaken() { return loanTaken; }
    public double getLoanRepaid() { return loanRepaid; }
    public double getInterestPaid() { return interestPaid; }
    public boolean isActive() { return isActive; }

    // --- Setters / Update methods ---

    // Add deposited amount to total deposit
    public void addDeposit(double amount) {
        this.totalDeposit += amount;
    }

    // Add loan amount taken
    public void takeLoan(double amount) {
        this.loanTaken += amount;
    }

    // Add amount to loan repaid
    public void repayLoan(double amount) {
        this.loanRepaid += amount;
    }

    // Add interest paid by member
    public void payInterest(double amount) {
        this.interestPaid += amount;
    }

    // Set member as active or inactive
    public void setActive(boolean active) {
        this.isActive = active;
    }

    // --- Utility method to get pending loan amount ---
    public double getOutstandingLoan() {
        return loanTaken - loanRepaid;
    }

    // -------------------------------
    // Convert Member object to String for saving in file
    // -------------------------------
    public String toFileString() {
        return memberId + "|" +
               memberName + "|" +
               mobileNumber + "|" +
               address + "|" +
               dateOfJoining.format(formatter) + "|" +
               aadharNumber + "|" +
               monthlyContribution + "|" +
               totalDeposit + "|" +
               loanTaken + "|" +
               loanRepaid + "|" +
               interestPaid + "|" +
               isActive;
    }

    // -------------------------------
    //  Create Member object from String read from file
    // -------------------------------
    public static Member fromFileString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length != 12) {
            throw new IllegalArgumentException("Invalid member record: " + line);
        }

        // Extract fields from line
        String memberId = parts[0];
        String memberName = parts[1];
        String mobileNumber = parts[2];
        String address = parts[3];
        LocalDate doj = LocalDate.parse(parts[4], formatter);
        String aadhar = parts[5];
        double monthlyContribution = Double.parseDouble(parts[6]);

        // Create basic member object using constructor
        Member m = new Member(memberName, memberId, mobileNumber, address, doj, aadhar, monthlyContribution);

        // Set remaining financial details
        m.totalDeposit = Double.parseDouble(parts[7]);
        m.loanTaken = Double.parseDouble(parts[8]);
        m.loanRepaid = Double.parseDouble(parts[9]);
        m.interestPaid = Double.parseDouble(parts[10]);
        m.isActive = Boolean.parseBoolean(parts[11]);

        return m;
    }
}