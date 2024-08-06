package com.example.Alightway_Solutions.event.services;

import com.example.Alightway_Solutions.event.entities.EventEntity;
import com.example.Alightway_Solutions.event.models.EventModel;
import com.example.Alightway_Solutions.event.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public ResponseEntity<?> saveEventDetails(EventModel model) {
        try{

            EventEntity entity = new EventEntity();
            entity.setEventName(model.getEventName());
            entity.setEventDate(sdf.parse(model.getEventDate()));
            entity.setCreatedBy(model.getCreatedBy());
            entity.setLastUpdatedBy(model.getLastUpdatedBy());
            entity.setIsOfficial(model.getIsOfficial());
            entity.setCreationDate(new Date());
            entity.setLastUpdatedDate(new Date());
            entity.setStatus("Active");
            eventRepository.save(entity);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>("Failed", HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<?> updateEventDetails(EventModel model) throws ParseException {
        EventEntity entity = eventRepository.findByEventId(model.getEventId());
        if(entity == null){
            return new ResponseEntity<>("Event is not exist on this event id.", HttpStatus.FORBIDDEN);
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if(model.getEventName() != null){
                entity.setEventName(model.getEventName());
            }
            if(model.getEventDate() != null){
                entity.setEventDate(sdf.parse(model.getEventDate()));
            }
            entity.setIsOfficial(model.getIsOfficial());
            entity.setLastUpdatedDate(new Date());
            eventRepository.save(entity);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
    }

    public ResponseEntity<?> removeEventDetailsByEventId(Long eventId) {
        EventEntity entity = eventRepository.findByEventId(eventId);
        eventRepository.delete(entity);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public List<EventModel> getAllEventDetails() {
        List<EventEntity> eventEntities = eventRepository.findAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<EventModel> models = new ArrayList<>();
        eventEntities.forEach(data->{
            EventModel model = new EventModel();
            model.setEventId(data.getEventId());
            model.setEventName(data.getEventName());
            model.setIsOfficial(data.getIsOfficial());
            model.setEventDate(sdf.format(data.getEventDate()));
            model.setCreationDate(sdf.format(data.getCreationDate()));
            model.setLastUpdatedDate(sdf.format(data.getLastUpdatedDate()));
            model.setStatus(data.getStatus());
            model.setCreatedBy(data.getCreatedBy());
            model.setLastUpdatedBy(data.getLastUpdatedBy());
            models.add(model);
        });
        return models;
    }

    public EventModel getEventDetailsByEventId(Long eventId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EventEntity eventEntity = eventRepository.findByEventId(eventId);
        EventModel model = new EventModel();
        model.setEventId(eventEntity.getEventId());
        model.setEventName(eventEntity.getEventName());
        model.setEventDate(sdf.format(eventEntity.getEventDate()));
        model.setIsOfficial(eventEntity.getIsOfficial());
        model.setCreationDate(sdf.format(eventEntity.getCreationDate()));
        model.setLastUpdatedDate(sdf.format(eventEntity.getLastUpdatedDate()));
        model.setStatus(eventEntity.getStatus());
        model.setCreatedBy(eventEntity.getCreatedBy());
        model.setLastUpdatedBy(eventEntity.getLastUpdatedBy());
        return model;
    }

    public List<EventModel> getAllEventInCurrentMonth() {
        List<EventModel> eventModels = new ArrayList<>();
        Date currentDate = new Date();
        System.out.println("currentDate====>"+currentDate);
        // Get the start and end dates of the current month
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startOfMonth = calendar.getTime();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date endOfMonth = calendar.getTime();
        // Fetch all events (This would typically be a database query with a date range filter)
        List<EventEntity> allEvents = eventRepository.findAll();
        // Filter events to only include those in the current month
        for (EventEntity event : allEvents) {
            if (event.getEventDate().compareTo(startOfMonth) >= 0 && event.getEventDate().compareTo(endOfMonth) <= 0) {
                EventModel eventModel = new EventModel();
                eventModel.setEventName(event.getEventName());
                eventModel.setEventDate(sdf.format(event.getEventDate()));
                eventModel.setIsOfficial(event.getIsOfficial());
                eventModel.setCreationDate(sdf.format(event.getCreationDate()));
                eventModel.setLastUpdatedDate(sdf.format(event.getLastUpdatedDate()));
                eventModel.setStatus(event.getStatus());
                eventModel.setCreatedBy(event.getCreatedBy());
                eventModel.setLastUpdatedBy(event.getLastUpdatedBy());
                eventModel.setEventId(event.getEventId());
                eventModels.add(eventModel);
            }
        }
        return eventModels;

    }
}
