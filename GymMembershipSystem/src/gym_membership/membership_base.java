package gym_membership;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Abstract base class for all gym memberships
 */
public abstract class Membership implements Comparable<Membership> {
    
    // Instance variables
    private String memberID;
    private String name;
    private LocalDate startDate;
    private int duration; // duration in months
    private String email;
    private String phoneNumber;

    // Constructor
    public Membership(String memberID, String name) {
        this.memberID = memberID;
        this.name = name;
        this.startDate = LocalDate.now();
    }

    // Getters and Setters
    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    // Calculate expiry date
    public LocalDate getExpiryDate() {
        return startDate.plusMonths(duration);
    }
    
    // Check if membership is active
    public boolean isActive() {
        return LocalDate.now().isBefore(getExpiryDate());
    }
    
    // Get days remaining
    public long getDaysRemaining() {
        long days = ChronoUnit.DAYS.between(LocalDate.now(), getExpiryDate());
        return days > 0 ? days : 0;
    }
    
    // Abstract method to get membership type
    public abstract String getMembershipType();
    
    // Abstract method to get monthly fee
    public abstract double getMonthlyFee();
    
    // Calculate total cost
    public double getTotalCost() {
        return getMonthlyFee() * duration;
    }
    
    // Implement Comparable interface for sorting by start date
    @Override
    public int compareTo(Membership other) {
        return this.startDate.compareTo(other.startDate);
    }
    
    // Description of the membership
    @Override
    public String toString() {
        return "Member ID: " + memberID + ", Name: " + name + 
               ", Start Date: " + startDate + ", Duration: " + duration + " months" +
               ", Expiry: " + getExpiryDate() + ", Active: " + isActive();
    }
}