package com.ticketmanagement.event_ticketing_system.models;

public class Vendor implements Runnable {

    private final TicketPool ticketPool;
    private final int totalTickets;
    private final int ticketReleaseRate;

    public Vendor(TicketPool ticketPool, int totalTickets, int ticketReleaseRate) {
        this.ticketPool = ticketPool;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public void run() {
        try {
            for (int i = 1; i <= totalTickets; i++) {

                String ticket = "Ticket-" + i;
                ticketPool.addTicket(ticket);   // Add ticket to the pool
                Thread.sleep(ticketReleaseRate * 1000L); // Wait before adding next ticket
            }
        } catch (InterruptedException e) {
            System.out.println("Vendor interrupted. Selling tickets stopped.");
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
    }
}
