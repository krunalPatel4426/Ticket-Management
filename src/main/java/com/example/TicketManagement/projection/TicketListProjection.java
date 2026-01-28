package com.example.TicketManagement.projection;

import java.time.LocalDateTime;

public interface TicketListProjection {
    Long getTicketId();
    String getTitle();
    String getStatus();
    String getPriority();
    LocalDateTime getCreatedOn();
}
