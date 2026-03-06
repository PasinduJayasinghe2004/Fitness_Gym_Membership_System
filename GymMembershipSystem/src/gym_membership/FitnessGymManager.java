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

        if(membershipList.size()>=maxCapacity){
            System.out.println("Gym is at full member capacity.");
            return;
        }
        System.out.println("+++++++++++REGISTER NEW MEMBER+++++++++++");
        System.out.println("1.Basic Membership($29.99/month)");
        System.out.println("2.Premium Membership($79.99/month");
        System.out.println("3.Student Membership(30% discount");
        System.out.println("Enter Membership Type: ");

        int type=scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enrer member Id: ");
        String memberId=scanner.nextLine();

        System.out.println("Enter Member Name: ");
        String name=scanner.nextLine();

        System.out.println("Enter email: ");
        String mail=scanner.nextLine();

        System.out.println("Enter phone number: ");
        String phone=scanner.nextLine();

        System.out.println("Enter duration (Months) : ");
        int duration=scanner.nextInt();
        scanner.nextLine();

        Membership membership=null;

        switch (type) {
            case 1:
                BasicMembership  basic=new BasicMembership(memberId, name);
                basic.setEmail(mail);
                basic.setPhoneNumber(phone);
                basic.setDuration(duration);
                System.out.println("Enter Access hours(6AM -10PM) : ");
                basic.setAccessHours(scanner.nextLine());
                membership=basic;
                break;

            case 2:
                PremiumMembership premium=new PremiumMembership(memberId, name);
                premium.setEmail(mail);
                premium.setPhoneNumber(phone);
                premium.setDuration(duration);
                System.out.println("Assign personal trainer: ");
                premium.setPersonalTrainer(scanner.nextLine());
                System.out.println("Include group class(true/false): ");
                premium.setIncludesClass(scanner.nextBoolean());
                scanner.nextLine();
                membership=premium;
                break;

            case 3:
                StudentMembership student=new StudentMembership(memberId, name);
                student.setEmail(mail);
                student.setPhoneNumber(phone);
                student.setDuration(duration);
                System.out.println("Enter student id: ");
                student.setStudentId(scanner.nextLine());
                System.out.println("Enter university name: ");
                student.setUniversityName(scanner.nextLine());
                





                
        
            default:
                break;
        }



    }

}
