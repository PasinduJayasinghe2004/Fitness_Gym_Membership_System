package gym_membership;

/**
 * StudentMembership class with discounted rates
 */
public class StudentMembership extends Membership {
    
    // Instance variables specific to StudentMembership
    private String studentID;
    private String universityName;
    private double discountRate;
    private double baseMonthlyFee;

    // Constructor
    public StudentMembership(String memberID, String name) {
        super(memberID, name);
        this.discountRate = 0.30; // 30% discount
        this.baseMonthlyFee = 29.99;
    }

    // Getters and Setters
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }

    public void setBaseMonthlyFee(double baseMonthlyFee) {
        this.baseMonthlyFee = baseMonthlyFee;
    }

    @Override
    public String getMembershipType() {
        return "Student";
    }
    
    @Override
    public double getMonthlyFee() {
        return baseMonthlyFee * (1 - discountRate);
    }
    
    // Description
    @Override
    public String toString() {
        return super.toString() + ", Type: Student, Monthly Fee: $" + 
               String.format("%.2f", getMonthlyFee()) + 
               " (Discount: " + (discountRate * 100) + "%)" +
               ", Student ID: " + studentID + ", University: " + universityName;
    }
}