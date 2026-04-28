package gym_membership;

/**
 * BasicMembership class for basic gym access
 */
public class BasicMembership extends Membership {
    
    // Instance variables specific to BasicMembership
    private boolean gymAccessOnly;
    private double monthlyFee;
    private String accessHours;

    // Constructor
    public BasicMembership(String memberID, String name) {
        super(memberID, name);
        this.gymAccessOnly = true;
        this.monthlyFee = 29.99; // Default basic fee
    }

    // Getters and Setters
    public boolean isGymAccessOnly() {
        return gymAccessOnly;
    }

    public void setGymAccessOnly(boolean gymAccessOnly) {
        this.gymAccessOnly = gymAccessOnly;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public String getAccessHours() {
        return accessHours;
    }

    public void setAccessHours(String accessHours) {
        this.accessHours = accessHours;
    }

    @Override
    public String getMembershipType() {
        return "Basic";
    }
    
    @Override
    public double getMonthlyFee() {
        return monthlyFee;
    }
    
    // Description
    @Override
    public String toString() {
        return super.toString() + ", Type: Basic, Monthly Fee: $" + monthlyFee + 
               ", Access Hours: " + accessHours;
    }
}