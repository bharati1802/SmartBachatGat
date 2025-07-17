package service;

import model.Member;
import util.FileHandler;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

/**
 * This class manages Member related operations like
 * adding, searching, and listing members.
 */
public class MemberService {

    // List to store all members in memory
    private List<Member> members = new ArrayList<>();

    /**
     * Adds a new member to the list and saves to file.
     */
    public void addMember(Member member) {
        members.add(member); // In-memory list

        try {
            FileHandler.saveMember(member);  // ✅ Standard method to save
            System.out.println("✅ Member added successfully.");
        } catch (IOException e) {
            System.out.println("❌ Failed to save member: " + e.getMessage());
        }
    }

    /**
     * Finds and returns a member by their memberId.
     * First checks in-memory, if not found then checks file.
     */
    public Member getMemberById(String memberId) {
        // Step 1: Check in-memory
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) {
                return m;
            }
        }

        // Step 2: If not found, read from file
        try {
            List<Member> fileMembers = FileHandler.readMembers();
            for (Member m : fileMembers) {
                if (m.getMemberId().equals(memberId)) {
                    return m;
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading members from file: " + e.getMessage());
        }

        return null;
    }

    /**
     * Returns a list of all active members from file.
     */
    public List<Member> getActiveMembers() {
        List<Member> active = new ArrayList<>();
        try {
            List<Member> fileMembers = FileHandler.readMembers();
            for (Member m : fileMembers) {
                if (m.isActive()) {
                    active.add(m);
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading active members: " + e.getMessage());
        }

        return active;
    }
}
