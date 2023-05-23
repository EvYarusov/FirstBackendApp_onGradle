package com.example.firstBackendApp_onGradle.events;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Controller
public class EventController {
    static final ArrayList<EventDTO> EVENT_DTOS = new ArrayList<EventDTO>(){{
        add(new EventDTO("Violin concert", "Prague"));
        add(new EventDTO("Jazz concert", "Berlin"));
        add(new EventDTO("Art exhibition", "London"));
        add(new EventDTO("Opera", "London"));
    }};

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String listEventsChangeName(@RequestParam(
            name = "city", required = false, defaultValue = "all") String city, Model model)
    {
        List<EventDTO> resultEventDTOS = EVENT_DTOS;
        if (!city.equals("all")) {
            resultEventDTOS = EVENT_DTOS.stream().filter(e -> e.getCity().equals(city)).collect(Collectors.toList());
        }
        model.addAttribute("events", resultEventDTOS); // Pass data to view
        return "eventsView"; // Return name of view
    }
}
