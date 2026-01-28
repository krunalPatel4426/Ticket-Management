package com.example.TicketManagement.Controller.ViewController;

import com.example.TicketManagement.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @Autowired
    private TicketRepository ticketRepository;
    @GetMapping("/hello")
    public ModelAndView hello(){
        ModelAndView model = new ModelAndView();
        model.setViewName("Ticket/tickets");
        return model;
    }

    @GetMapping("/getDBviz")
    public ModelAndView getDbViz(){
        ModelAndView model = new ModelAndView();
        model.setViewName("DBviz/DBviz");
        return model;
    }

    @GetMapping("/er-diagram")
    public String showERDiagram() {
        return "database-er-diagram"; // if in templates folder
    }
}
