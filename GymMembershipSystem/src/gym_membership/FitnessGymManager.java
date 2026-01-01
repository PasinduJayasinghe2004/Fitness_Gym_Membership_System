package gym_membership;


import java.util.ArrayList;
import java.util.Scanner;

public class FitnessGymManager implements GymManager{
    private ArrayList<Membership> membershipList;
    private int maxCapacity;
    private Scanner scanner;

    public FitnessGymManager(int maxCapacity){
        this.maxCapacity=maxCapacity;
        this.membershipList=new ArrayList<>();
        this.scanner=new Scanner(System.in);
    }
    @Override
    public boolean runMenu(){
        System.out.println("\n========== Fitness Gym Membership System ==========");
        System.out.println("1. Register New Member");
        System.out.println("2. Display All Members");
        System.out.println("3. Update Membership Duration");
        System.out.println("4. Check Expiring Memberships");
        System.out.println("5. Open GUI");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                registerMember();
                return false;
            case 2:
                displayMember();
                return false;
            case 3:
                updateMembershipDuration();
                return false;
            case 4:
                checkExpiringMemberships();
                return false;
            case 5:
                runGUI();
                return false;
            case 6:
                System.out.println("Exiting system. Stay fit!");
                return true;
            default:
                System.out.println("Invalid choice. Please try again.");
                return false;
        }
    }

    @Override
    public void registerMember(){
        if(membershipList.size()>maxCapacity){
            System.out.println("GYM Full Member Capacity.");
            return;
        }
        System.out.println("__________Register New Member_________");
        System.out.println("1.Basic Membership");
        System.out.println("2.Premium Membership");
        System.out.println("3.Student Membership");
        System.out.println("Enter Membership type: ");

        int type=scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter member Id: ");
        String memberId=scanner.nextLine();

        System.out.println("Enter name: ");
        String name=scanner.nextLine();

        System.out.println("Enter email: ");
        String email=scanner.nextLine();

        System.out.println("Enter phone Number: ");
        String phoneNumber=scanner.nextLine();

        System.out.println("Enter duration (months): ");
        int duration=scanner.nextInt();
        scanner.nextLine();

        Membership membership=null;

        switch(type){
            case 1:
                BasicMembership basic=new BasicMembership(memberId,name);
                basic.setEmail(email);
                basic.setPhoneNumber(phoneNumber);
                basic.setDuration(duration);

                System.out.println("Enter access hours (e.g. 6AM-10PM): ");
                basic.setAccessHours(scanner.nextLine());

                membership=basic;
                break;

            case 2:
                PremiumMembership premium=new PremiumMembership(memberId,name);
                premium.setEmail(email);
                premium.setPhoneNumber(phoneNumber);
                premium.setDuration(duration);

                System.out.println("Assign Personal trainer: ");
                premium.setPersonalTrainer(scanner.nextLine());

                System.out.println("Include group classes?(true/false): ");
                premium.setIncludesClass(scanner.nextBoolean());
                scanner.nextLine();

                membership=premium;
                break;

            case 3:
                StudentMembership student=new StudentMembership(memberId,name);
                student.setEmail(email);
                student.setPhoneNumber(phoneNumber);
                student.setDuration(duration);

                System.out.println("Enter student Id: ");
                student.setStudentId(scanner.nextLine());

                System.out.println("Enter university name: ");
                student.setUniversityName(scanner.nextLine());

                System.out.println("Enter discount rate(0.0 to 1.0): ");
                student.setDiscountRate(scanner.nextDouble());
                scanner.nextLine();

                membership=student;
                break;

            default:
                System.out.println("Invalid membership. ");
                return;

        }

        membershipList.add(membership);
        System.out.println("\n member registered successfully.");
        System.out.println("\n Total cost: $" + String.format("%.2f",membership.getTotalCost()));
        System.out.println("Expiry Date: "+membership.getExpiryDate());





    }


    public void checkExpiringMemberships() {
    }


}
