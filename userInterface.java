import java.util.LinkedList;
import java.util.Scanner;

public class userInterface{

  static Scanner lineInput = new Scanner(System.in);
  static LinkedList<contact> contacts = new LinkedList<>();
  

  public static void main(String[] args){

    int userInput;

    System.out.println("=== Contact Manager ===");
    System.out.println("1. Insert a contact \n2. Sort Contacts");
    System.out.println("3. Modify Contact address \n4. Delete a contact \n5. Search for a contact");
    System.out.println("6. Display all contacts \n0. Exit");
    System.out.print("Please enter your choice: ");
    userInput = lineInput.nextInt();

    while (userInput != 0){

      switch(userInput){
        case 0:
          System.out.println("Exiting....");
          break;
        case 1:
          addContact();
          break;
        default:
          System.out.println("Invalid choice, please enter a valid option");
          break;
      }

      
      System.out.println("=== Contact Manager ===");
      System.out.println("1. Insert a contact \n2. Sort Contacts");
      System.out.println("3. Modify Contact address \n4. Delete a contact \n5. Search for a contact");
      System.out.println("6. Display all contacts \n0. Exit");
      System.out.print("Please enter your choice: ");
      userInput = lineInput.nextInt();
    }

    lineInput.close();
  }



  public static void addContact(){
    boolean addAnother = true;
    while (addAnother){
      lineInput.nextLine();
      System.out.print("Please Enter the Contacts first Name: ");
      String firstName = lineInput.nextLine();

      System.out.print("Please enter the Contacts last Name: ");
      String lastName = lineInput.nextLine();

      System.out.print("Please enter the contacts phone number: ");
      String phoneNum = lineInput.nextLine();

      System.out.print("Please enter the contacts address: ");
      String address = lineInput.nextLine();

      contact newContact = new contact(firstName, lastName, phoneNum, address);
      contacts.add(newContact);
      Sorter.sort(contacts);

      System.out.print("Would you like to enter another contact? (Y/n): ");
      char userPrompt = lineInput.nextLine().charAt(0);

      if(userPrompt == 'n' || userPrompt == 'N')  addAnother = false;

    }
  }
}

