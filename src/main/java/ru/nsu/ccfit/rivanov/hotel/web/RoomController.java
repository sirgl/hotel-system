package ru.nsu.ccfit.rivanov.hotel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.rivanov.hotel.entities.Place;
import ru.nsu.ccfit.rivanov.hotel.entities.Room;
import ru.nsu.ccfit.rivanov.hotel.jpa.RoomRepository;

import java.math.BigDecimal;
import java.util.ArrayList;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseBody
    public void deleteRoom(@PathVariable long id) {
        if (!roomRepository.exists(id)) {
            return;
        }
        roomRepository.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getRoom(Model model, @PathVariable long id) throws ItemNotFoundException {
        if (!roomRepository.exists(id)) {
            throw new ItemNotFoundException();
        }
        Room room = roomRepository.findOne(id);
        model.addAttribute("room", room);
        return "rooms/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    @ResponseBody
    public void saveRoom(@PathVariable long id,
                           @RequestParam long number,
                           @RequestParam long places,
                           @RequestParam BigDecimal price) throws ItemNotFoundException {
        if (!roomRepository.exists(id)) {
            throw new ItemNotFoundException();
        }
        Room room = roomRepository.findOne(id);
        room.setCost(price);
        room.setNumber(number);
        ArrayList<Place> placeArray = new ArrayList<>();
        for (int i = 0; i < places; i++) {
            Place place = new Place();
            place.setRoom(room);
            placeArray.add(place);
        }
        room.setPlaces(placeArray);
        roomRepository.save(room);
    }
}
