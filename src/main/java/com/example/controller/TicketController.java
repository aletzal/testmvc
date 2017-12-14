package com.example.controller;

import com.example.model.TicketEntity;
import com.example.service.FilmServiceImpl;
import com.example.service.TicketServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@EnableWebMvc
@RequestMapping("/sys")
public class TicketController {

    private static final Logger log = LoggerFactory.getLogger("controller");

    private TicketServiceImpl ticketServiceImpl;

    private FilmServiceImpl filmServiceImpl;

    @Autowired
    public void setTicketServiceImpl(TicketServiceImpl ticketServiceImpl) {
        this.ticketServiceImpl = ticketServiceImpl;
    }

    @Autowired
    public void setFilmService(FilmServiceImpl filmServiceImpl) {
        this.filmServiceImpl = filmServiceImpl;
    }

    @RequestMapping(value = "/showTickets", method = RequestMethod.POST)
    public
    @ResponseBody
    List<TicketEntity> getAllTickets() {
        List<TicketEntity> tickets = ticketServiceImpl.findAll();
        log.info("************************** Got All Tickets ***************************");
        log.info("Количество билетов: " + tickets.size());
        log.info("**********************************************************************");
        return tickets;
    }

    //    Adding new ticket
    @RequestMapping(value = "/addTicket", method = RequestMethod.GET)
    public String showAddTicket(Map<String, Object> model) {
        TicketEntity entity = new TicketEntity();
//        List<FilmEntity> allfilms = filmServiceImpl.findAll();
        model.put("film_select", "0");
        model.put("ticketForm", entity);
        model.put("allfilms", filmServiceImpl.findAll());
        return "save";
    }

    @RequestMapping(value = "/addTicket.do", method = RequestMethod.POST)
    public String addTicket(@Valid @ModelAttribute("ticketForm") TicketEntity ticketEntity, BindingResult result, Map<String, Object> model) {
        log.info("***************************** Got Object *****************************");
        log.info(ticketEntity.toString());
        log.info("************************ Model contains Object ***********************");
        log.info(model.keySet().toString());
        log.info("**********************************************************************");
        if (result.hasErrors()) {
//           Set film_selector to save film choice after validation error
            if (ticketEntity.getFilm() != null) {
                model.put("film_select", ticketEntity.getFilm().getId());
            } else {
                model.put("film_select", "0");
            }
//            Returning to save form with List of films
//            List<FilmEntity> allfilms = filmServiceImpl.findAll();
            model.put("allfilms", filmServiceImpl.findAll());
            return "save";
        }
        log.info("************************** After Validation **************************");
        log.info(ticketEntity.toString());
        log.info("*********************** Model contains Objects ***********************");
        log.info(model.keySet().toString());
        log.info(model.get("ticketForm").toString());
        log.info("**********************************************************************");
        ticketServiceImpl.add(ticketEntity);
        return "redirect:/";
    }

    @RequestMapping(value = "/editTicket", method = RequestMethod.GET)
    public String showEditTicket(@RequestParam(value = "pid") Long ticket_id, Map<String, Object> model) {
        TicketEntity entity = ticketServiceImpl.findById(ticket_id);
        log.info("************** Getting Object by id = " + ticket_id + " ****************");
        log.info(entity.toString());
        log.info("**********************************************************************");
//        List<FilmEntity> allfilms = filmServiceImpl.findAll();
        model.put("film_select", entity.getFilm().getId());
        model.put("allfilms", filmServiceImpl.findAll());
        model.put("ticketForm", entity);
        model.put("pid", ticket_id);
        return "edit";
    }

    @RequestMapping(value = "/editTicket.do", method = RequestMethod.POST)
    public String editTicket(@Valid @ModelAttribute("ticketForm") TicketEntity ticketEntity, BindingResult result, Map<String, Object> model) {
        log.info("*************************** Editing Object ***************************");
        log.info(ticketEntity.toString());
        log.info("**********************************************************************");
        if (result.hasErrors()) {
//            Set film_selector to save film choice after validation error
            model.put("film_select", ticketEntity.getFilm().getId());
//            Returning to save form with List of films
//            List<FilmEntity> allfilms = filmServiceImpl.findAll();
            model.put("allfilms", filmServiceImpl.findAll());
            return "edit";
        }
        log.info("************************** After Validation **************************");
        log.info(ticketEntity.toString());
        log.info("********************* Successfully Updated Object *********************");
        log.info(model.keySet().toString());
        log.info(model.get("ticketForm").toString());
        log.info("**********************************************************************");
//        add method do persist or merge if entity exists
        ticketServiceImpl.add(ticketEntity);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteTicket", method = RequestMethod.GET)
    public String getDelete(@RequestParam(value = "pid") Long ticket_id) {
        log.info("*********************** Deleting request *****************************");
        log.info("Id = " + ticket_id);
        log.info("**********************************************************************");
        // Delete ticket
        ticketServiceImpl.delete(ticket_id);
        return "redirect:/";
    }
}
