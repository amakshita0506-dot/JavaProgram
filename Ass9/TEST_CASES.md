# Restaurant Management System - Example Usage & Test Cases

## Test Data Setup

Before running any tests, ensure you have this sample data:

```sql
-- Sample Restaurants
INSERT INTO Restaurant (Name, Address) VALUES
('Cafe Java', 'Pune'),
('Food Hub', 'Mumbai'),
('Spice Villa', 'Delhi'),
('Tasty Bites', 'Bangalore'),
('Green Leaf', 'Chennai');

-- Sample Menu Items
INSERT INTO MenuItem (Name, Price, ResId) VALUES
('Pasta', 80, 1),
('Pizza', 120, 1),
('Burger', 90, 2),
('Pav Bhaji', 70, 3),
('Paneer Tikka', 150, 4),
('Paratha', 60, 5),
('Pulao', 95, 6),
('Noodles', 110, 1),
('Pizza Small', 85, 1),
('Pancake', 50, 2);
```

## Assignment Requirement Test Cases

### Test Case 1: Select Menu Items where price ≤ 100

**Method**: Console or GUI → Manage Menu Items → Filter by Price

**Steps**:
1. Start application
2. Navigate to "Manage Menu Items"
3. Click "Filter by Price" (GUI) or select "Filter by Price" (Console)
4. Enter: `100`
5. Expected Result:
   ```
   Pasta (₹80)
   Burger (₹90)
   Pav Bhaji (₹70)
   Paratha (₹60)
   Pulao (₹95)
   Pizza Small (₹85)
   Pancake (₹50)
   ```

**Code Behind**:
```java
List<MenuItem> filteredItems = menuItemDAO.getMenuItemsByPrice(100);
// Returns 7 items with price <= 100
```

---

### Test Case 2: Select Menu Items from specific Restaurant ("Cafe Java")

**Method**: Console → Manage Menu Items → View Items by Restaurant

**Steps**:
1. Start Console Application
2. Navigate to "Menu Item Management"
3. Select "View Items by Restaurant"
4. Select Restaurant ID: `1` (Cafe Java)
5. Expected Result:
   ```
   Pasta (₹80) - Restaurant 1
   Pizza (₹120) - Restaurant 1
   Noodles (₹110) - Restaurant 1
   Pizza Small (₹85) - Restaurant 1
   ```

**Code Behind**:
```java
List<MenuItem> cafeItems = menuItemDAO.getMenuItemsByRestaurantId(1);
// Returns all items from Cafe Java
```

---

### Test Case 3: Update Menu Items - Increase price ≤ 100 to 200

**Method**: Manual update through GUI or bulk update

**Steps - GUI**:
1. Go to "Manage Menu Items"
2. Filter by Price ≤ 100
3. For each item:
   - Select item from table
   - Change price to `200`
   - Click "Update"
   - Confirm update

**Steps - Console**:
1. Select "Update Menu Item"
2. Select ID: `1` (Pasta)
3. Change price from `80` to `200`
4. Repeat for all items with price ≤ 100

**Code Implementation**:
```java
// Get all items with price <= 100
List<MenuItem> items = menuItemDAO.getMenuItemsByPrice(100);

// Update each item
for (MenuItem item : items) {
    item.setPrice(200);
    menuItemDAO.updateMenuItem(item);
}
```

**Before**:
```
Pasta: ₹80
Burger: ₹90
Pav Bhaji: ₹70
```

**After**:
```
Pasta: ₹200
Burger: ₹200
Pav Bhaji: ₹200
```

---

### Test Case 4: Delete Menu Items starting with 'P'

**Method 1 - Manual (GUI)**:
1. Go to "Manage Menu Items"
2. Search for items starting with "P"
3. For each result:
   - Select item
   - Click "Delete"
   - Confirm deletion
4. Items to delete:
   - Pasta (ID: 1)
   - Pav Bhaji (ID: 4)
   - Paneer Tikka (ID: 5)
   - Paratha (ID: 6)
   - Pulao (ID: 7)
   - Pizza (ID: 2)
   - Pizza Small (ID: 9)
   - Pancake (ID: 10)

**Method 2 - Batch Delete (Code)**:
```java
List<MenuItem> allItems = menuItemDAO.getAllMenuItems();
int deletedCount = 0;

for (MenuItem item : allItems) {
    if (item.getName().startsWith("P")) {
        if (menuItemDAO.deleteMenuItem(item.getId())) {
            deletedCount++;
            System.out.println("Deleted: " + item.getName());
        }
    }
}

System.out.println("Total deleted: " + deletedCount);
```

**Expected Output**:
```
Deleted: Pasta
Deleted: Pizza
Deleted: Pav Bhaji
Deleted: Paneer Tikka
Deleted: Paratha
Deleted: Pulao
Deleted: Pizza Small
Deleted: Pancake
Total deleted: 8
```

---

## Additional Test Scenarios

### Test Case 5: Restaurant CRUD Operations

#### CREATE - Add New Restaurant
```
Input:
  Name: "Spicy Corner"
  Location: "Hyderabad"

Expected:
  ✓ Restaurant added successfully!
  New ID: 6
  
Verification: View all restaurants to confirm
```

