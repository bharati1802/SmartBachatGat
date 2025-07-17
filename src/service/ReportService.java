package service;

import model.Member;
import java.util.List;

/**
 * This class generates summary reports.
 */
public class ReportService {

    /**
     * Calculate total deposits of all active members.
     */
    public double totalDeposits(List<Member> members) {
        double sum = 0.0;
        for (Member m : members) {
            if (m.isActive()) {
                sum += m.getTotalDeposit();
            }
        }
        return sum;
    }

    /**
     * Calculate total outstanding loan of all active members.
     */
    public double totalOutstandingLoans(List<Member> members) {
        double sum = 0.0;
        for (Member m : members) {
            if (m.isActive()) {
                sum += m.getOutstandingLoan();
            }
        }
        return sum;
    }
}