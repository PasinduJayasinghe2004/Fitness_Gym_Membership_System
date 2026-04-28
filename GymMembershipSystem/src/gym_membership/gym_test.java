package gym_membership;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test class for FitnessGymManager
 */
public class FitnessGymManagerTest {
    
    private FitnessGymManager gymManager;
    
    public FitnessGymManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // Initialize gym manager before each test
        gymManager = new FitnessGymManager(50);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addMemberToList method, of class FitnessGymManager
     */
    @Test
    public void testAddMemberToList() {
        System.out.println("Testing addMemberToList");
        
        // Create a basic membership
        BasicMembership basic = new BasicMembership("M001", "John Doe");
        basic.setDuration(6);
        basic.setEmail("john@example.com");
        basic.setAccessHours("6AM-10PM");
        
        // Add member to list
        gymManager.addMemberToList(basic);
        
        // Verify the member was added
        assertEquals(1, gymManager.getMemberList().size());
        assertEquals("M001", gymManager.getMemberList().get(0).getMemberID());
        assertEquals("John Doe", gymManager.getMemberList().get(0).getName());
    }
    
    /**
     * Test adding multiple members
     */
    @Test
    public void testAddMultipleMembers() {
        System.out.println("Testing adding multiple members");
        
        // Create memberships
        BasicMembership basic = new BasicMembership("M001", "John Doe");
        basic.setDuration(6);
        
        PremiumMembership premium = new PremiumMembership("M002", "Jane Smith");
        premium.setDuration(12);
        premium.setPersonalTrainer("Mike Johnson");
        
        StudentMembership student = new StudentMembership("M003", "Alice Brown");
        student.setDuration(3);
        student.setStudentID("S12345");
        
        // Add members
        gymManager.addMemberToList(basic);
        gymManager.addMemberToList(premium);
        gymManager.addMemberToList(student);
        
        // Verify
        assertEquals(3, gymManager.getMemberList().size());
    }
    
    /**
     * Test capacity limit
     */
    @Test
    public void testCapacityLimit() {
        System.out.println("Testing capacity limit");
        
        // Try to add 51 members when capacity is 50
        for (int i = 0; i < 51; i++) {
            BasicMembership member = new BasicMembership("M" + i, "Member " + i);
            member.setDuration(6);
            gymManager.addMemberToList(member);
        }
        
        // Should only have 50 members
        assertEquals(50, gymManager.getMemberList().size());
    }
    
    /**
     * Test membership types
     */
    @Test
    public void testMembershipTypes() {
        System.out.println("Testing membership types");
        
        BasicMembership basic = new BasicMembership("M001", "John");
        PremiumMembership premium = new PremiumMembership("M002", "Jane");
        StudentMembership student = new StudentMembership("M003", "Alice");
        
        assertEquals("Basic", basic.getMembershipType());
        assertEquals("Premium", premium.getMembershipType());
        assertEquals("Student", student.getMembershipType());
    }
    
    /**
     * Test monthly fee calculation
     */
    @Test
    public void testMonthlyFeeCalculation() {
        System.out.println("Testing monthly fee calculation");
        
        BasicMembership basic = new BasicMembership("M001", "John");
        assertEquals(29.99, basic.getMonthlyFee(), 0.01);
        
        PremiumMembership premium = new PremiumMembership("M002", "Jane");
        assertEquals(79.99, premium.getMonthlyFee(), 0.01);
        
        StudentMembership student = new StudentMembership("M003", "Alice");
        // Default is 30% discount on $29.99
        assertEquals(20.99, student.getMonthlyFee(), 0.01);
    }
    
    /**
     * Test total cost calculation
     */
    @Test
    public void testTotalCostCalculation() {
        System.out.println("Testing total cost calculation");
        
        BasicMembership basic = new BasicMembership("M001", "John");
        basic.setDuration(6);
        
        double expectedCost = 29.99 * 6;
        assertEquals(expectedCost, basic.getTotalCost(), 0.01);
    }
    
    /**
     * Test membership expiry
     */
    @Test
    public void testMembershipExpiry() {
        System.out.println("Testing membership expiry");
        
        BasicMembership basic = new BasicMembership("M001", "John");
        basic.setDuration(6);
        
        LocalDate expectedExpiry = LocalDate.now().plusMonths(6);
        assertEquals(expectedExpiry, basic.getExpiryDate());
    }
    
    /**
     * Test active status
     */
    @Test
    public void testActiveStatus() {
        System.out.println("Testing active status");
        
        BasicMembership basic = new BasicMembership("M001", "John");
        basic.setDuration(6);
        
        // Should be active for 6 months
        assertTrue(basic.isActive());
        assertTrue(basic.getDaysRemaining() > 0);
    }
    
    /**
     * Test Comparable implementation (sorting)
     */
    @Test
    public void testComparable() {
        System.out.println("Testing Comparable implementation");
        
        BasicMembership member1 = new BasicMembership("M001", "John");
        member1.setStartDate(LocalDate.of(2024, 1, 1));
        
        BasicMembership member2 = new BasicMembership("M002", "Jane");
        member2.setStartDate(LocalDate.of(2024, 6, 1));
        
        // member1 should be less than member2 (earlier start date)
        assertTrue(member1.compareTo(member2) < 0);
    }
    
    /**
     * Test student discount
     */
    @Test
    public void testStudentDiscount() {
        System.out.println("Testing student discount");
        
        StudentMembership student = new StudentMembership("M001", "Alice");
        student.setBaseMonthlyFee(50.0);
        student.setDiscountRate(0.20); // 20% discount
        
        assertEquals(40.0, student.getMonthlyFee(), 0.01);
    }
}