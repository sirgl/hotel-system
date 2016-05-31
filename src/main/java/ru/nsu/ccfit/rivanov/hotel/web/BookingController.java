package ru.nsu.ccfit.rivanov.hotel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.ccfit.rivanov.hotel.entities.Corpus;
import ru.nsu.ccfit.rivanov.hotel.entities.Room;
import ru.nsu.ccfit.rivanov.hotel.jpa.BookingRepository;
import ru.nsu.ccfit.rivanov.hotel.jpa.CorpusRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    CorpusRepository corpusRepository;

    @Autowired
    BookingRepository bookingRepository;

    @RequestMapping("")
    public String booking(Model model,
                          @RequestParam(required = false) String daterange,
                          @RequestParam(required = false) Long corpusId) throws ParseException {
        if(daterange != null && corpusId != null) {
            String[] split = daterange.split(" ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            Date start = dateFormat.parse(split[0]);
            Date end = dateFormat.parse(split[2]);
            List<Room> rooms = bookingRepository.findEmptyRoomsByPeriod(start, end);
//            List<Room> rooms = bookingRepository.findEmptyRoomsByPeriod();
            model.addAttribute("rooms", rooms);
        }
        List<Corpus> corpuses = corpusRepository.findAll();
        model.addAttribute("corpuses", corpuses);
        return "booking/booking";
    }
}
