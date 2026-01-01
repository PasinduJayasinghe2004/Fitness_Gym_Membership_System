package gym_membership;

public class BasicMembership extends Membership{
    private boolean gymAccessOnly;
    private double monthlyFee;
    private String accessHours;

    public BasicMembership(String memberId,String name){
        super(memberId,name);
        this.gymAccessOnly=true;
        this.monthlyFee=2000;
    }

    public boolean isGymAccessOnly() {
        return gymAccessOnly;
    }


    public String getAccessHours() {
        return accessHours;
    }

    public void setGymAccessOnly(boolean gymAccessOnly) {
        this.gymAccessOnly = gymAccessOnly;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public void setAccessHours(String accessHours) {
        this.accessHours = accessHours;
    }
    @Override
    public String getMembershipType(){
        return "Basic Membership";
    }
    @Override
    public double getMonthlyFee(){
        return monthlyFee;
    }
    @Override
    public String toString(){
        return super.toString()+",Type :Basic,MOnthly Fee: $"+monthlyFee+",Access Hours: "+accessHours;
    }
}
