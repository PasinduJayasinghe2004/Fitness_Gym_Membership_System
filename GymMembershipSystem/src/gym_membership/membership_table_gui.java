package gym_membership;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * GUI for displaying gym memberships in a table
 */
public class MembershipTableGUI extends JFrame {
    
    private JTable myTable;
    private MembershipTableModel tableModel;
    private ArrayList<Membership> memberList;
    
    // Constructor
    public MembershipTableGUI(ArrayList<Membership> memberList) {
        
        // Set the title
        this.setTitle("Fitness Gym - Member Management");
        
        // Initialize instance variables
        this.memberList = memberList;
        tableModel = new MembershipTableModel(memberList);
        myTable = new JTable(tableModel);
        
        // Set the size of the frame
        setBounds(20, 20, 1200, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Enable sorting
        myTable.setAutoCreateRowSorter(true);
        
        // Add the table to scroll pane
        JScrollPane scrollPane = new JScrollPane(myTable);
        scrollPane.setPreferredSize(new Dimension(1150, 500));
        
        // Add a button on the bottom
        JButton statsButton = new JButton("Membership Statistics");
        
        // Add event handler to the Stats button
        statsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMembershipStatistics();
            }
        });
        
        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);
        add(statsButton, BorderLayout.SOUTH);
    }
    
    /**
     * Display membership statistics
     */
    private void showMembershipStatistics() {
        int basicCount = 0;
        int premiumCount = 0;
        int studentCount = 0;
        double totalRevenue = 0;
        int activeMembers = 0;
        int expiringCount = 0;
        
        for (Membership member : memberList) {
            if (member instanceof BasicMembership) {
                basicCount++;
            } else if (member instanceof PremiumMembership) {
                premiumCount++;
            } else if (member instanceof StudentMembership) {
                studentCount++;
            }
            
            totalRevenue += member.getTotalCost();
            
            if (member.isActive()) {
                activeMembers++;
                if (member.getDaysRemaining() <= 30) {
                    expiringCount++;
                }
            }
        }
        
        double averageRevenue = memberList.size() > 0 ? totalRevenue / memberList.size() : 0;
        
        String message = "═══════ MEMBERSHIP STATISTICS ═══════\n\n" +
                        "📊 MEMBERSHIP BREAKDOWN:\n" +
                        "   • Basic Memberships: " + basicCount + "\n" +
                        "   • Premium Memberships: " + premiumCount + "\n" +
                        "   • Student Memberships: " + studentCount + "\n" +
                        "   • Total Members: " + memberList.size() + "\n\n" +
                        "✓ ACTIVE STATUS:\n" +
                        "   • Active Members: " + activeMembers + "\n" +
                        "   • Expired Members: " + (memberList.size() - activeMembers) + "\n\n" +
                        "⚠ EXPIRY ALERTS:\n" +
                        "   • Expiring within 30 days: " + expiringCount + "\n\n" +
                        "💰 REVENUE:\n" +
                        "   • Total Revenue: $" + String.format("%.2f", totalRevenue) + "\n" +
                        "   • Average per Member: $" + String.format("%.2f", averageRevenue);
        
        JOptionPane.showMessageDialog(this, message, 
                "Membership Statistics", JOptionPane.INFORMATION_MESSAGE);
    }
}