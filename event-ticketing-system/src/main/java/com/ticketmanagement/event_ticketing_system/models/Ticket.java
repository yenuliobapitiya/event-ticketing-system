package com.ticketmanagement.event_ticketing_system.models;

public class Ticket {
    private int ticketId;
    private int eventId;
    private int customerId;

    public Ticket(int ticketId, int eventId, int customerId) {
        this.ticketId = ticketId;
        this.eventId = eventId;
        this.customerId = customerId;
    }

    public Ticket() {

    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

}
