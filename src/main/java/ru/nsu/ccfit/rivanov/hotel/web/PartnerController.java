package ru.nsu.ccfit.rivanov.hotel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.rivanov.hotel.entities.PartnerCompany;
import ru.nsu.ccfit.rivanov.hotel.jpa.PartnerCompanyRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/partners")
public class PartnerController {
    @Autowired
    private PartnerCompanyRepository companyRepository;

    @RequestMapping("")
    public String partners(Model model) {
        List<PartnerCompany> partnerCompanyList = companyRepository.findAll();
        model.addAttribute("partners", partnerCompanyList);

        return "partners/partners";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editPartner(Model model, @PathVariable long id) throws ItemNotFoundException {
        if (!companyRepository.exists(id)) {
            throw new ItemNotFoundException();
        }
        PartnerCompany company = companyRepository.findOne(id);
        model.addAttribute("companyName", company.getName());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        String formattedDate = format.format(company.getRegistrationDate());
        model.addAttribute("registrationDate", formattedDate);

        return "partners/edit";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void handleEditPartner(@PathVariable long id,
                                  @RequestParam String companyName,
                                  @RequestParam Date date) throws ItemNotFoundException {
        if (!companyRepository.exists(id)) {
            throw new ItemNotFoundException();
        }
        PartnerCompany company = companyRepository.findOne(id);
        company.setName(companyName);
        company.setRegistrationDate(date);
        companyRepository.save(company);
    }

    @RequestMapping("/new")
    public String newPartner(Model model) {
        return "partners/edit";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void handleNewPartner(@RequestParam String companyName,
                                 @RequestParam Date date) throws ItemNotFoundException {
        PartnerCompany company = new PartnerCompany();
        company.setName(companyName);
        company.setRegistrationDate(date);
        companyRepository.save(company);
    }

    @RequestMapping("/new_companies")
    public String newCompanies(Model model,
                               @RequestParam(required = false) String daterange) throws ParseException {
        if (daterange != null) {
            String[] dates = daterange.split(" ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
            Date start = dateFormat.parse(dates[0]);
            Date end = dateFormat.parse(dates[2]);
            List<PartnerCompany> companies = companyRepository.findByRegistrationDateBetween(start, end);
            model.addAttribute("partners", companies);
        }
//        return "newCompaniesByPeriod";
        return "partners/companiesByPeriod";
    }

    @ExceptionHandler(ParseException.class)
    public ResponseEntity<Void> handleParseException() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException() {
        return "partners/notFound";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
