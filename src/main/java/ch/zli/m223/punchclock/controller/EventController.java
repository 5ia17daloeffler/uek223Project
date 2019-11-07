package ch.zli.m223.punchclock.controller;


import ch.zli.m223.punchclock.domain.Event;
import ch.zli.m223.punchclock.repository.EventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private EventRepository eventRepository;

    public EventController (EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostMapping("/add-event")
    public void addEvent(@RequestBody Event event) {
        eventRepository.save(event);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        eventRepository.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
