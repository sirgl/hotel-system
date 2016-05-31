package ru.nsu.ccfit.rivanov.hotel;

import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.nsu.ccfit.rivanov.hotel.entities.Corpus;
import ru.nsu.ccfit.rivanov.hotel.entities.Floor;
import ru.nsu.ccfit.rivanov.hotel.jpa.CorpusRepository;
//import ru.nsu.ccfit.rivanov.hotel.jpa.PartnerCompanyRepository;

import java.util.Arrays;

@SpringBootApplication
public class Application {
//    @Autowired
//    CorpusRepository repository;

//    @Autowired
//    PartnerCompanyRepository companyRepository;
//
//    @Bean
//    CommandLineRunner init() {
//        return args -> {
////            Corpus entity = new Corpus();
////            Floor floor = new Floor(entity, null);
////            Floor floor1 = new Floor(entity, null);
////            entity.setFloors(Arrays.asList(floor, floor1));
////            repository.save(entity);
////
////
//////            PartnerCompany company = new PartnerCompany();
//////            List<PartnerOrder> orders = new ArrayList<>();
//////            orders.add(new PartnerOrder(company, null));
//////            company.setName("Jessy");
//////            company.setRegistrationDate(new Date());
//////            company.setOrders(orders);
////
//////            companyRepository.save(company);
////            System.out.println("Hello world");
//        };
//
//    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
