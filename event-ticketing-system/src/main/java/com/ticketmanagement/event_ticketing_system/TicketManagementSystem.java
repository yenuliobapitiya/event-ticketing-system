package com.ticketmanagement.event_ticketing_system;

import com.ticketmanagement.event_ticketing_system.models.Configuration;
import com.ticketmanagement.event_ticketing_system.models.Customer;
import com.ticketmanagement.event_ticketing_system.models.Vendor;
import com.ticketmanagement.event_ticketing_system.models.TicketPool;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicketManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Ticket Management System!");

        int totalTickets = getValidatedInput(scanner, "Enter the total number of tickets : ");
        int ticketReleaseRate = getValidatedInput(scanner, "Enter the ticket release rate in milliseconds: ");
        int customerRetrievalRate = getValidatedInput(scanner, "Enter the customer retrieval rate in milliseconds: ");
        int maxTicketCapacity = getValidatedInput(scanner, "Enter the maximum ticket capacity: ");

        int totalVendors = getValidatedInput(scanner, "Enter the total number of vendors: ");
        int totalCustomers = getValidatedInput(scanner, "Enter the total number of customers: ");

        // Create a Configuration object
        Configuration configuration = new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);

        // Validate the Configuration
        if (configuration.isValid()) {
            configuration.saveToFile("configuration.txt");
            System.out.println("Configuration saved to file successfully!");
        } else {
            System.out.println("Invalid configuration. Please check the values.");
            return; // Exit the program if the configuration is invalid
        }

        TicketPool ticketPool = new TicketPool(maxTicketCapacity);

        // Create vendor and customer threads
        for (int t = 0; t < totalVendors; t++) {
            Thread vendor = new Thread(new Vendor(ticketPool, totalTickets, ticketReleaseRate));
            vendor.start();
        }

        for (int i = 0; i < totalCustomers; i++) {
            Thread customer = new Thread(new Customer(ticketPool, customerRetrievalRate));
            customer.start();
        }

        // Menu to interact with the system
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Display current ticket pool size");
            System.out.println("2. Exit system");
            int choice = getValidatedInput(scanner, "Enter your choice (1 or 2): ");

            if (choice == 1) {
                System.out.println("Current ticket pool size: " + ticketPool.getCurrentSize());
            } else if (choice == 2) {
                System.out.println("Exiting the system...");
                scanner.close(); // Close scanner before exiting
                System.exit(0);
            }
        }
    }

    /**
     * Method to get validated positive integer input from the user.
     * @param scanner Scanner instance for input
     * @param prompt Prompt to display to the user
     * @return A validated positive integer
     */
    private static int getValidatedInput(Scanner scanner, String prompt) {
        int value = -1;
        while (value <= 0) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                if (value <= 0) {
                    System.out.println("Invalid input! Please enter a positive integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }
        return value;
    }
}
