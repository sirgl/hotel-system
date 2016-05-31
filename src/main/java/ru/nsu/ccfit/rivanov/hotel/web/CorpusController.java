package ru.nsu.ccfit.rivanov.hotel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.rivanov.hotel.entities.Corpus;
import ru.nsu.ccfit.rivanov.hotel.entities.Floor;
import ru.nsu.ccfit.rivanov.hotel.jpa.CorpusRepository;
import ru.nsu.ccfit.rivanov.hotel.jpa.FloorRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/corpuses")
public class CorpusController {
    @Autowired
    CorpusRepository corpusRepository;

    @Autowired
    FloorRepository floorRepository;

    @RequestMapping("")
    public String corpuses(Model model) {
        List<Corpus> corpuses = corpusRepository.findAll();
        model.addAttribute("corpuses", corpuses);
        return "corpuses/corpuses";
    }

    @RequestMapping("/new")
    public String editRepository(Model model) throws ItemNotFoundException {
        return "corpuses/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public void createCorpus(@RequestParam String corpusName) {
        Corpus corpus = new Corpus(new ArrayList<>(), corpusName, new ArrayList<>());
        corpusRepository.save(corpus);
    }

    @RequestMapping("/{id}")
    public String editRepository(Model model,
                                 @PathVariable long id) throws ItemNotFoundException {
        if (!corpusRepository.exists(id)) {
            throw new ItemNotFoundException();
        }
        Corpus corpus = corpusRepository.findOne(id);
        model.addAttribute("corpus", corpus);
        return "corpuses/edit";
    }

    @RequestMapping(value = "/{corpusId}/addFloor", method = RequestMethod.GET)
    public String addFloor(Model model, @PathVariable long corpusId) {
        return "corpuses/addFloor";
    }

    @RequestMapping(value = "/{corpusId}/addFloor", method = RequestMethod.POST)
    @ResponseBody
    public long handleAddFloor(@RequestParam long number,
                               @PathVariable long corpusId) throws ItemNotFoundException {
        if (!corpusRepository.exists(corpusId)) {
            throw new ItemNotFoundException();
        }
        Corpus corpus = corpusRepository.findOne(corpusId);
        Floor floor = new Floor(number, corpus, new ArrayList<>());
        Floor saved = floorRepository.save(floor);
        long id = saved.getId();
        return id;
    }

    @RequestMapping(value = "/{corpusId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCorpus(@PathVariable long corpusId){
        if (corpusRepository.exists(corpusId)) {
            corpusRepository.delete(corpusId);
        }
    }
}
