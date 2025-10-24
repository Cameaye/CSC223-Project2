/*
Program Name: Contact.java
Author: Cameron Ayers
Date: 10/24/2025
Input: The program receives user input for contact information such as 
       first name, last name, phone number, and address.
Output: The program outputs formatted contact details when requested.
Description: 
This class defines a Contact object that stores basic information about a person, 
including first name, last name, phone number, and address. It includes 
constructors for creating Contact objects, getter and setter methods to access 
and modify contact data, and a toString() method for neatly formatted output.
*/
public class Contact{

  
  // ===============================
  // Private Data Members
  // ===============================
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;

    // ===============================
    // Constructors
    // ===============================

    /*
    Default constructor that initializes all data members to empty strings.

    Signature: public Contact()
    Parameters: None
    Return Type: None (constructor)
    Precondition: None
    Postcondition: A Contact object is created with all fields initialized to empty strings.
    */
  public Contact(){
    firstName = "";
    lastName = "";
    phoneNumber = "";
    address = "";
  }

    /*
    Overloaded constructor that initializes all data members using provided parameters.

    Signature: public Contact(String firstName, String lastName, String phoneNumber, String address)
    Parameters:
        - firstName (String): The contact's first name.
        - lastName (String): The contact's last name.
        - phoneNumber (String): The contact's phone number.
        - address (String): The contact's address.
    Return Type: None (constructor)
    Precondition: Parameters must contain valid, non-null string values.
    Postcondition: A Contact object is created with all data members set to the provided values.
    */
  public Contact(String firstName, String lastName, String phoneNumber, String address){
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }
    // ===============================
    // Accessor (Getter) Methods
    // ===============================

    /*
    Retrieves the first name of the contact.

    Signature: public String getFirstName()
    Parameters: None
    Return Type: String – the contact’s first name.
    Precondition: A Contact object must exist.
    Postcondition: The first name of the contact is returned.
    */
  public String getFirstName(){
    return firstName;
  }

    /*
    Retrieves the last name of the contact.

    Signature: public String getLastName()
    Parameters: None
    Return Type: String – the contact’s last name.
    Precondition: A Contact object must exist.
    Postcondition: The last name of the contact is returned.
    */
  public String getLastName(){
    return lastName;
  }
    /*
    Retrieves the phone number of the contact.

    Signature: public String getPhoneNumber()
    Parameters: None
    Return Type: String – the contact’s phone number.
    Precondition: A Contact object must exist.
    Postcondition: The phone number of the contact is returned.
    */
  public String getPhoneNumber(){
    return phoneNumber;
  }

    /*
    Retrieves the address of the contact.

    Signature: public String getAddress()
    Parameters: None
    Return Type: String – the contact’s address.
    Precondition: A Contact object must exist.
    Postcondition: The address of the contact is returned.
    */
  public String getAddress(){
    return address;
  }


    // ===============================
    // Mutator (Setter) Methods
    // ===============================

    /*
    Updates the first name of the contact.

    Signature: public void setFirstName(String firstName)
    Parameters:
        - firstName (String): The new first name for the contact.
    Return Type: void
    Precondition: Input must be a valid string.
    Postcondition: The contact's first name is updated.
    */
  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

    /*
    Updates the last name of the contact.

    Signature: public void setLastName(String lastName)
    Parameters:
        - lastName (String): The new last name for the contact.
    Return Type: void
    Precondition: Input must be a valid string.
    Postcondition: The contact's last name is updated.
    */
  public void setLastName(String lastName){
    this.lastName = lastName;
  }
    /*
    Updates the phone number of the contact.

    Signature: public void setPhoneNumber(String phoneNumber)
    Parameters:
        - phoneNumber (String): The new phone number for the contact.
    Return Type: void
    Precondition: Input must be a valid string representing a phone number.
    Postcondition: The contact's phone number is updated.
    */
  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }
    /*
    Updates the address of the contact.

    Signature: public void setAddress(String address)
    Parameters:
        - address (String): The new address for the contact.
    Return Type: void
    Precondition: Input must be a valid string.
    Postcondition: The contact's address is updated.
    */
  public void setAddress(String address){
    this.address = address;
  }
  

    // ===============================
    // toString Method
    // ===============================

    /*
    Returns a neatly formatted string representation of the contact.

    Signature: public String toString()
    Parameters: None
    Return Type: String – formatted text showing the contact’s name, phone number, and address.
    Precondition: A Contact object must exist with initialized values.
    Postcondition: A formatted string representing the contact is returned.
    */
  @Override
  public String toString(){
    return "Name: " + lastName + ", " + firstName + "\nPhone Number: " + phoneNumber + "\nAddress: " + address;
  }
}

