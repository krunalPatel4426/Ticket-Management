package com.example.TicketManagement.Service.Impl;

import com.example.TicketManagement.DTO.PageResponseDTO;
import com.example.TicketManagement.DTO.TicketListDTO;
import com.example.TicketManagement.Repository.TicketRepository;
import com.example.TicketManagement.projection.TicketListProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static org.apache.tomcat.util.http.RequestUtil.normalize;

@Service
public class TicketServiceImpl implements com.example.TicketManagement.Service.TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public PageResponseDTO<TicketListDTO> getTickets(
            Map<String, String> allRequestParam
    ) {
        int page = Integer.parseInt(allRequestParam.getOrDefault("page", "0"));
        int size = Integer.parseInt(allRequestParam.getOrDefault("size", "10"));
        String search = allRequestParam.get("search");
        String status = allRequestParam.get("status");
        String priority = allRequestParam.get("priority");
        String sortBy = allRequestParam.get("sortBy");
        String sortOrder = allRequestParam.get("sortOrder");

        int offset = (page) * size;

        List<TicketListProjection> projections =
                ticketRepository.findTickets(size, offset, search, status,priority,sortBy,sortOrder);

        List<TicketListDTO> dtoList = projections.stream()
                .map(TicketListDTO::new)
                .toList();

        long totalRecords = ticketRepository.countTickets(search, status, priority);

        int totalPages = (int) Math.ceil((double) totalRecords / size);

        return new PageResponseDTO<>(
                dtoList,
                page,
                totalPages,
                totalRecords
        );
    }
}
