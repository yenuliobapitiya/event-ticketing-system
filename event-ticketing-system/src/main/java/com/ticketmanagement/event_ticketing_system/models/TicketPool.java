package com.ticketmanagement.event_ticketing_system.models;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private final Queue<String> ticketQueue;
    private final int maxCapacity;

    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.ticketQueue = new LinkedList<>();
    }

    public synchronized void addTicket(String ticket) throws InterruptedException{
        while (ticketQueue.size() >= maxCapacity){
            System.out.println("TicketPool is Full. Please waiting to add Tickets...");
            wait();
        }
        ticketQueue.add(ticket);
        System.out.println("Added ticket: " + ticket + " | Current tickets: " + ticketQueue.size());
        notifyAll();
    }

    public synchronized void removeTicket() throws InterruptedException{
        while (ticketQueue.isEmpty()){
            System.out.println("No tickets available. Please waiting for Tickets...");
            wait();
        }
        String removedTicket = ticketQueue.poll();
        System.out.println("Removed ticket: " + removedTicket + " | Remaining tickets: " + ticketQueue.size());
        notifyAll();
    }

    public synchronized int getCurrentSize(){
        return ticketQueue.size();
    }
}
