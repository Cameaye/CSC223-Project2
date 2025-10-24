/*
Program Name: userInterface.java
Author: Cameron Ayers 
Date: 10/24/2025
Input: User input through the console for managing a list of contacts. 
       Inputs include names, phone numbers, addresses, and menu selections.
Output: Displays formatted contact information and status messages to the console.
Description:
This program simulates the management of a contact list using a LinkedList in Java. 
It allows the user to add, delete, search for, modify, and display contacts. 
Each contact is represented by a Contact object. The list remains sorted by 
last name and first name using the Sorter class. This file serves as the main 
menu-driven user interface for the Contact Manager program.
*/

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class userInterface{




  // ===============================
  // Class Variables
  // ===============================
  static Scanner lineInput = new Scanner(System.in);
  static LinkedList<Contact> Contacts = new LinkedList<>();
  


    // ===============================
    // Main Method
    // ===============================

    /*
    The main entry point for the Contact Manager program.
    Displays a menu and allows the user to choose contact management operations.

    Signature: public static void main(String[] args)
    Parameters:
        - args (String[]): Command line arguments (not used in this program).
    Return Type: void
    Precondition: None.
    Postcondition: Runs until the user chooses to exit; all input and output occur via the console.
    */
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



    // ===============================
    // addContact Method
    // ===============================

    /*
    Adds one or more new Contact objects to the linked list. After each addition, 
    the list is re-sorted by last name and first name.

    Signature: public static void addContact()
    Parameters: None
    Return Type: void
    Precondition: None.
    Postcondition: One or more new Contact objects are added to the Contacts list, 
                   and the list remains sorted alphabetically.
    */
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


    // ===============================
    // printContacts Method
    // ===============================

    /*
    Displays all contacts currently stored in the linked list in a formatted layout.

    Signature: public static void printContacts()
    Parameters: None
    Return Type: void
    Precondition: The Contacts list may be empty or contain one or more Contact objects.
    Postcondition: All contacts in the list are printed to the console with labels.
    */
  public static void printContacts(){

    for(Contact curr: Contacts){
      System.out.println("Contact:");
      System.out.println(curr.toString());
      System.out.println();
    }
  }


    // ===============================
    // searchForContact Method
    // ===============================

    /*
    Searches for a Contact in the list based on first and last name provided by the user.

    Signature: public static Contact searchForContact()
    Parameters: None
    Return Type: Contact – the matching Contact object if found, otherwise null.
    Precondition: The Contacts list must exist and may contain zero or more entries.
    Postcondition: If found, the requested Contact is returned; if not found, 
                   the user is given the option to search again or stop.
    */
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

    // ===============================
    // removeContact Method
    // ===============================

    /*
    Removes a Contact from the list after searching for it by name.

    Signature: public static void removeContact()
    Parameters: None
    Return Type: void
    Precondition: The Contacts list must contain at least one Contact to remove.
    Postcondition: If the contact is found, it is removed from the list. 
                   Otherwise, an error message is displayed.
    */
  public static void removeContact(){
    Contact requestedDeletion = searchForContact();

    if(requestedDeletion != null){
      Contacts.remove(Contacts.indexOf(requestedDeletion));
      System.out.println("Contact " + requestedDeletion.getFirstName() + " " + requestedDeletion.getLastName() + " has been deleted!!");
    }
    else System.out.println("Error: No Contacts deleted");
  }


    // ===============================
    // updateAddress Method
    // ===============================

    /*
    Updates the address field of an existing Contact in the list.

    Signature: public static void updateAddress()
    Parameters: None
    Return Type: void
    Precondition: The Contacts list must contain the Contact to update.
    Postcondition: The address of the specified Contact is updated to a new value 
                   entered by the user, or an error message is displayed if not found.
    */
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

