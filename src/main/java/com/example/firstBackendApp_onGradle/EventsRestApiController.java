package com.example.firstBackendApp_onGradle;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController // @RestController = @Controller + @ResponseBody for each methode
public class EventsRestApiController {
    static final ArrayList<Event> events = new ArrayList<Event>(){{
        add(new Event("Violin concert", "Prague"));
        add(new Event("Jazz concert", "Berlin"));
        add(new Event("Art exhibition", "London"));
        add(new Event("Opera", "London"));
    }};

    @RequestMapping(value = "/rest-api-events", method = RequestMethod.GET)
    //@ResponseBody
    public List<Event> listEvents(@RequestParam(
            value = "city", required = false, defaultValue = "all") String city, Model model)
    {
        List<Event> resultEvents = events;
        if (!city.equals("all")) {
            resultEvents = events.stream()
                    .filter(e -> e.getCity().equals(city)).collect(Collectors.toList());
        }
        return resultEvents;
    }

    // Resource: Event
    // URL: http://localhost:8080/restApiEvents/{eventId}
    // Representation: "{"name":"Violin concert","city":"Prague"}"
    // Method: GET

    @GetMapping(value = "/rest-api-events/{eventId}")
    //@ResponseBody
    public Event getEvent(@PathVariable int eventId) {

        Event event = events.get(eventId);

        return event;
    }

    // Method: DELETE
    @DeleteMapping(value = "/rest-api-events/{eventId}")
    public Event deleteEvent(@PathVariable int eventId) {

        //TODO: add real remove
        Event event = events.get(eventId);

        return event;
    }
    @PutMapping(value = "/rest-api-events/{eventId}")
    public Event updateEvent(@PathVariable int eventId, @RequestBody Event newEvent) {

        Event event = events.get(eventId);
        //TODO: update event in database
        event = newEvent; // useless. just for example

        return event;
    }
}
