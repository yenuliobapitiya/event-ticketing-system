package com.ticketmanagement.event_ticketing_system.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/config")
public class ConfigController {

    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;

    @PostMapping("/set")
    public String setConfig(@RequestParam int totalTickets,
                            @RequestParam int ticketReleaseRate,
                            @RequestParam int customerRetrievalRate) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        return "Configuration set successfully!";
    }

    @GetMapping("/get")
    public String getConfig() {
        return String.format("Total Tickets: %d, Ticket Release Rate: %d, Customer Retrieval Rate: %d",
                totalTickets, ticketReleaseRate, customerRetrievalRate);
    }
}
