package main;

import model.*;
import service.*;
import util.Utils;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Entry point for the Smart Bachat Gat Console Application.
 * Handles user interaction and delegates logic to services.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberService memberService = new MemberService();
        LoanService loanService = new LoanService();
        RepaymentService repaymentService = new RepaymentService();
        ReportService reportService = new ReportService();

        while (true) {
            System.out.println("\n? ---- Smart Bachat Gat App ----");
            System.out.println("1. Add Member");
            System.out.println("2. View Active Members");
            System.out.println("3. Apply Loan");
            System.out.println("4. Repay Loan");
            System.out.println("5. View Report");
            System.out.println("6. Exit");
            System.out.print("Select option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();

                    System.out.print("Enter Mobile No: ");
                    String mobile = scanner.nextLine();

                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter Aadhar No: ");
                    String aadhar = scanner.nextLine();

                    System.out.print("Enter Monthly Contribution: ");
                    double contribution = Double.parseDouble(scanner.nextLine());

                    Member member = new Member(memberId, name, mobile, address, aadhar, contribution, LocalDate.now(), true);
                    memberService.addMember(member);
                    break;

                case 2:
                    System.out.println("📋 Active Members:");
                    for (Member m : memberService.getActiveMembers()) {
                        System.out.println(" - " + m.getName() + " (" + m.getMemberId() + ")");
                    }
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                    String loanMemberId = scanner.nextLine();

                    System.out.print("Enter Loan Amount: ");
                    double loanAmount = Double.parseDouble(scanner.nextLine());

                    loanService.applyLoan(loanMemberId, loanAmount);
                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    String repayMemberId = scanner.nextLine();

                    System.out.print("Enter Repayment Amount: ");
                    double repayAmount = Double.parseDouble(scanner.nextLine());

                    repaymentService.repayLoan(repayMemberId, repayAmount);
                    break;

                case 5:
                    reportService.generateMemberReport();
                    break;

                case 6:
                    System.out.println("👋 Exiting. Thank you!");
                    return;

                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }
    }
}
