package com.example.Alightway_Solutions.event.resources;

import com.example.Alightway_Solutions.event.models.EventModel;
import com.example.Alightway_Solutions.event.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/evt")
public class EventResource {

    @Autowired
    private EventService eventService;

    @PostMapping("/saveEventDetails")
    public ResponseEntity<?> saveEventDetails(@RequestBody @Valid EventModel model, BindingResult result){
        HashMap<String, String> errorMap = new HashMap<>();
        if(result.hasErrors()){
            for(FieldError error : result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMap, HttpStatus.FORBIDDEN);
        }else {
            return eventService.saveEventDetails(model);
        }

    }

    @PostMapping("/updateEventDetails")
    public ResponseEntity<?> updateEventDetails(@RequestBody EventModel model) throws ParseException {
        return eventService.updateEventDetails(model);
    }

    @DeleteMapping("/removeEventDetailsByEventId/{eventId}")
    public ResponseEntity<?> removeEventDetailsByEventId(@PathVariable Long eventId){
        return eventService.removeEventDetailsByEventId(eventId);
    }

    @GetMapping("/getAllEventDetails")
    public List<EventModel> getAllEventDetails(){
        return eventService.getAllEventDetails();
    }

    @GetMapping("/getEventDetailsByEventId/{eventId}")
    public EventModel getEventDetailsByEventId(@PathVariable Long eventId){
        return eventService.getEventDetailsByEventId(eventId);
    }

    @GetMapping("/getAllEventInCurrentMonth")
    public List<EventModel> getAllEventInCurrentMonth(){
        return eventService.getAllEventInCurrentMonth();
    }


}
