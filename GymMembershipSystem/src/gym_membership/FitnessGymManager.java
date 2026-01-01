package gym_membership;


import java.util.ArrayList;
import java.util.Scanner;

public class FitnessGymManager implements GymManager{
    private ArrayList<Membership> membershipList;
    private int maxCapacity;
    private Scanner scanner;

    public FitnessGymManager(int maxCapacity){
        this.maxCapacity=maxCapacity;
        this.membershipList=new ArrayList<>();
        this.scanner=new Scanner(System.in);
    }
    @Override
    public boolean runMenu(){
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
                displayMember();
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
    public void registerMember(){
        if()
    }

    public void checkExpiringMemberships() {
    }


}
