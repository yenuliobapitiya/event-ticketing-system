package com.ticketmanagement.event_ticketing_system.services;

import com.ticketmanagement.event_ticketing_system.models.Ticket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketPoolServices {

    private final List<Ticket> tickets = new ArrayList<>();

    // Synchronized method to add tickets
    public synchronized void addTicket(List<Ticket> newTickets) {
        tickets.addAll(newTickets);
        System.out.println(newTickets.size() + " tickets added. Total tickets: " + tickets.size());
    }

    // Synchronized method to remove a ticket
    public synchronized boolean removeTicket() {
        if (!tickets.isEmpty()) {
            tickets.remove(tickets.size() - 1);
            System.out.println("Ticket purchased. Remaining tickets: " + tickets.size());
            return true;
        }
        System.out.println("No tickets available to purchase.");
        return false;
    }

    // Method to get the current number of tickets
    public synchronized int getAvailableTickets() {
        return tickets.size();
    }
}