package com.ticketmanagement.event_ticketing_system.models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Configuration {
    private final int totalTickets;
    private final int ticketReleaseRate;
    private final int customerRetrievalRate;
    private final int maxTicketCapacity;

    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    // Validation method
    public boolean isValid() {
        return totalTickets > 0 && ticketReleaseRate > 0 && customerRetrievalRate > 0 && maxTicketCapacity > 0;
    }

    public String toString() {
        return "Configuration{" +
                "totalTickets=" + totalTickets +
                ", ticketReleaseRate=" + ticketReleaseRate +
                ", customerRetrievalRate=" + customerRetrievalRate +
                ", maxTicketCapacity=" + maxTicketCapacity +
                '}';
    }

    public void saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Configuration Details:\n");
            writer.write("Total Tickets: " + totalTickets + "\n");
            writer.write("Ticket Release Rate: " + ticketReleaseRate + " ms\n");
            writer.write("Customer Retrieval Rate: " + customerRetrievalRate + " ms\n");
            writer.write("Max Ticket Capacity: " + maxTicketCapacity + "\n");
        } catch (IOException e) {
            System.out.println("Error saving configuration to file: " + e.getMessage());
        }
    }
}
