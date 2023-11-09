package com.dms;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Connection {
	
	private void getcon()
    {
        java.sql.Connection con;
        try{
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5433/ManageItems","postgres","rtsAdmin");
            if(con!=null)
                System.out.println("Connection OK");
            else
                System.out.println("Connection Failed");
 
        }
        catch(Exception e)
            {
                System.out.println(e);
            }
    }

	
    
    @SuppressWarnings("null")
	public static void main(String[] args) {
    	
    	Connection sqlconnect=new Connection();
    			sqlconnect.getcon();
    			
    	String dbUrl = "jdbc:postgresql://localhost:5433/ManageItems";
        String dbUsername = "postgres";
        String dbPassword = "rtsAdmin" ;
    Scanner scanner = new Scanner(System.in);
    
    CategoryManager categoryManager = null ; // Initialize CategoryManager
    ItemManager itemManager = null; // Initialize ItemManager
    while (true) {
       System.out.println("1. Add a new category");
      System.out.println("2. List all categories");
        System.out.println("3. Add a new item and associate it with a category");
       System.out.println("4. List all items in a specific category");
         System.out.println("5. Calculate statistics");
          System.out.println("6. Exit");
        System.out.print("Enter your choice:- ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (choice) {
        case 1:
            System.out.print("Enter category name:- ");
            String categoryName = scanner.nextLine();
            Category newCategory = new Category(choice, categoryName);
            try {
            categoryManager.addCategory(newCategory);
              System.out.println("Category added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error adding category.");
            }
            break;
            case 2:
                try {
                    List<Category> categories = categoryManager.listAllCategories();
                    for (Category category : categories) {
                    	System.out.println("Category ID:- " + category.getId() + ", Name:- " + category.getName());
                 }
               } catch (SQLException e) {
                   e.printStackTrace();
                  System.out.println("Error listing categories.");
              }
                break;
         case 3:
                // Add a new item in category
                try {
                    System.out.print("Enter item name:- ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item description:- ");
                    String itemDescription = scanner.nextLine();
                    System.out.print("Enter category ID:- ");
                    int categoryId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Item newItem = new Item(0, itemName, itemDescription, categoryId); // Assuming 0 as a placeholder for ID
                    itemManager.addItem(newItem);
                    System.out.println("Item added successfully.");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error while adding item.");
                }
                break;
            case 4:
                // List all items in a specific category
                try {
                    System.out.print("Enter category ID:- ");
                    int categoryId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    List<Item> items = itemManager.listItemsInCategory(categoryId);
                    for (Item item : items) {
                        System.out.println("Item ID:- " + item.getId() + ", Name:- " + item.getName() + ", Description:- " + item.getDescription());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error to get the list of items.");
                }
                break;
        case 5:
            
            break;
        case 6:
            System.out.println("Thank you have a Good Day");
            System.exit(0);
            break;
        default:
            System.out.println("Invalid choice.");
    }

       

}
}
	public PreparedStatement prepareStatement(String query) {
		// TODO Auto-generated method stub
		return null;
	}
    
}