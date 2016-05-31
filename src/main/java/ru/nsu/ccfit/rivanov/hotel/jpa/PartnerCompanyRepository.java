package ru.nsu.ccfit.rivanov.hotel.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.rivanov.hotel.entities.PartnerCompany;

import java.util.Date;
import java.util.List;

public interface PartnerCompanyRepository extends JpaRepository<PartnerCompany, Long> {

    List<PartnerCompany> findByRegistrationDateBetween(Date startDate, Date endDate);
}
