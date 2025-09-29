public class contact{

  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;

  public contact(){
    firstName = "";
    lastName = "";
    phoneNumber = "";
    address = "";
  }

  public contact(String firstName, String lastName, String phoneNumber, String address){
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }

  public String getFirstName(){
    return firstName;
  }
  public String getLastName(){
    return lastName;
  }
  public String getPhoneNumber(){
    return phoneNumber;
  }
  public String getAddress(){
    return address;
  }


  public void setFirstName(String firstName){
    this.firstName = firstName;
  }
  public void setLastName(String lastName){
    this.lastName = lastName;
  }
  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }
  public void setAddress(String address){
    this.address = address;
  }
  

  @Override
  public String toString(){
    return "Name: " + lastName + ", " + firstName + "\nPhone Number: " + phoneNumber + "\nAddress: " + address;
  }


}

