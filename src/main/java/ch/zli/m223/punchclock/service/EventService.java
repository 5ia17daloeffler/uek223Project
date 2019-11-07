package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Event;
import ch.zli.m223.punchclock.repository.EventRepository;

import java.util.List;

public class EventService {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public Event createEvent(Event event) {
        return eventRepository.saveAndFlush(event);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    /**
     * Löscht den Eintrag mit der mitgegebenen Id wird gelöscht.
     *
     * @param id
     */
    public void deleteEntry(long id) {
        eventRepository.deleteById(id);
    }
}
