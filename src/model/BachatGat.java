package model;

import service.MemberService;
import service.LoanService;
import service.ReportService;


import java.util.List;

/**
 * Central management class for the Smart Bachat Gat application.
 */
public class BachatGat {

    private MemberService memberService;
    private LoanService loanService;
    private ReportService reportService;

    public BachatGat() {
        this.memberService = new MemberService();
        this.loanService = new LoanService();
        this.reportService = new ReportService();
    }

    /**
     * Adds a new member to the group.
     */
    public void addMember(Member member) {
        memberService.addMember(member);
    }

    /**
     * Apply a loan for the given member.
     */
    public void applyLoan(String memberId, double amount) {
        Member member = memberService.getMemberById(memberId);
        if (member != null) {
            loanService.applyLoan(member, amount);
            System.out.println("✅ Loan applied successfully.");
        } else {
            System.out.println("❌ Member not found.");
        }
    }

    /**
     * Repay a loan for the given member.
     */
    public void repayLoan(String memberId, double amount) {
        Member member = memberService.getMemberById(memberId);
        if (member != null) {
            loanService.repayLoan(member, amount);
            System.out.println("✅ Repayment successful.");
        } else {
            System.out.println("❌ Member not found.");
        }
    }

    /**
     * Show a report of total deposits and outstanding loans.
     */
    public void showReport() {
        List<Member> members = memberService.getActiveMembers();
        double totalDeposits = reportService.totalDeposits(members);
        double totalLoans = reportService.totalOutstandingLoans(members);
        System.out.println("\n📊 --- Bachat Gat Report ---");
        System.out.println("Total Deposits: ₹" + totalDeposits);
        System.out.println("Total Outstanding Loans: ₹" + totalLoans);
    }

    /**
     * List all active members.
     */
    public void listActiveMembers() {
        List<Member> activeMembers = memberService.getActiveMembers();
        if (activeMembers.isEmpty()) {
            System.out.println("No active members found.");
        } else {
            System.out.println("\n📋 --- Active Members ---");
            for (Member m : activeMembers) {
                System.out.println("ID: " + m.getMemberId() + ", Name: " + m.getMemberName());
            }
        }
    }

    public MemberService getMemberService() {
        return memberService;
    }

    public LoanService getLoanService() {
        return loanService;
    }

    public ReportService getReportService() {
        return reportService;
    }
}