#### READ - View All Restaurants
```
Expected Output:
ID | Name              | Location
1  | Cafe Java        | Pune
2  | Food Hub         | Mumbai
3  | Spice Villa      | Delhi
4  | Tasty Bites      | Bangalore
5  | Green Leaf       | Chennai
```

#### UPDATE - Modify Restaurant
```
Select: ID 3 (Spice Villa)
Change: Address from "Delhi" to "New Delhi"

Expected: ✓ Restaurant updated successfully!
Verification: Confirm location is updated
```

#### DELETE - Remove Restaurant
```
Select: ID 6 (Spicy Corner)
Confirm: "Are you sure? (yes/no)"
Enter: yes

Expected: ✓ Restaurant deleted successfully!
Verification: Confirm restaurant is removed from list
```

---

### Test Case 6: Search Operations

#### Search Restaurant
```
Search Term: "cafe"

Expected:
  Results: 1 match found
  Cafe Java | Pune
```

#### Search Menu Item
```
Search Term: "pizza"

Expected:
  Results: 3 matches found
  Pizza | ₹120 | Restaurant 1
  Pizza Small | ₹85 | Restaurant 1
```

---

### Test Case 7: Data Validation

#### Invalid Input - Empty Fields
```
Action: Try to add restaurant without name
Expected: Alert: "Validation Error - Please fill in all fields"
Result: No data added
```

#### Invalid Input - Non-numeric Price
```
Action: Try to add menu item with price = "abc"
Expected: Alert: "Input Error - Price must be a number"
Result: No data added
```

#### Invalid Input - Non-numeric Restaurant ID
```
Action: Try to add menu item with Restaurant ID = "xyz"
Expected: Alert: "Input Error - Restaurant ID must be an integer"
Result: No data added
```

---

### Test Case 8: Delete Confirmation

```
Action: Select item and click Delete
Step 1: Dialog appears: "Are you sure you want to delete: Pasta?"
Step 2: Click "OK"
Result: ✓ Item deleted successfully!

OR

Step 2: Click "Cancel"
Result: Deletion cancelled
```

---

## Performance Test Scenarios

### Large Dataset Test
```
Setup: Insert 100+ restaurants and 500+ menu items

Operations to Test:
1. Load all restaurants - Should complete in < 1 second
2. Load all menu items - Should complete in < 2 seconds
3. Filter by price - Should complete in < 500ms
4. Search by name - Should complete in < 500ms

Expected: All operations should be responsive
```

---

## Concurrent Operation Test

```
Scenario 1: Multiple windows open
- Open Restaurant Management window
- Open Menu Item Management window
- Modify data in one window
- Verify other window reflects changes after refresh

Scenario 2: Add and Delete
1. Add new restaurant
2. Add menu item to that restaurant
3. Immediately delete restaurant
4. Verify menu items handle foreign key constraint
```

---

## SQL Verification Commands

After running operations, verify using MySQL:

```sql
-- Check restaurants
SELECT * FROM Restaurant;
SELECT COUNT(*) as total_restaurants FROM Restaurant;

-- Check menu items
SELECT * FROM MenuItem;
SELECT COUNT(*) as total_items FROM MenuItem;

-- Items by price
SELECT * FROM MenuItem WHERE Price <= 100;

-- Items by restaurant
SELECT * FROM MenuItem WHERE ResId = 1;

-- Items starting with P
SELECT * FROM MenuItem WHERE Name LIKE 'P%';

-- Join query to see all data
SELECT 
    m.Id, 
    m.Name, 
    m.Price, 
    r.Name as Restaurant,
    r.Address
FROM MenuItem m
JOIN Restaurant r ON m.ResId = r.Id
ORDER BY r.Name, m.Name;
```

---

## Expected Results Summary

| Operation | Records | Status |
|-----------|---------|--------|
| Initial Load | 5 restaurants, 10 items | ✓ |
| Filter price ≤ 100 | 7 items | ✓ |
| View Cafe Java items | 4 items | ✓ |
| Update price ≤ 100 to 200 | 7 updated | ✓ |
| Delete starting with 'P' | 8 deleted | ✓ |
| Final Count | 5 restaurants, 2 items | ✓ |

---

## Checklist for Complete Testing

- [ ] Database created successfully
- [ ] Sample data inserted
- [ ] Database connection working
- [ ] GUI launches without errors
- [ ] Console app runs without errors
- [ ] Can view all restaurants
- [ ] Can view all menu items
- [ ] Can add new restaurant
- [ ] Can add new menu item
- [ ] Can update restaurant
- [ ] Can update menu item
- [ ] Can delete restaurant
- [ ] Can delete menu item
- [ ] Search functionality works
- [ ] Filter by price works
- [ ] Price ≤ 100 query works
- [ ] Items by restaurant query works
- [ ] Update multiple items works
- [ ] Delete by pattern works
- [ ] Input validation works
- [ ] Error handling works
- [ ] Refresh displays updated data
- [ ] Application handles edge cases
- [ ] All CRUD operations complete

---

## Notes for Testers

1. **Always test with sample data**: Use the provided INSERT statements
2. **Refresh after changes**: Click Refresh to see latest data
3. **Test edge cases**: Empty lists, single items, large datasets
4. **Check database**: Verify changes in MySQL to confirm persistence
5. **Test validation**: Try invalid inputs to test error handling
6. **Close connections**: Always exit properly to ensure connection closure

---

**Test Status**: Ready for Quality Assurance ✓
