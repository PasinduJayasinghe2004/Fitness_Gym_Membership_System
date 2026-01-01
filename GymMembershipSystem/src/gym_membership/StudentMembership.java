package gym_membership;

import java.lang.classfile.constantpool.StringEntry;
import java.time.LocalDate;

public class StudentMembership  extends Membership{
    private String studentId;
    private String universityName;
    private double discountRate;
    private double baseMonthlyFee;

    public StudentMembership(String memberID, String name){
        super(memberID,name);
        this.discountRate=0.30;
        this.baseMonthlyFee=4000;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public void setBaseMonthlyFee(double baseMonthlyFee) {
        this.baseMonthlyFee = baseMonthlyFee;
    }
    @Override
    public String getMembershipType(){
        return "Student";
    }
    @Override
    public double getMonthlyFee(){
        return baseMonthlyFee*(1-discountRate);
    }
    @Override
    public String toString(){
        return super.toString() + "Student Id: " + studentId + "\n" + "University Name: " + universityName + "\n" + "Student Monthly fee: " + String.format("%.2f",getMonthlyFee())+"\n"+
                "Discount :"+(discountRate*100)+"%"+"\n";
    }
}
