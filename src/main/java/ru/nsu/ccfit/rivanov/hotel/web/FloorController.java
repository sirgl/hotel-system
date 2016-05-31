package ru.nsu.ccfit.rivanov.hotel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.rivanov.hotel.entities.Floor;
import ru.nsu.ccfit.rivanov.hotel.entities.Place;
import ru.nsu.ccfit.rivanov.hotel.entities.Room;
import ru.nsu.ccfit.rivanov.hotel.jpa.FloorRepository;
import ru.nsu.ccfit.rivanov.hotel.jpa.RoomRepository;

import java.math.BigDecimal;
import java.util.ArrayList;

@Controller
@RequestMapping("/floors")
public class FloorController {
    @Autowired
    FloorRepository floorRepository;

    @Autowired
    RoomRepository roomRepository;

    @RequestMapping("/{id}")
    public String edit(Model model,
                       @PathVariable long id) throws ItemNotFoundException {
        if (!floorRepository.exists(id)) {
            throw new ItemNotFoundException();
        }
        Floor floor = floorRepository.findOne(id);
        model.addAttribute("floor", floor);
        return "floors/edit";
    }

    @RequestMapping(value = "/{floorId}/add", method = RequestMethod.POST)
    @ResponseBody
    public void addRoom(@RequestParam long number,
                        @RequestParam long places,
                        @RequestParam BigDecimal price,
                        @PathVariable long floorId) throws ItemNotFoundException {
        if (!floorRepository.exists(floorId)) {
            throw new ItemNotFoundException();
        }
        Floor floor = floorRepository.findOne(floorId);

        ArrayList<Place> placeList = new ArrayList<>();
        for (int i = 0; i < places; i++) {
            Place e = new Place();
            placeList.add(e);
        }
        Room room = new Room(number, floor, placeList, price);
        for (Place place : placeList) {
            place.setRoom(room);
        }
        roomRepository.save(room);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    void deleteFloor(@PathVariable long id) {
        if (floorRepository.exists(id)) {
            floorRepository.delete(id);
        }
    }
}
