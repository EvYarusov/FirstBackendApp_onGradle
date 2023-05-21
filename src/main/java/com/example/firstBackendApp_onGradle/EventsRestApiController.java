package com.example.firstBackendApp_onGradle;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest-api-events")   // @RestController = @Controller + @ResponseBody for each methode
public class EventsRestApiController {
    static final ArrayList<Event> events = new ArrayList<Event>() {{
        add(new Event("Violin concert", "Prague"));
        add(new Event("Jazz concert", "Berlin"));
        add(new Event("Art exhibition", "London"));
        add(new Event("Opera", "London"));
    }};

    @Operation(summary = "Get all events.", description = "Get all events filtered by city.")
    @GetMapping
    //@ResponseBody
    public List<Event> listEvents(@RequestParam(
            value = "city", required = false, defaultValue = "all") String city, Model model) {
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

    @Operation(summary = "Get event by ID.", description = "Get specific event by entering event ID.")
    @GetMapping(value = "/{eventId}")
    //@ResponseBody
    public Event getEvent(@PathVariable int eventId) {

        Event event = events.get(eventId);

        return event;
    }

    // Method: DELETE
    @Operation(summary = "Delete event by ID.", description = "Delete specific event by entering event ID.")
    @DeleteMapping(value = "/{eventId}")
    public Event deleteEvent(@PathVariable int eventId) {

        //TODO: add real remove
        Event event = events.get(eventId);

        return event;
    }

    @Operation(summary = "Update event fields.", description = "Update event fields by entering new values.")
    @PutMapping(value = "/{eventId}")
    public Event updateEvent(@PathVariable int eventId, @RequestBody Event newEvent) {

        Event event = events.get(eventId);
        //TODO: update event in database
        event = newEvent; // useless. just for example

        return event;
    }

    @Operation(summary = "Add new event.", description = "Add new event by entering object fields.")
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        // TODO save to database
        return event;
    }
}
