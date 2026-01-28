package com.example.TicketManagement.Service;

import com.example.TicketManagement.DTO.PageResponseDTO;
import com.example.TicketManagement.DTO.TicketListDTO;

import java.util.Map;

public interface TicketService {

    PageResponseDTO<TicketListDTO> getTickets(
            Map<String, String> allRequestParam
    );




//    PageResponseDTO<TicketListDTO> getTickets(
//            String search,
//            String status,
//            String priority,
//            int page,
//            int size,
//            String sortBy,
//            String direction
//    );
//
//    public PageResponseDTO<TicketListDTO> getTickets(
//            int page,
//            int size,
//            String sortBy
//    );


}
