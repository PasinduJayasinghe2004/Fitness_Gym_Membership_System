# Fitness_Gym_Membership_System
Enhanced Java Gym Membership System
# 🏋️ Fitness Gym Membership System - Complete Guide

## 📋 System Overview

A comprehensive gym membership management system with three membership types: Basic, Premium, and Student. The system handles member registration, tracks expiry dates, calculates costs, and provides statistical analysis.

---

## 🗂️ Project Structure

### **Package:** `gym_membership`

```
gym_membership/
├── Membership.java              (Abstract Base Class)
├── BasicMembership.java         (Basic tier)
├── PremiumMembership.java       (Premium tier)
├── StudentMembership.java       (Student tier with discount)
├── GymManager.java              (Interface)
├── FitnessGymManager.java       (Implementation)
├── MembershipTableModel.java    (Table model)
├── MembershipTableGUI.java      (GUI interface)
├── GymMembershipSystem.java     (Main class)
└── FitnessGymManagerTest.java   (JUnit tests)
```

---

## 🎯 Key Features

### **1. Membership Management**
- ✅ Register new members (Basic/Premium/Student)
- ✅ Display all members sorted by registration date
- ✅ Update membership duration
- ✅ Check expiring memberships (within 30 days)
- ✅ Calculate total costs automatically

### **2. Advanced Features**
- 📅 **Date Management**: Uses LocalDate for accurate date tracking
- 💰 **Dynamic Pricing**: Different rates for each membership type
- 🎓 **Student Discounts**: Configurable discount rates
- ⚠️ **Expiry Alerts**: Automatic detection of expiring memberships
- 📊 **Revenue Tracking**: Total and average revenue calculations

### **3. GUI Features**
- 📋 10-column table display
- 🔄 Sortable columns
- 📈 Comprehensive statistics popup
- 🎨 Professional layout

---

## 💡 Class Design

### **Membership (Abstract Base Class)**

**Attributes:**
- `memberID`: String
- `name`: String
- `startDate`: LocalDate
- `duration`: int (months)
- `email`: String
- `phoneNumber`: String

**Key Methods:**
- `getExpiryDate()`: Calculate expiry date
- `isActive()`: Check if membership is active
- `getDaysRemaining()`: Days until expiry
- `getTotalCost()`: Calculate total cost
- `compareTo()`: Sort by start date

**Abstract Methods:**
- `getMembershipType()`: Return membership type
- `getMonthlyFee()`: Return monthly fee

---

### **BasicMembership extends Membership**

**Additional Attributes:**
- `gymAccessOnly`: boolean
- `monthlyFee`: double (default: $29.99)
- `accessHours`: String

**Benefits:**
- Basic gym access
- Limited hours
- No classes or extras

---

### **PremiumMembership extends Membership**

**Additional Attributes:**
- `includesClasses`: boolean
- `personalTrainer`: String
- `poolAccess`: boolean
- `monthlyFee`: double (default: $79.99)

**Benefits:**
- 24/7 gym access
- Group fitness classes
- Personal trainer
- Pool and spa access

---

### **StudentMembership extends Membership**

**Additional Attributes:**
- `studentID`: String
- `universityName`: String
- `discountRate`: double (default: 0.30 = 30%)
- `baseMonthlyFee`: double

**Benefits:**
- 30% discount on basic membership
- Requires valid student ID
- University verification

**Fee Calculation:**
```java
monthlyFee = baseMonthlyFee * (1 - discountRate)
```

---

## 🎮 Console Menu Options

```
1. Register New Member
   - Choose membership type
   - Enter personal details
   - Set duration
   - Configure type-specific options

2. Display All Members
   - Sorted by registration date
   - Shows full details
   - Displays statistics

3. Update Membership Duration
   - Search by member ID
   - View current details
   - Update duration
   - Recalculate costs

4. Check Expiring Memberships
   - Shows memberships expiring within 30 days
   - Helpful for renewal reminders

5. Open GUI
   - Table view of all members
   - Sortable columns
   - Statistics button

6. Exit
```

---

## 📊 GUI Table Columns

| Column | Description |
|--------|-------------|
| Member ID | Unique identifier |
| Name | Member's full name |
| Type | Basic/Premium/Student |
| Start Date | Registration date |
| Duration | Membership length (months) |
| Expiry Date | Calculated expiry |
| Monthly Fee | Cost per month |
| Total Cost | Total payment |
| Days Left | Days until expiry |
| Status | Active/Expired |

---

## 🧪 Unit Tests Included

### **Test Coverage:**
1. ✅ Add single member
2. ✅ Add multiple members
3. ✅ Test capacity limits
4. ✅ Verify membership types
5. ✅ Test fee calculations
6. ✅ Test total cost calculations
7. ✅ Test expiry dates
8. ✅ Test active status
9. ✅ Test sorting (Comparable)
10. ✅ Test student discounts

---

## 🎓 Practice Tasks (Lab-Based Practical Style)

### **TASK 01 (25 marks) - Create FamilyMembership Class**

1. Create a new class called "FamilyMembership" (2 marks)
2. Ensure it inherits from Membership class (4 marks)
3. Add instance variables:
   - numberOfMembers (int)
   - familyDiscount (double)
   - primaryMember (String)
   - secondaryMembers (ArrayList<String>) (4 marks)
4. Implement constructor taking memberID and name (4 marks)
5. Create getters and setters for all variables (8 marks)
6. Override toString() method (3 marks)

---

### **TASK 02 (24 marks) - Add Renewal Functionality**

1. Add abstract method `renewMembership()` to GymManager interface (2 marks)
2. Override the method in FitnessGymManager (2 marks)
3. The method should ask for member ID from keyboard (3 marks)
4. If found, display:
   - Current expiry date and status (4 marks)
   - Membership type (3 marks)
5. Ask user to enter renewal duration in months (2 marks)
6. Update the start date to today and add the duration (4 marks)
7. Add this functionality to runMenu() (4 marks)

---

### **TASK 03 (17 marks) - Sort by Monthly Fee**

1. Create a new method in FitnessGymManager to display members sorted by monthly fee (4 marks)
2. Use Collections.sort() with a custom Comparator (5 marks)
3. Display the sorted list in console (4 marks)
4. Add this option to the menu (4 marks)

---

### **TASK 04 (10 marks) - Add Phone Number Column**

1. Modify MembershipTableModel to add "Phone Number" column (5 marks)
2. Ensure the phone number is displayed correctly in the table (5 marks)

---

### **TASK 05 (15 marks) - Revenue Analysis Button**

1. Add a second button called "Revenue Report" to the GUI (5 marks)
2. When clicked, display:
   - Total revenue by membership type (Basic/Premium/Student) (5 marks)
   - Average revenue per member (3 marks)
   - Display in a formatted dialog box (2 marks)

---

### **TASK 06 (9 marks) - Unit Test for Renewal**

1. Create a test method called `testMembershipRenewal()` (1 mark)
2. Create a membership with 3 months duration (2 marks)
3. "Renew" by creating another membership with same ID but new dates (3 marks)
4. Verify the expiry date is correctly updated (3 marks)

---

