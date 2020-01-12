package academy.learnprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("867-5309");
//    private static Contact contact = new Contact("", "");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit) {
          System.out.println("\nEnter action: (6 to show available actions)");
          int action = scanner.nextInt();
          scanner.nextLine();

          switch(action) {
            case 0:
              System.out.println("Closing mobile phone. Goodbye.");
              quit = true;
              break;

            case 1:
              mobilePhone.printContacts();
              break;

            case 2:
              addNewContact();
              break;

            case 3:
              updateContact();
              break;

            case 4:
              removeContact();
              break;

            case 5:
              queryContact();
              break;

            case 6:
              printActions();
              break;
          }
        }
    }
    private static void addNewContact() {
      System.out.println("Enter new contact name: ");
      String name = scanner.nextLine();
      System.out.println("Enter a phone number: ");
      String phoneNumber = scanner.nextLine();
      Contact newContact = Contact.createNewContact(name, phoneNumber);
      if(mobilePhone.addNewContact(newContact)) {
        System.out.println("New contact added: " + newContact.getName() + " : " + newContact.getPhoneNumber());
      } else {
        System.out.println("Can't add " + name);
      }
    }
    private static void updateContact() {
      System.out.println("Enter contact to update then press enter: ");
      String name = scanner.nextLine();
      Contact existingContact = mobilePhone.queryContact(name);
      if (existingContact == null) {
        System.out.println("Contact not found.");
        return;
      }
      System.out.println("Enter updated name then press enter: ");
      String updatedName = scanner.nextLine();
      System.out.println("Enter updated phone number then press enter: ");
      String updatedNumber = scanner.nextLine();
      Contact updatedContact = Contact.createNewContact(updatedName, updatedNumber);
      if(mobilePhone.updateContact(existingContact, updatedContact)) {
        System.out.println(updatedContact.getName() + "successfully updated");
      } else {
        System.out.println("Error updating");
      }
    }
    private static void removeContact() {
      System.out.println("Enter Contact name to be removed then press enter: ");
      String name = scanner.nextLine();
      Contact deleteContact = mobilePhone.queryContact(name);
      if(deleteContact == null) {
        System.out.println("Contact not found.");
        return;
      }
      if(mobilePhone.removeContact(deleteContact)) {
        System.out.println("Success");
      } else {
        System.out.println("error removing");
      }
    }
    private static void queryContact() {
      System.out.println("Enter contact name then press enter: ");
      String name = scanner.nextLine();
      Contact queriedContact = mobilePhone.queryContact(name);
      if (queriedContact == null) {
        System.out.println("Contact not found");
        return;
      }
      System.out.println("Name: " + queriedContact.getName() + ". Phone NUmber: " + queriedContact.getPhoneNumber());
    }
    private static void startPhone() {
      System.out.println("Starting phone...");
    }
    private static void printActions() {
      System.out.println("\nAvailable actions:\npress");
      System.out.println("0 - to shutdown\n" +
                          "1 - to print contacts\n" +
                          "2 - to add a new contact\n" +
                          "3 - to update existing contact\n" +
                          "4 - to remove an existing contact\n" +
                          "5 - query if a contact exists\n" +
                          "6 - to print a list of available actions");
      System.out.println("Choose your action: ");
    }


// .add() .size() .set() .remove() .get() .contains() .indexOf()
}
