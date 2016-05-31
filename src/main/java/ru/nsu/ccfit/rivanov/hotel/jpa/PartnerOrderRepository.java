package ru.nsu.ccfit.rivanov.hotel.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.rivanov.hotel.entities.PartnerOrder;

public interface PartnerOrderRepository extends JpaRepository<PartnerOrder, Long> {
}
