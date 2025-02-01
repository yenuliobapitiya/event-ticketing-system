package com.ticketmanagement.event_ticketing_system.models;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int customerRetrievalRate;

    public Customer(TicketPool ticketPool, int customerRetrievalRate) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {

                Ticket ticket = new Ticket();
                ticketPool.removeTicket();   // Purchase ticket from the pool

                System.out.println("Customer purchased: " + ticket);
                Thread.sleep(customerRetrievalRate * 1000L); // Simulate time between purchases
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.out.println("Customer interrupted.");
        }
    }
}
