package com.bogdan_yanushkevich.javacore.rest.service;

import com.bogdan_yanushkevich.javacore.rest.model.Event;
import com.bogdan_yanushkevich.javacore.rest.repository.EventRepository;
import com.bogdan_yanushkevich.javacore.rest.repository.impl.HibEventRepositoryImpl;


import java.util.List;

public class EventService {

    private final EventRepository eventRepository = new HibEventRepositoryImpl();

    public Event getById(Integer id) {
        return eventRepository.getById(id);
    }

    public void delete(Integer id) {
        eventRepository.delete(id);
    }

    public List<Event> getAll() {
        return eventRepository.getAll();
    }
}