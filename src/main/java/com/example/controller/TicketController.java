package com.example.controller;

import com.example.model.TicketEntity;
import com.example.service.TicketServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@EnableWebMvc
@RequestMapping("/sys")
public class TicketController {

    private static final Logger log = LoggerFactory.getLogger("controller");

    @Autowired
    private TicketServiceImpl ticketServiceImpl;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public @ResponseBody
    List<TicketEntity> getAllUsers (){
        return ticketServiceImpl.findAll();
    }

    @RequestMapping(value = "/showTickets",method = RequestMethod.GET)
    public @ResponseBody List<TicketEntity> showPage(){
        List<TicketEntity> tickets = ticketServiceImpl.findAll();
        return tickets;
    }

    @RequestMapping(value = "/addTicket",method = RequestMethod.GET)
    public String showaddTicket(Map<String, Object> model){
        TicketEntity entity = new TicketEntity();
        model.put("ticketForm",entity);
        return "save";
    }

    @RequestMapping(value = "/addTicket.do", method = RequestMethod.POST)
    public String addTicket(@Valid @ModelAttribute("ticketForm") TicketEntity ticketEntity, BindingResult result,
                            Map<String,Object> model){
        log.info("***************************** Got Object *****************************");
        log.info(ticketEntity.toString());
        log.info("**********************************************************************");
        if (result.hasErrors()) {
            return "save";
        }
        ticketServiceImpl.add(ticketEntity);
        return "listusers";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String getDelete(@RequestParam(value = "pid") Long ticket_id){
        log.info("*********************** Deleting request *****************************");
        log.info("Id = " + ticket_id);
        log.info("**********************************************************************");
        // Delete ticket
        ticketServiceImpl.delete(ticket_id);
        return "listusers";
    }
}
