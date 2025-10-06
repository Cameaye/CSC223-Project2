import java.util.LinkedList;
import java.util.Scanner;

public class userInterface{

  public static void main(String[] args){

    LinkedList<contact> contacts = new LinkedList<>();

    Scanner lineInput = new Scanner(System.in);

    int userInput;

    System.out.println("=== Contact Manager ===");
    System.out.println("1. Insert a contact \n2. Sort Contacts by First Name\n3. Sort Contacts by Last Name");
    System.out.println("4. Modify Contact address \n5. Delete a contact \n6. Search for a contact");
    System.out.println("7. Display all contacts \n0. Exit");
    System.out.print("Please enter your choice: ");
    userInput = lineInput.nextInt();

    while (userInput != 0){

      switch(userInput){
        case 0:
          System.out.println("Exiting....");
          break;
        default:
          System.out.println("Invalid choice, please enter a valid option");
          break;
      }

      
      System.out.println("=== Contact Manager ===");
      System.out.println("1. Insert a contact \n2. Sort Contacts by First Name\n3. Sort Contacts by Last Name");
      System.out.println("4. Modify Contact address \n5. Delete a contact \n6. Search for a contact");
      System.out.println("7. Display all contacts \n0. Exit");
      System.out.print("Please enter your choice: ");
      userInput = lineInput.nextInt();
    }
  }
}

