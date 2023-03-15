package Assignment;

import java.util.LinkedList;
import java.util.Scanner;

public class ContactBook {

    public static LinkedList<Contact> contacts = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("************************************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)Email Search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");
            System.out.println("************************************");
            System.out.print("Please Enter a Command: ");

            String command = scanner.nextLine().toUpperCase();
            switch (command) {
                case "A" -> addContact(scanner);
                case "D" -> deleteContact(scanner);
                case "E" -> emailSearch(scanner);
                case "P" -> printContacts();
                case "S" -> searchContact(scanner);
                case "Q" -> {
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid command.");
            }

            System.out.println();
        }
    }

    private static void addContact(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);

        System.out.println("Contact added: " + contact);
    }

    private static void deleteContact(Scanner scanner) {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();

        boolean removed = contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Contact deleted: " + name);
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    private static void emailSearch(Scanner scanner) {
        System.out.print("Enter email address to search: ");
        String email = scanner.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getEmail().equalsIgnoreCase(email)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contacts found with email: " + email);
        }
    }

    private static void printContacts() {
        System.out.println("Contacts:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    private static void searchContact(Scanner scanner) {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contacts found with name: " + name);
        }
    }

    private static class Contact {
        public String name;
        public String phone;
        public String email;

        public Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
        }
    }
}