package gym_membership;

/**
 * Interface for gym membership management operations
 */
public interface GymManager {
    
    boolean runMenu(); // Run Menu - main function
    
    void registerMember(); // Register new member
    
    void displayMembers(); // Display all members in the system
    
    void updateMembershipDuration(); // Update membership duration
    
    void runGUI(); // Run main GUI
}