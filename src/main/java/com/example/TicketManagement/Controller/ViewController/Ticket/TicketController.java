package com.example.TicketManagement.Controller.ViewController.Ticket;

import com.example.TicketManagement.DTO.PageResponseDTO;
import com.example.TicketManagement.DTO.TicketListDTO;
import com.example.TicketManagement.DTO.TicketListRequestDTO;
import com.example.TicketManagement.Repository.TicketRepository;
import com.example.TicketManagement.Service.Impl.TicketServiceImpl;
import org.hibernate.dialect.function.StringFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketService;

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/tickets")
    public ModelAndView ticketPageServe(){
        ModelAndView model = new ModelAndView();
        List<String> statusList = ticketRepository.statusList();
        model.addObject("statusList", statusList);
        model.setViewName("Ticket/tickets");
        return model;
    }


//    @RequestParam(value = "page", defaultValue = "0", required = false) int page,
//    @RequestParam(value = "size", defaultValue = "10", required = false) int size,
//    @RequestParam(value = "search", defaultValue = "", required = false) String search,
//    @RequestParam(value = "status", defaultValue = "", required = false) String status,
//    @RequestParam(value = "priority", defaultValue = "", required = false) String priority,
//    @RequestParam(value = "sortBy", defaultValue = "", required = false) String sortBy,
//    @RequestParam(value = "sortOrder", defaultValue = "desc", required = false) String sortOrder

    @PostMapping("/api/tickets/getData")
    @ResponseBody
    public PageResponseDTO<TicketListDTO> getTickets(
            @RequestParam Map<String, String> allRequestparam
            ) {
        System.out.println(allRequestparam);
        return ticketService.getTickets(allRequestparam);
    }

//    @GetMapping("/api/tickets/getData")
//    @ResponseBody
//    public PageResponseDTO<TicketListDTO> getTickets(
//            @RequestParam(defaultValue = "1") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "createdOn") String sortBy
//    ) {
//        return ticketService.getTickets(
//                 page, size, sortBy);
//    }

}
