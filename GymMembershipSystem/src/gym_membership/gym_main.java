package gym_membership;

/**
 * Main class to run the Fitness Gym Membership System
 * 
 * STUDENT DETAILS:
 * FIRST NAME: [Your First Name]
 * LAST NAME: [Your Last Name]
 * STUDENT ID: [Your Student ID]
 */
public class GymMembershipSystem {

    public static void main(String[] args) {
        
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   WELCOME TO FITNESS GYM MANAGEMENT        ║");
        System.out.println("║        Your Health, Our Priority           ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        // Create gym manager with capacity of 100 members
        FitnessGymManager gymManager = new FitnessGymManager(100);
        
        boolean exit = false;
        
        // Run the menu until the user selects exit
        while (!exit) {
            exit = gymManager.runMenu();
        }
        
        System.out.println("\n💪 Thank you for using Fitness Gym Management System!");
        System.out.println("Stay Healthy, Stay Strong! 🏋️");
    }
}