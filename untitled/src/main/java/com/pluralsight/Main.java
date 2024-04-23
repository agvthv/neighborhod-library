package com.pluralsight;

import java.util.Scanner;

public class Main {
    static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        Books[] books = {
                new Books("The Midnight Library", "200", 1, false),
                new Books("Dune", "201", 2, false),
                new Books("The Great Gatsby", "202", 3, false),
                new Books("To Kill a Mockingbird", "203", 4, false),
                new Books("1984", "204", 5, false),
                new Books("Pride and Prejudice", "205", 6, false),
                new Books("The Catcher in the Rye", "206", 7, false),
                new Books("Harry Potter and the Sorcerer's Stone", "207", 8, false),
                new Books("The Hobbit", "208", 9, false),
                new Books("The Lord of the Rings", "209", 10, false),
                new Books("The Hunger Games", "210", 11, false),
                new Books("The Da Vinci Code", "211", 12, false),
                new Books("The Alchemist", "212", 13, false),
                new Books("The Name of the Wind", "213", 14, false),
                new Books("Brave New World", "214", 15, false),
                new Books("The Road", "215", 16, false),
                new Books("The Book Thief", "216", 17, false),
                new Books("A Game of Thrones", "217", 18, false),
                new Books("The Girl with the Dragon Tattoo", "218", 19, false),
                new Books("The Chronicles of Narnia", "219", 20, false)
        };

        while (true) {
            int choice = getHomeScreenSelection();
            switch (choice) {
                case 1:
                    availBooks(books);
                    break;
                case 2:
                    checkedOut(books);
                    break;
                case 3:
                    checkIn(books);
                    break;
                default:
                    System.out.println("\nInvalid option. Please try again.\n");
                    break;
            }
        }
    }

    public static int getHomeScreenSelection() {
        System.out.println("Welcome to the Neighborhood Library");
        System.out.println("------------------------------------");
        System.out.println("Would you like to: ");
        System.out.println("\n1 - View Available Books");
        System.out.println("2 - View Checked Out Books");
        System.out.println("3 - Check In a Book");
        System.out.println("\nPlease enter here: ");
        return userInput.nextInt();
    }

    public static void availBooks(Books[] books) {
        System.out.println("Available Books");
        System.out.println("----------------------------------------");

        for (Books book : books) {
            if (!book.isCheckedOut()) {
                System.out.printf("%-5d ISBN%-13s %-40s\n", book.getId(), book.getIsbn(), book.getTitle());
            }
        }

        System.out.println("\nWould you like to: ");
        System.out.println("C - Check Out a Book");
        System.out.println("X - Go Back");
        System.out.print("Please enter here: ");
        userInput.nextLine(); // Consume newline left-over
        String option = userInput.nextLine();
        if (option.equalsIgnoreCase("C")) {
            System.out.print("Enter the ID of the book to check out: ");
            int bookId = userInput.nextInt();
            userInput.nextLine(); // Consume newline
            for (Books book : books) {
                if (book.getId() == bookId && !book.isCheckedOut()) {
                    System.out.print("Please enter your name: ");
                    String name = userInput.nextLine();
                    book.checkOut(name);
                    System.out.println("Book checked out successfully to " + name + ".");
                    return;
                }
            }
            System.out.println("Invalid book ID or book already checked out.");
        } else if (option.equalsIgnoreCase("X")) {
            // Just return to the main menu
        } else {
            System.out.println("Invalid option.");
        }
    }

    public static void checkedOut(Books[] books) {
        System.out.println("Checked Out Books");
        System.out.println("----------------------------------------");
        System.out.println();

        for (Books book : books) {
            if (book.isCheckedOut()) {
                System.out.printf("%-5d %-13s %-40s Checked out to: %s\n", book.getId(), book.getIsbn(), book.getTitle(), book.getCheckOutTo());
            }
        }

        System.out.println("Would you like to: ");
        System.out.println("C - Check In a Book");
        System.out.println("X - Go Back");
        System.out.print("Please enter here: ");
        String choice = userInput.nextLine();

        if (choice.equalsIgnoreCase("C")) {
            System.out.print("Enter book ID to check in: ");
            int id = userInput.nextInt();
            userInput.nextLine(); // Consume newline
            for (Books book : books) {
                if (book.getId() == id && book.isCheckedOut()) {
                    book.checkIn();
                    System.out.println("Book ID " + id + " has been checked in.");
                    return;
                }
            }
            System.out.println("Invalid book ID or book is not checked out.");
        } else if (choice.equalsIgnoreCase("X")) {
            // Just return to the main menu
        } else {
            System.out.println("Invalid option.");
        }
    }

    public static void checkIn(Books[] books) {
        System.out.print("Enter the ID of the book you want to check in: ");
        int bookId = userInput.nextInt();
        userInput.nextLine(); // Consume newline
        for (Books book : books) {
            if (book.getId() == bookId && book.isCheckedOut()) {
                book.checkIn();
                System.out.println("Book checked in successfully.\n");
                return;
            }
        }
        System.out.println("Book ID not found or book is not checked out. Try again.");
    }
}
