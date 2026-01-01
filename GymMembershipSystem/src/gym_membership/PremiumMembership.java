package gym_membership;

public class PremiumMembership extends Membership{
    private boolean includesClass;
    private String personalTrainer;
    private double monthlyFee;

    public PremiumMembership(String memberId,String name){
        super(memberId,name);
        this.includesClass=true;
        this.monthlyFee=7000;
    }

    public boolean isIncludesClass() {
        return includesClass;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public void setIncludesClass(boolean includesClass) {
        this.includesClass = includesClass;
    }

    public void setPersonalTrainer(String personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    @Override
    public double getMonthlyFee() {
        return monthlyFee;
    }
    @Override
    public String getMembershipType(){
        return "Premium";
    }
    @Override
    public String toString(){
        return super.toString()+",Type: premium,Monthly fee:$ "+monthlyFee+",Classes: "+includesClass+",Personal Trainer: "+personalTrainer;
    }
}
