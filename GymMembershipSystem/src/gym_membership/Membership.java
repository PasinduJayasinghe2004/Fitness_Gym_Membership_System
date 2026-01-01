package gym_membership;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Membership implements Comparable<Membership> {
    private String memberID;
    private String name;
    private LocalDate startDate;
    private int duration;
    private String email;
    private String phoneNumber;

    public Membership(String memberID, String name) {
        this.memberID = memberID;
        this.name = name;
        this.startDate = LocalDate.now();

    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getDuration() {
        return duration;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getExpiryDate() {
        return startDate.plusMonths(duration);// Calculate expire date

    }

    public boolean isActive() {
        return LocalDate.now().isBefore(getExpiryDate());
    }

    public long getDayRemaining() {
        long days = ChronoUnit.DAYS.between(LocalDate.now(), getExpiryDate());
        return days > 0 ? days : 0;
    }

    public abstract String getMembershipType();

    public abstract double getMonthlyFee();

    //calculate total cost
    public double getTotalCost() {
        return getMonthlyFee() * duration;
    }

    @Override
    public int compareTo(Membership other){
        return this.startDate.compareTo(other.startDate);
    }

    @Override
    public String toString() {
        return "Member ID: " + memberID + "\n" + ",Name: " + name + "\n" + ",Start Date: " + startDate + "\n" + ",Duration : " + duration + "Months: " + "\n" + ",Expiry: " + getExpiryDate() + ", Active: " + isActive();
    }
}
