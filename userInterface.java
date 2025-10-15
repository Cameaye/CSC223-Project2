import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class userInterface{

  static Scanner lineInput = new Scanner(System.in);
  static LinkedList<contact> contacts = new LinkedList<>();
  

  public static void main(String[] args){

    int userInput;

    System.out.println("=== Contact Manager ===");
    System.out.println("1. Insert a contact");
    System.out.println("2. Modify Contact address \n3. Delete a contact \n4. Search for a contact");
    System.out.println("5. Display all contacts \n0. Exit");
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

        case 5:
          printContacts();
          break;

        case 4:
          contact userRequested = searchForContact();
          if(userRequested != null) System.out.println(userRequested.toString());
          break;
        default:
          System.out.println("Invalid choice, please enter a valid option");
          break;
      }

      
      System.out.println("=== Contact Manager ===");
      System.out.println("1. Insert a contact");
      System.out.println("2. Modify Contact address \n3. Delete a contact \n4. Search for a contact");
      System.out.println("5. Display all contacts \n0. Exit");
      System.out.print("Please enter your choice: ");
      userInput = lineInput.nextInt();
    }

    lineInput.close();
  }



  public static void addContact(){
    boolean addAnother = true;
    while (addAnother){
      System.out.println("Please press enter to continue...");
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


  public static void printContacts(){

    for(contact curr: contacts){
      System.out.println("Contact:");
      System.out.println(curr.toString());
      System.out.println();
    }
  }

  public static contact searchForContact(){
    lineInput.nextLine();
    Iterator<contact> contactsIterator; 
    contactsIterator = contacts.iterator();
  
    System.out.print("Please enter the last name of the contact you would like to search for: ");
    String desiredLast = lineInput.nextLine();

    System.out.print("Please enter the first name of the contact you would like to search for: ");
    String desiredFirst = lineInput.nextLine();
    
    contact current;
    while(contactsIterator.hasNext()){
      current = contactsIterator.next();
      if (desiredLast.equalsIgnoreCase(current.getLastName())) {
        if(desiredFirst.equalsIgnoreCase(current.getFirstName())){
          return current;
        }
      }
    }

   System.out.println("No contact found, would you like to search again? (y/n)");
   
   char userPrompt = lineInput.nextLine().charAt(0);

   if(userPrompt == 'n' || userPrompt == 'N'){
     return null;
    }
   else return searchForContact();

  }
}

