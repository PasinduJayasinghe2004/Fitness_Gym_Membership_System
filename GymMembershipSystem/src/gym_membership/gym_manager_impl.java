package gym_membership;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Implementation of GymManager for Fitness Gym
 */
public class FitnessGymManager implements GymManager {
    
    private ArrayList<Membership> memberList;
    private int maxCapacity;
    private Scanner scanner;
    
    // Constructor
    public FitnessGymManager(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.memberList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    @Override
    public boolean runMenu() {
        System.out.println("\n========== Fitness Gym Membership System ==========");
        System.out.println("1. Register New Member");
        System.out.println("2. Display All Members");
        System.out.println("3. Update Membership Duration");
        System.out.println("4. Check Expiring Memberships");
        System.out.println("5. Open GUI");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch (choice) {
            case 1:
                registerMember();
                return false;
            case 2:
                displayMembers();
                return false;
            case 3:
                updateMembershipDuration();
                return false;
            case 4:
                checkExpiringMemberships();
                return false;
            case 5:
                runGUI();
                return false;
            case 6:
                System.out.println("Exiting system. Stay fit!");
                return true;
            default:
                System.out.println("Invalid choice. Please try again.");
                return false;
        }
    }
    
    @Override
    public void registerMember() {
        if (memberList.size() >= maxCapacity) {
            System.out.println("Gym is at full member capacity!");
            return;
        }
        
        System.out.println("\n--- Register New Member ---");
        System.out.println("1. Basic Membership");
        System.out.println("2. Premium Membership");
        System.out.println("3. Student Membership");
        System.out.print("Enter membership type: ");
        
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter member ID: ");
        String memberID = scanner.nextLine();
        
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        
        System.out.print("Enter duration (months): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Membership membership = null;
        
        switch (type) {
            case 1:
                BasicMembership basic = new BasicMembership(memberID, name);
                basic.setEmail(email);
                basic.setPhoneNumber(phoneNumber);
                basic.setDuration(duration);
                
                System.out.print("Enter access hours (e.g., 6AM-10PM): ");
                basic.setAccessHours(scanner.nextLine());
                
                membership = basic;
                break;
                
            case 2:
                PremiumMembership premium = new PremiumMembership(memberID, name);
                premium.setEmail(email);
                premium.setPhoneNumber(phoneNumber);
                premium.setDuration(duration);
                
                System.out.print("Assign personal trainer (name): ");
                premium.setPersonalTrainer(scanner.nextLine());
                
                System.out.print("Include group classes? (true/false): ");
                premium.setIncludesClasses(scanner.nextBoolean());
                scanner.nextLine();
                
                System.out.print("Pool access? (true/false): ");
                premium.setPoolAccess(scanner.nextBoolean());
                scanner.nextLine();
                
                membership = premium;
                break;
                
            case 3:
                StudentMembership student = new StudentMembership(memberID, name);
                student.setEmail(email);
                student.setPhoneNumber(phoneNumber);
                student.setDuration(duration);
                
                System.out.print("Enter student ID: ");
                student.setStudentID(scanner.nextLine());
                
                System.out.print("Enter university name: ");
                student.setUniversityName(scanner.nextLine());
                
                System.out.print("Enter discount rate (0.0 to 1.0): ");
                student.setDiscountRate(scanner.nextDouble());
                scanner.nextLine();
                
                membership = student;
                break;
                
            default:
                System.out.println("Invalid membership type!");
                return;
        }
        
        memberList.add(membership);
        System.out.println("\n✓ Member registered successfully!");
        System.out.println("Total Cost: $" + String.format("%.2f", membership.getTotalCost()));
        System.out.println("Expiry Date: " + membership.getExpiryDate());
    }
    
    @Override
    public void displayMembers() {
        if (memberList.isEmpty()) {
            System.out.println("\nNo members registered.");
            return;
        }
        
        System.out.println("\n========== All Members (Sorted by Registration Date) ==========");
        
        // Sort members by start date
        Collections.sort(memberList);
        
        for (Membership member : memberList) {
            System.out.println(member);
            System.out.println("Days Remaining: " + member.getDaysRemaining());
            System.out.println("---");
        }
        
        // Display summary statistics
        System.out.println("\n--- Gym Statistics ---");
        System.out.println("Total Members: " + memberList.size());
        
        int activeMembers = 0;
        double totalRevenue = 0;
        for (Membership m : memberList) {
            if (m.isActive()) {
                activeMembers++;
            }
            totalRevenue += m.getTotalCost();
        }
        System.out.println("Active Members: " + activeMembers);
        System.out.printf("Total Revenue: $%.2f\n", totalRevenue);
    }
    
    @Override
    public void updateMembershipDuration() {
        System.out.println("\n--- Update Membership Duration ---");
        System.out.print("Enter member ID: ");
        String memberID = scanner.nextLine();
        
        Membership foundMember = null;
        for (Membership member : memberList) {
            if (member.getMemberID().equals(memberID)) {
                foundMember = member;
                break;
            }
        }
        
        if (foundMember == null) {
            System.out.println("Member not found with ID: " + memberID);
            return;
        }
        
        // Display current information
        System.out.println("\nMember found:");
        System.out.println("Name: " + foundMember.getName());
        System.out.println("Current Duration: " + foundMember.getDuration() + " months");
        System.out.println("Current Expiry: " + foundMember.getExpiryDate());
        System.out.println("Type: " + foundMember.getMembershipType());
        System.out.println("Days Remaining: " + foundMember.getDaysRemaining());
        
        // Get new duration
        System.out.print("\nEnter new duration (months): ");
        int newDuration = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Update duration
        foundMember.setDuration(newDuration);
        System.out.println("✓ Duration updated successfully!");
        System.out.println("New Expiry Date: " + foundMember.getExpiryDate());
        System.out.println("New Total Cost: $" + String.format("%.2f", foundMember.getTotalCost()));
    }
    
    /**
     * Check for memberships expiring within 30 days
     */
    private void checkExpiringMemberships() {
        System.out.println("\n--- Memberships Expiring in Next 30 Days ---");
        
        boolean found = false;
        for (Membership member : memberList) {
            if (member.isActive() && member.getDaysRemaining() <= 30) {
                System.out.println("⚠ " + member.getName() + " (ID: " + member.getMemberID() + 
                                 ") - Expires in " + member.getDaysRemaining() + " days");
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No memberships expiring soon.");
        }
    }
    
    @Override
    public void runGUI() {
        MembershipTableGUI gui = new MembershipTableGUI(memberList);
        gui.setVisible(true);
    }
    
    // Method for adding members to list (for testing)
    public void addMemberToList(Membership membership) {
        if (memberList.size() < maxCapacity) {
            memberList.add(membership);
        }
    }
    
    // Getter for memberList (for testing)
    public ArrayList<Membership> getMemberList() {
        return memberList;
    }
}