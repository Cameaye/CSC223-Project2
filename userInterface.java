import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class userInterface{

  static Scanner lineInput = new Scanner(System.in);
  static LinkedList<Contact> Contacts = new LinkedList<>();
  

  public static void main(String[] args){

    int userInput;

    System.out.println("=== Contact Manager ===");
    System.out.println("1. Insert a Contact");
    System.out.println("2. Modify Contact address \n3. Delete a Contact \n4. Search for a Contact");
    System.out.println("5. Display all Contacts \n0. Exit");
    System.out.print("Please enter your choice: ");
    userInput = lineInput.nextInt();
    System.out.println("\n\n");

    while (userInput != 0){

      switch(userInput){
        case 0:
          System.out.println("Exiting....");
          break;
        case 1:
          addContact();
          break;
        case 2:
          updateAddress();
          break;
        case 3:
          removeContact();
          break;
        case 4:
          Contact userRequested = searchForContact();
          if(userRequested != null) System.out.println(userRequested.toString());
          break;
        case 5:
          printContacts();
          break;
        default:
          System.out.println("Invalid choice, please enter a valid option");
          break;
      }

      
      System.out.println("=== Contact Manager ===");
      System.out.println("1. Insert a Contact");
      System.out.println("2. Modify Contact address \n3. Delete a Contact \n4. Search for a Contact");
      System.out.println("5. Display all Contacts \n0. Exit");
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

      System.out.print("Please enter the Contacts phone number: ");
      String phoneNum = lineInput.nextLine();

      System.out.print("Please enter the Contacts address: ");
      String address = lineInput.nextLine();

      Contact newContact = new Contact(firstName, lastName, phoneNum, address);
      Contacts.add(newContact);
      Sorter.sort(Contacts);

      System.out.print("Would you like to enter another Contact? (Y/n): ");
      char userPrompt = lineInput.nextLine().charAt(0);

      if(userPrompt == 'n' || userPrompt == 'N')  addAnother = false;

    }
  }


  public static void printContacts(){

    for(Contact curr: Contacts){
      System.out.println("Contact:");
      System.out.println(curr.toString());
      System.out.println();
    }
  }

  public static Contact searchForContact(){
    lineInput.nextLine();
    Iterator<Contact> ContactsIterator; 
    ContactsIterator = Contacts.iterator();
  
    System.out.print("Please enter the last name of the Contact: ");
    String desiredLast = lineInput.nextLine();

    System.out.print("Please enter the first name of the Contact: ");
    String desiredFirst = lineInput.nextLine();
    
    Contact current;
    while(ContactsIterator.hasNext()){
      current = ContactsIterator.next();
      if (desiredLast.equalsIgnoreCase(current.getLastName())) {
        if(desiredFirst.equalsIgnoreCase(current.getFirstName())){
          return current;
        }
      }
    }

   System.out.println("No Contact found, would you like to search again? (y/n)");
   
   char userPrompt = lineInput.nextLine().charAt(0);

   if(userPrompt == 'n' || userPrompt == 'N'){
     return null;
    }
   else return searchForContact();

  }


  public static void removeContact(){
    Contact requestedDeletion = searchForContact();

    if(requestedDeletion != null){
      Contacts.remove(Contacts.indexOf(requestedDeletion));
      System.out.println("Contact " + requestedDeletion.getFirstName() + " " + requestedDeletion.getLastName() + " has been deleted!!");
    }
    else System.out.println("Error: No Contacts deleted");
  }

  public static void updateAddress(){
    Contact requestedUpdate = searchForContact();
    int indexOfRequestedUpdate;

    if(requestedUpdate != null){
      indexOfRequestedUpdate = Contacts.indexOf(requestedUpdate);
      
      System.out.print("Please enter the new address for the Contact: ");
      String newAddr = lineInput.nextLine();

      Contacts.get(indexOfRequestedUpdate).setAddress(newAddr);
      System.out.println("Contact " + requestedUpdate.getFirstName() + " " + requestedUpdate.getLastName() + " has had its address updated to " + newAddr);
    }
    else System.out.println("Error: No Contacts address could be updated");


  }
}

