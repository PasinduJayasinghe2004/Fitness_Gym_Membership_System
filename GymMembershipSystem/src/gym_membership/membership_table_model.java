package gym_membership;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Table model for displaying memberships in JTable
 */
public class MembershipTableModel extends AbstractTableModel {
    
    private String[] columnNames = {"Member ID", "Name", "Type", "Start Date", 
                                   "Duration", "Expiry Date", "Monthly Fee", 
                                   "Total Cost", "Days Left", "Status"};
    private ArrayList<Membership> memberList;
    
    public MembershipTableModel(ArrayList<Membership> memberList) {
        this.memberList = memberList;
    }

    @Override
    public int getRowCount() {
        return memberList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        Membership member = memberList.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                temp = member.getMemberID();
                break;
            case 1:
                temp = member.getName();
                break;
            case 2:
                temp = member.getMembershipType();
                break;
            case 3:
                temp = member.getStartDate();
                break;
            case 4:
                temp = member.getDuration() + " months";
                break;
            case 5:
                temp = member.getExpiryDate();
                break;
            case 6:
                temp = "$" + String.format("%.2f", member.getMonthlyFee());
                break;
            case 7:
                temp = "$" + String.format("%.2f", member.getTotalCost());
                break;
            case 8:
                temp = member.getDaysRemaining() + " days";
                break;
            case 9:
                temp = member.isActive() ? "Active" : "Expired";
                break;
        }
        
        return temp;
    }
    
    // Needed to show column names in JTable
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}