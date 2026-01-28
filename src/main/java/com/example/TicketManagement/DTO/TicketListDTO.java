package com.example.TicketManagement.DTO;

import com.example.TicketManagement.projection.TicketListProjection;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TicketListDTO {

    private Long ticketId;
    private String title;
    private String status;
    private String priority;
    private LocalDateTime createdOn;

    public TicketListDTO(TicketListProjection p) {
        this.ticketId = p.getTicketId();
        this.title = p.getTitle();
        this.status = p.getStatus();
        this.priority = p.getPriority();
        this.createdOn = p.getCreatedOn();
    }
}
