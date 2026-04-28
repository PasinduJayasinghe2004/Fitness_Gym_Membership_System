package gym_membership;

/**
 * PremiumMembership class with additional benefits
 */
public class PremiumMembership extends Membership {
    
    // Instance variables specific to PremiumMembership
    private boolean includesClasses;
    private String personalTrainer;
    private boolean poolAccess;
    private double monthlyFee;

    // Constructor
    public PremiumMembership(String memberID, String name) {
        super(memberID, name);
        this.includesClasses = true;
        this.poolAccess = true;
        this.monthlyFee = 79.99; // Default premium fee
    }

    // Getters and Setters
    public boolean isIncludesClasses() {
        return includesClasses;
    }

    public void setIncludesClasses(boolean includesClasses) {
        this.includesClasses = includesClasses;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public void setPersonalTrainer(String personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    public boolean isPoolAccess() {
        return poolAccess;
    }

    public void setPoolAccess(boolean poolAccess) {
        this.poolAccess = poolAccess;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    @Override
    public String getMembershipType() {
        return "Premium";
    }
    
    @Override
    public double getMonthlyFee() {
        return monthlyFee;
    }
    
    // Description
    @Override
    public String toString() {
        return super.toString() + ", Type: Premium, Monthly Fee: $" + monthlyFee + 
               ", Classes: " + includesClasses + ", Personal Trainer: " + personalTrainer +
               ", Pool Access: " + poolAccess;
    }
}