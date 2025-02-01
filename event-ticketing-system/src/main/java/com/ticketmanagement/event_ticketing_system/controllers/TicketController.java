package com.ticketmanagement.event_ticketing_system.controllers;

import com.ticketmanagement.event_ticketing_system.models.Ticket;
import com.ticketmanagement.event_ticketing_system.services.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketServices ticketServices;

    @PostMapping("/purchase")
    public String purchaseTicket(@RequestBody Ticket ticket) {
        boolean success = ticketServices.purchaseTicket(ticket);
        return success ? "Ticket purchased successfully!" : "Failed to purchase ticket.";
    }
}