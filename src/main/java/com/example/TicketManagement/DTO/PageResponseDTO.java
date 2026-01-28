package com.example.TicketManagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PageResponseDTO<T> {

    private List<T> data;
    private int currentPage;
    private int totalPages;
    private long totalRecords;
}
