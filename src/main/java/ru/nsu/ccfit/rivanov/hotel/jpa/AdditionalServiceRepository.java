package ru.nsu.ccfit.rivanov.hotel.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.rivanov.hotel.entities.AdditionalService;

public interface AdditionalServiceRepository extends JpaRepository<AdditionalService, Long> {
}
