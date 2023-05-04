package com.example.firstBackendApp_onGradle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Event {
    private String name;
    private String city;
    public Event(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity()
    {
        return city;
    }
}

@Controller
public class EventsController {
    static final ArrayList<Event> events = new ArrayList<Event>(){{
        add(new Event("Violin concert", "Prague"));
        add(new Event("Jazz concert", "Berlin"));
        add(new Event("Art exhibition", "London"));
        add(new Event("Opera", "London"));
    }};

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String listEventsChangeName(@RequestParam(name = "city", required = false, defaultValue = "all") String city, Model model)
    {
        List<Event> resultEvents = events;
        if (!city.equals("all")) {
            resultEvents = events.stream().filter(e -> e.getCity().equals(city)).collect(Collectors.toList());
        }
        model.addAttribute("events", resultEvents); // Pass data to view
        return "eventsView"; // Return name of view
    }
}
