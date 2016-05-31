package ru.nsu.ccfit.rivanov.hotel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.rivanov.hotel.entities.Booking;
import ru.nsu.ccfit.rivanov.hotel.entities.Visitor;
import ru.nsu.ccfit.rivanov.hotel.jpa.VisitorRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/visitors")
public class VisitorsController {
    @Autowired
    private VisitorRepository visitorRepository;


    @RequestMapping("")
    public String visitors(Model model) {
        List<Visitor> visitors = visitorRepository.findAll();
        model.addAttribute("visitors", visitors);
        return "visitors/visitors";
    }

    @RequestMapping("/add")
    public String addVisitor(Model model) {
        return "visitors/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public void handleAddVisitor(@RequestParam String surname,
                                 @RequestParam String name,
                                 @RequestParam String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date parsedDate = dateFormat.parse(date);
        Visitor visitor = new Visitor(parsedDate, name, surname, new ArrayList<>());
        visitorRepository.save(visitor);
    }

    @RequestMapping("/{id}")
    public String more(Model model, @PathVariable long id) throws ItemNotFoundException {
        if (!visitorRepository.exists(id)) {
            throw new ItemNotFoundException();
        }
        Visitor visitor = visitorRepository.findOne(id);
        model.addAttribute("visitor", visitor);
//        model.addAttribute("bookings", visitor.);
        return "visitors/more";
    }
}
